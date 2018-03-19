package threadpool;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

//支持延时、周期性的执行任务

/*
     public ScheduledThreadPoolExecutor(int corePoolSize) {
        super(corePoolSize, Integer.MAX_VALUE, 0, NANOSECONDS,
              new DelayedWorkQueue());
    }
 */
public class ScheduledThreadPoolTest {
    public static void main(String[] args) {
        ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(2);
        Runnable t1 = new MyCommand("znifeng");
        Runnable t2 = new MyCommand("cy");
        Runnable t3 = new MyCommand("dongdong");

        //schedule(Runnable command, long delay, TimeUnit unit);
        //仅执行一次
        scheduledThreadPool.schedule(t1, 1L, TimeUnit.SECONDS);

        //scheduleAtFixedRate(Runnable command, long initialDelay, long period, TimeUnit unit);
        //周期性执行，每隔period时间执行一次。如果command执行时间大于period，则command执行完一次后立即执行下一次
        scheduledThreadPool.scheduleAtFixedRate(t2, 1L, 4L, TimeUnit.SECONDS);

        //scheduleWithFixedDelay(Runnable command, long initialDelay, long delay, TimeUnit unit);
        //周期性执行，command执行完一次后，会等待固定时间delay，再执行下一次
        scheduledThreadPool.scheduleWithFixedDelay(t3, 0L, 4L, TimeUnit.SECONDS);

    }
}