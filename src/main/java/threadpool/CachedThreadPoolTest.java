package threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

//可缓存线程池，灵活回收空闲线程，无可回收，则创建新的线程，最大长度限制为MAX。线程数可无限扩展，基本用不到等待队列
/**
 * Creates a thread pool that creates new threads as needed, but
 * will reuse previously constructed threads when they are
 * available.  These pools will typically improve the performance
 * of programs that execute many short-lived asynchronous tasks.
 * Calls to {@code execute} will reuse previously constructed
 * threads if available. If no existing thread is available, a new
 * thread will be created and added to the pool. Threads that have
 * not been used for sixty seconds are terminated and removed from
 * the cache. Thus, a pool that remains idle for long enough will
 * not consume any resources. Note that pools with similar
 * properties but different details (for example, timeout parameters)
 * may be created using {@link ThreadPoolExecutor} constructors.
 *
 * @return the newly created thread pool
 */
//适合短生命周期的异步任务，按需创建新的线程。旧线程如果超过60s没被使用，则会自动销毁。当没有线程需要运行时，线程池可以不消耗任何资源
public class CachedThreadPoolTest {
    /* newCachedThreadPool()方法，线程的默认存活时间为60s
        public static ExecutorService newCachedThreadPool() {
        return new ThreadPoolExecutor(0, Integer.MAX_VALUE,
                                      60L, TimeUnit.SECONDS,
                                      new SynchronousQueue<Runnable>());
    }
     */

    public static void main(String[] args) throws InterruptedException {
        ExecutorService pool = Executors.newCachedThreadPool();
        for (int i =0; i<20; i++){
            pool.execute(new MyCommand("znifeng-" + i));
            Thread.sleep(10000);
        }
    }
}
