package dxg_waitAndNotify;

/**
 * @auther 丁溪贵
 * @date 2019/9/12
 */
public class TestNotifyAll {


    static class R {
        int count = 0 ;
        public synchronized void set(){
            while(count>=10){
                try {
                    System.out.println(Thread.currentThread().getName()+ "生产者 陷入等待");
                    wait();                       // 被唤醒的线程，继续争抢锁，抢到锁的才能继续执行
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            count ++ ;
            System.out.println(Thread.currentThread().getName()+ ":  生产者产品： "+count);
            notifyAll();
        }
        public synchronized void get(){
            while(count<=0){
                try {
                    System.out.println(Thread.currentThread().getName()+ "消费者 陷入等待");
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            count -- ;
            System.out.println(Thread.currentThread().getName()+ " : 消费者消费： "+count);
            notifyAll();
        }


    }

    public static void main(String[] args) {

        final R r = new R();
        new Thread(){
            @Override
            public void run() {
                while(true){
                    r.set();
                }

            }
        }.start();
        new Thread(){
            @Override
            public void run() {
                while(true){
                    r.set();
                }

            }
        }.start();
        new Thread(){
            @Override
            public void run() {
                while(true){
                    r.set();
                }

            }
        }.start();
        new Thread(){
            @Override
            public void run() {
                while(true){
                    r.get();
                }

            }
        }.start();

    }

}
