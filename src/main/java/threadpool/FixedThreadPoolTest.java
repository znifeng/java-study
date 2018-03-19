package threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

//固定线程池大小
/**
 * Creates a thread pool that reuses a fixed number of threads
 * operating off a shared unbounded queue.  At any point, at most
 * {@code nThreads} threads will be active processing tasks.
 * If additional tasks are submitted when all threads are active,
 * they will wait in the queue until a thread is available.
 * If any thread terminates due to a failure during execution
 * prior to shutdown, a new one will take its place if needed to
 * execute subsequent tasks.  The threads in the pool will exist
 * until it is explicitly {@link ExecutorService#shutdown shutdown}.
 *
 * nThreads - the number of threads in the pool
 * @return the newly created thread pool
 * @throws IllegalArgumentException if {@code nThreads <= 0}
 */
//使用一个共用的无边界的等待队列BlockingQueue。线程会一直存在，除非被显式地shutdown。线程池的大小一旦达到最大值就会保持不变，如果某个线程执行出现异常，线程池会补充一个新线程。
public class FixedThreadPoolTest {
    /* ThreadPoolExecutor的四种构造函数
        1. ThreadPoolExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime,
        TimeUnit unit, BlockingQueue<Runnable> workQueue)

        2. ThreadPoolExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime,
        TimeUnit unit, BlockingQueue<Runnable> workQueue, RejectedExecutionHandler handler)

        3. ThreadPoolExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime,
        TimeUnit unit, BlockingQueue<Runnable> workQueue, ThreadFactory threadFactory)

        4. ThreadPoolExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime,
        TimeUnit unit, BlockingQueue<Runnable> workQueue, ThreadFactory threadFactory, RejectedExecutionHandler handler)

     */

    /* newFixedThreadPool(int nThreads)方法：将corePoolSize和maximumPoolSize都置为nThreads
        public static ExecutorService newFixedThreadPool(int nThreads) {
            return new ThreadPoolExecutor(nThreads, nThreads,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>());
        }
     */
    public static void main(String[] args) throws InterruptedException {
        ExecutorService pool = Executors.newFixedThreadPool(2);
        for (int i=0; i<20; i++){
            pool.execute(new MyCommand("znifeng-" + i));
            Thread.sleep(10000);
        }
        pool.shutdown();
    }
}
