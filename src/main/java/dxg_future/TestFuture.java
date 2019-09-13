package dxg_future;

import org.omg.PortableServer.THREAD_POLICY_ID;

import java.util.concurrent.*;

/**
 * @auther 丁溪贵
 * @date 2019/9/13
 */
public class TestFuture {

    public static void main(String[] args) {

        FutureTask futureTask = new FutureTask(new Callable() {
            public Object call() throws Exception {
                Thread.sleep(5000);
                return "你好啊！";
            }
        });


        try {
            ExecutorService pool = Executors.newCachedThreadPool();
            pool.execute(futureTask);

            System.out.println("等待结果");
            Object res = futureTask.get();
            System.out.println("res = "+res);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }
}
