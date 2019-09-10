package dxg_thread;

/**
 * @auther 丁溪贵
 * @date 2019/9/10
 *
 *   线程如何优雅的退出
 */
public class ThreadQuit2 extends  Thread{


    public void run() {
        while(!isInterrupted()){

                System.out.println("ThreadQuit 一直在工作");
                System.out.println(this.isInterrupted());
        }
    }

    public static void main(String[] args) throws InterruptedException {

        ThreadQuit2 threadQuit = new ThreadQuit2();
        threadQuit.start();

        Thread.sleep(2000);
        threadQuit.interrupt();// 清除线程的异常状态（不在sleep/wait的状态，此方法无效）

    }
}
