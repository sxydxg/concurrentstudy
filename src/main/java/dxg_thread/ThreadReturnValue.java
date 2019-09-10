package dxg_thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @auther 丁溪贵
 * @date 2019/9/10
 *
 *  测试有返回值的线程任务
 */
public class ThreadReturnValue {

    //拥有返回值的任务
    static public class DXGTask implements Callable<Integer>{

        public Integer call() throws Exception {

            System.out.println("我正在准备。。。");
            Thread.sleep(3000);
            return 1000;
        }
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        FutureTask<Integer> ft = new FutureTask<Integer>(new DXGTask());

        //开启一个线程
        new Thread(ft).start();

        // 阻塞，直到ft返回值
        System.out.println("我至于获取到返回值了： "+ft.get());
    }
}
