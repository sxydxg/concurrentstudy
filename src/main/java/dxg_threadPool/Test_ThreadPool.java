package dxg_threadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

/**
 * @auther 丁溪贵
 * @date 2019/10/1
 *
 *   线程池
 */
public class Test_ThreadPool {


    public static void main(String[] args) {

        ExecutorService pool1 = Executors.newCachedThreadPool(); // 缓存线程池
        ExecutorService pool2 = Executors.newFixedThreadPool(10); //固定线程池,超出的线程会在陷入等待状态
        ExecutorService pool3 = Executors.newSingleThreadExecutor();// 单例线程池
        ScheduledExecutorService pool4 = Executors.newScheduledThreadPool(10);//固定线程数的任务调度线程池

//        pool1.execute(Runnable); 执行常规run任务
//        pool1.submit(Callable)   执行带返回值的任务


    }
}
