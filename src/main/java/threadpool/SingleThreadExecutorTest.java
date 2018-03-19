package threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

//只包含一个单线程的线程池，串行执行所有任务。如果执行中出现异常退出，会有一个新的线程来替代它
public class SingleThreadExecutorTest {
    public static void main(String[] args) throws InterruptedException {
        /*
            public static ExecutorService newSingleThreadExecutor() {
                return new FinalizableDelegatedExecutorService
                    (new ThreadPoolExecutor(1, 1,
                                            0L, TimeUnit.MILLISECONDS,
                                            new LinkedBlockingQueue<Runnable>()));
            }
         */
        ExecutorService pool = Executors.newSingleThreadExecutor();
        for (int i=0; i<20; i++){
            pool.execute(new MyCommand("znifeng-" + i));
        }
        pool.shutdown();
    }
}
