package dxg_deadlock;

/**
 * @auther 丁溪贵
 * @date 2019/9/10
 *
 *          演示死锁现象：
 *          创建2个线程分别去执行Resource类的get1()/get2()方法，
 *
 */
public class TestDeadLock {

    //一个静态内部类
    public static class Resoure{

        String lock1 = "我是第一把锁" ;   // 一把锁
        String lock2 = "我是第二把锁" ;   //另一把锁

        public void get1(){

            synchronized (lock1){
                try {
                    Thread.sleep(1000); //睡一秒
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (lock2){

                }
            }

        }
        public void get2(){

            synchronized (lock2){
                try {
                    Thread.sleep(1000);  //睡一秒
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (lock1){

                }
            }
        }

    }

    public static void main(String[] args) {

        final Resoure r = new Resoure();

        //线程1------------->调用get1()方法
        new Thread(){
            @Override
            public void run() {
                r.get1();
            }
        }.start();

        //线程2-------> 该线程调用get2()方法
        new Thread(){
            @Override
            public void run() {
                r.get2();
            }
        }.start();
    }

}
