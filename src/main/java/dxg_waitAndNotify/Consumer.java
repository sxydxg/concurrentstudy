package dxg_waitAndNotify;

/**
 * @auther 丁溪贵
 * @date 2019/9/11
 *
 *     目的： 演示2个线程交替执行
 *           一个线程执行一下
 */
public class Consumer {

    private Object lock = null ; //  设置锁对象
    public Consumer(Object lock){
        this.lock = lock ;
    }


    public void consume(){
        while(true){
            synchronized (lock){
                while(!Producer.flag){
                    try {
                        lock.wait(); // 等待生产者生产商品
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("消费者————>消费了一个产品");
                Producer.flag = false ;
                lock.notify();           // 执行完syn区域会去唤醒其他线程
            }

        }

    }
}
