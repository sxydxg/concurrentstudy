package dxg_condition;

/**
 * @auther 丁溪贵
 * @date 2019/9/13
 *
 *  模仿condition ，唤醒指定线程
 */
public class TestLikeCondition {

    int count = 0 ;
    public synchronized void A(){
        while(count!=0){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("A");
        count = 1 ;
        this.notifyAll();
    }
    public synchronized void B(){
        while(count!=1){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("B");
        count = 2 ;
        this.notifyAll();
    }
    public synchronized void C(){
        while(count!=2){
            try {
                this.wait(); // 只要不是 0 就等待
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("C");
        count = 0 ;
        this.notifyAll();
    }
    public static void main(String[] args) {
        final TestLikeCondition tc = new TestLikeCondition();
        //线程1
        new Thread(){
            @Override
            public void run() {
                while(true){
                    tc.A();
                }
            }
        }.start();
        // 线程2
        new Thread(){
            @Override
            public void run() {
                while(true){
                    tc.B();
                }
            }
        }.start();
        // 线程3
        new Thread(){
            @Override
            public void run() {
                while(true){
                    tc.C();
                }
            }
        }.start();


    }



}
