package dxg_waitAndNotify;

/**
 * @auther 丁溪贵
 * @date 2019/9/11
 */
public class Producer {

    private Object lock = null ; //  设置锁对象
    public static boolean flag = false ;
    public Producer(Object lock){
        this.lock = lock ;
    }

    public void create(){


           while(true){
               synchronized (lock){
                   while(flag){  // 如果生产好了产品应该等消费者消费
                       try {
                           lock.wait();  // 怕假醒
                       } catch (InterruptedException e) {
                           e.printStackTrace();
                       }
                   }
                   System.out.println("生产者-->生产了一个产品");
                   flag = true ;
                   lock.notify();
                   try {
                       lock.wait(); // 这一句代码不加也是可以的
                   } catch (InterruptedException e) {
                       e.printStackTrace();
                   }
               }
           }




    }


}
