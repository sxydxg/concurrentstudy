package dxg_threadPool;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 *
 * @author dingxigui
 * @date 2020/4/26
 */
public class Test_ThreadPool3 {


    private static class SelfThreadFactory implements ThreadFactory{
        AtomicInteger number = new AtomicInteger(1);

        @Override
        public Thread newThread(Runnable r) {
            Thread thread = new Thread(r);
            thread.setName("ding"+number.getAndIncrement());
            //设置类上下文类加载器
            //thread.setContextClassLoader();
            //设置类的优先级
            //thread.setPriority();
            //设置是否为守护线程
            //thread.setDaemon();
            //设置未捕获异常处理器
            thread.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
                @Override
                public void uncaughtException(Thread t, Throwable e) {
                    //处理该异常：简单打印线程和异常消息
                    System.out.println(t.getName()+e.getMessage());
                }
            });

            return thread;
        }
    }

    private static class MyRejectHandler implements RejectedExecutionHandler{

        @Override
        public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
            System.out.println("处理当一个人");
        }
    }


    public static void main(String[] args) {

        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                10,
                20,
                100,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<Runnable>(10),
                new SelfThreadFactory(),
                new MyRejectHandler()

        );


        threadPoolExecutor.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("执行一个线程！");
            }
        });

    }
}
