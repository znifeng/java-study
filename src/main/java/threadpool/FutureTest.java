package threadpool;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

public class FutureTest {
    public static void main(String[] args) throws Exception{
        ThreadFactory threadFactory = new ThreadFactoryBuilder()
            .setNameFormat("dani-pool-%d").build();
        ExecutorService pool = new ThreadPoolExecutor(10, 10,
            0L, TimeUnit.MILLISECONDS,
            new LinkedBlockingQueue<>(), threadFactory, new ThreadPoolExecutor.AbortPolicy());
        List<Callable<Object>> multiThreadTestTasks = new ArrayList<>();
        multiThreadTestTasks.add(new Callable() {
            @Override
            public Object call() throws Exception {
                System.out.println(Thread.currentThread().getName() + " with mycommand name zni start.");
                Thread.sleep(5000);
                return "hello-1";
            }
        });
        multiThreadTestTasks.add(new Callable() {
            @Override
            public Object call() throws Exception {
                System.out.println(Thread.currentThread().getName() + " with mycommand name cy start.");
                Thread.sleep(5000);
                return "hello -2";
            }
        });
        List<Future<Object>> futures = pool.invokeAll(multiThreadTestTasks);
        for(Future<Object> future : futures){
            System.out.println(future.get());
        }
        System.out.println("end hello world");
        pool.shutdown();
    }


}
