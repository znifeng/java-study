package threadpool;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolExecutorTest {
    private static final int NTREADS= 4;

    private ThreadPoolExecutor tpe =  new ThreadPoolExecutor(NTREADS, NTREADS,
                                      0L,TimeUnit.MILLISECONDS,
                                      new LinkedBlockingQueue<Runnable>());
    private int count=0;

    public void test(){
        for (int i=0; i<10; i++) {
            tpe.execute(new Runnable() {
                @Override
                public void run() {
                    int j = 0;
                    while (j < 200) {
                        j++;
                        synchronized (ThreadPoolExecutorTest.class){
                            count++;
                        }
                        try {
                            Thread.sleep(1);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            });
        }
        tpe.shutdown();
    }

    public void read() throws InterruptedException {
        System.out.println("Shutdown: " + tpe.isShutdown());
        System.out.println("Terminated: "+ tpe.isTerminated());
        System.out.println("ActiveThreads: " + tpe.getActiveCount());
        System.out.println(count);
        Thread.sleep(5000);
        System.out.println("ActiveThreads: " + tpe.getActiveCount());
        System.out.println(count);
    }

    public static void main(String[] args) throws InterruptedException {
        ThreadPoolExecutorTest t = new ThreadPoolExecutorTest();
        t.test();
        t.read();

    }
}
