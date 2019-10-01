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
public class Test_ThreadPool2 implements Runnable {


    public static void main(String[] args) {

        ExecutorService pool1 = Executors.newFixedThreadPool(2); // 固定线程池（线程池中只要2个线程）
        for (int i=0;i<5;i++){
            pool1.execute(new Test_ThreadPool2());
        }

        pool1.shutdown();// 所以任务执行完毕，关闭线程池
    }


    public void run() {
        System.out.println(Thread.currentThread().getName());
    }
}
