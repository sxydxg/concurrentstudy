package dxg_condition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @auther 丁溪贵
 * @date 2019/9/13
 *
 *
 *      condition 可以唤醒指定线程
 */
public class TestCondition {

    ReentrantLock lock = new ReentrantLock(true);
    Condition c1 = lock.newCondition();
    Condition c2 = lock.newCondition();
    Condition c3 = lock.newCondition();
    int count = 0 ;
    public void A(){
        lock.lock();
        while(count!=0){
            try {
                c1.await(); // 只要不是 0 就等待
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("A");
        c2.signal(); //唤醒c2
        count = 1 ;
        lock.unlock();
    }
    public void B(){
        lock.lock();
        while(count!=1){
            try {
                c2.await(); // 只要不是 0 就等待
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("B");
        c3.signal();
        count = 2 ;
        lock.unlock();

    }
    public void C(){
        lock.lock();
        while(count!=2){
            try {
                c3.await(); // 只要不是 0 就等待
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("C");
        c1.signal();
        count = 0 ;
        lock.unlock();
    }


    public static void main(String[] args) {
        final TestCondition tc = new TestCondition();
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
