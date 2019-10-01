package dxg_thread;

/**
 * @auther 丁溪贵
 * @date 2019/9/10
 *
 *
 *
 *
 *   线程如何优雅的退出
 */
public class ThreadQuit extends  Thread{
/*
    interrupt
    public void interrupt()中断线程。
    如果当前线程没有中断它自己（这在任何情况下都是允许的），
    则该线程的 checkAccess 方法就会被调用，这可能抛出 SecurityException。

    如果线程在调用 Object 类的 wait()、wait(long) 或 wait(long, int) 方法，
    或者该类的 join()、join(long)、join(long, int)、sleep(long) 或 sleep(long, int) 方法过程中受阻，
    则其中断状态将被清除，它还将收到一个 InterruptedException。

    如果该线程在可中断的通道上的 I/O 操作中受阻，则该通道将被关闭，
    该线程的中断状态将被设置并且该线程将收到一个 ClosedByInterruptException。

    如果该线程在一个 Selector 中受阻，则该线程的中断状态将被设置，
    它将立即从选择操作返回，并可能带有一个非零值，就好像调用了选择器的 wakeup 方法一样。

    如果以前的条件都没有保存，则该线程的中断状态将被设置。

    中断一个不处于活动状态的线程不需要任何作用。


    抛出：
    SecurityException - 如果当前线程无法修改该线程*/



    public void run() {
        while(!isInterrupted()){
            try {
                System.out.println("ThreadQuit 一直在工作");
                System.out.println(this.isInterrupted());
                Thread.sleep(3000);

            } catch (InterruptedException e) {
                // 发生异常会将isInterrupted重新设置为false（这非常操蛋），看api说明才知道
                interrupt();             //加上这一句才成功（看我第二个例子）
//                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {

        ThreadQuit threadQuit = new ThreadQuit();
        threadQuit.start();

        Thread.sleep(2000);
        threadQuit.interrupt();// 清除线程的异常状态（不在sleep/wait的状态，此方法无效）

    }
}
