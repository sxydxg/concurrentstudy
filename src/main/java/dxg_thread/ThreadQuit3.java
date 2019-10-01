package dxg_thread;

/**
 * @auther 丁溪贵
 * @date 2019/9/10
 *
 *   线程如何优雅的退出
 */
public class ThreadQuit3 extends  Thread{


    public void run() {
        while(!isInterrupted()){

                System.out.println("ThreadQuit 一直在工作");
                System.out.println(this.isInterrupted());
        }
    }

    public static void main(String[] args) throws InterruptedException {

        // 几种中断的效果
        ThreadQuit3 threadQuit3 = new ThreadQuit3();

        Thread.interrupted(); // 返回当前线程的中断状态，并将当前线程的中断状态设置为false

        threadQuit3.isInterrupted();// 返回当前线程的中断状态

        // 将指定指定线程的中断状态设置为true，
        // 如果该线程对象正处于 join、sleep、wait、等待io流阻塞状态，将会会抛出异常，并且jvm会将该线程对象的中断状态设置为false
        threadQuit3.interrupt();
    }
}
