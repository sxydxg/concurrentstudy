package dxg_atomicClass;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @auther 丁溪贵
 * @date 2019/9/11
 *
 *
 *      该类使用原子类修改了   dxg_thread.ThreadUnSafe
 */
public class TestSequence {

    AtomicInteger count = new AtomicInteger(0);


    // 先获得值在自增（原子类在使用CAS算法设置成功后就会返回当前）
    // currentValue,nextValue=cueentValue---->usr CAS is Ok-----reutrn currentValue
    public int get(){
        return count.getAndIncrement() ;
    }

    public static void main(String[] args) {
        //观察结果看是否有相同的值即可

        final TestSequence t = new TestSequence();
        //创建3个线程
        for (int i=0;i<3;i++){
            new Thread(){

                public void run() {
                    while (true){
                        System.out.println(Thread.currentThread().getName()+"--->"+t.get());
                        try {
                            sleep(100); // 为了方便观察，让线程不要执行的那么快
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }.start();
        }

    }

}
