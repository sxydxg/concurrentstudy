package dxg_blockingQueue;

import java.security.ProtectionDomain;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @auther 丁溪贵
 * @date 2019/9/14
 *
 *   自定义阻塞队列 ---->(简易的，不用太计较了)
 *                      1.这是一个定长的有序队列
 *                      2.先进先出（FIFO）
 */
public class MyBlockingQueue {

    private ReentrantLock lock = new ReentrantLock(true);
    private Condition c1 = lock.newCondition();
    private Condition c2 = lock.newCondition();
    // 频繁增删元素，而且不进行遍历，选用链表是十分合适的数据结构
    private LinkedList list = new LinkedList();
    private final int capacity ;
    public MyBlockingQueue(int capacity){
        this.capacity = capacity ;
    }


    public void put(Object object){
        lock.lock();
        while(list.size()>=capacity){
            try {
                c1.await(); // 循环等待，直到队列数量小于10
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //将元素加入队列当中
        list.addLast(object);
        //唤醒消费的所有线程
        c2.signalAll();
        lock.unlock();

    }

    public Object take(){
        lock.lock();
        while(list.size()<=0){
            try {
                c2.await();    //循环等待，知道，队列数量大于0
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        // 获取第一个元素后，并移除第一个元素
//        Object value = list.getFirst();
//        list.removeFirst();
        Object value = list.poll();
        // 唤醒所有的生产线程
        c1.signalAll();
        lock.unlock();

        return value;
    }


}
