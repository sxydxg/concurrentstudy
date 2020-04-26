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
            MyR task = (MyR)r ;
            System.err.println(task.rName+" 被丢弃！");
        }
    }


    public static void main(String[] args) {

        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                5,
                10,
                1000,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<Runnable>(10),
                new SelfThreadFactory(),
                new MyRejectHandler()

        );


        //  10+10 = 20 ,当线程池扩充到最大线程，工作队列满了就会启用拒绝策略
        //创建25个线程
        //如果创建20个线程，则线程扩容到最大10，工作队列堆满10个任务，并不会触发拒绝策略
        for (int i=1;i<=25;i++){
            final int c = i ;
            threadPoolExecutor.execute(new MyR("task"+c));
        }

    }


    private static class MyR implements Runnable{

        public MyR(String rName){
            this.rName = rName ;
        }
        public String rName ;


            @Override
        public void run() {

            System.out.println(Thread.currentThread().getName()+"  : "+rName+" "+" : 开始睡眠！");
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
