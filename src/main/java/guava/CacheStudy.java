package guava;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.cache.RemovalListener;
import com.google.common.cache.RemovalNotification;

/**
 * 参考文章：https://segmentfault.com/a/1190000011105644
 */
public class CacheStudy {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        System.out.println("LoadingCache Study");
        CacheLoader<String, String> loader = new CacheLoader<String, String>() {
            @Override
            public String load(String key) throws Exception {
                Thread.sleep(1000);
                System.out.println(key + " is loaded from a cacheLoader!");
                return key + "'s value";
            }
        };

        LoadingCache<String,String> loadingCache = CacheBuilder.newBuilder()
            .maximumSize(3)
            .build(loader);

        loadingCache.get("key1");
        loadingCache.get("key2");
        loadingCache.get("key3");

        System.out.println("Cache Study");

        RemovalListener<String, String> listener =  (RemovalNotification<String, String> removalNotification) -> System.out.println("[" + removalNotification.getKey() + ":" + removalNotification.getValue() + "] is removed!");

        Cache<String, String> myCache =  CacheBuilder.newBuilder()
            .maximumSize(2)
            .expireAfterWrite(200, TimeUnit.SECONDS)
            .removalListener(listener)
            //.recordStats()
            .build();

        myCache.put("key1", "value1");
        myCache.put("key2", "value2");
        myCache.put("key3", "value3");
        myCache.put("key3", "new-value3");

        int n=5;
        while (n-- >0){
            System.out.println("-----------------------------");
            System.out.println(myCache.getIfPresent("key1"));
            System.out.println(myCache.getIfPresent("key2"));
            System.out.println(myCache.getIfPresent("key3"));
            System.out.println(myCache.get("key4", ()->{
                System.out.println("I am reload");
                return "autoload";
            }));
            Thread.sleep(1000);
            System.out.println("==============================");
        }
        myCache.invalidateAll();


    }
}
