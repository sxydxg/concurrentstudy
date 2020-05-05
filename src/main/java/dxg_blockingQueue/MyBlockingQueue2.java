package dxg_blockingQueue;

import java.util.LinkedList;
import java.util.List;

/**
 *   性能会非常低
 *
 * @author dingxigui
 * @date 2020/4/25
 */
public class MyBlockingQueue2 {

    String lock = "lock" ;

    LinkedList list = new LinkedList();
    private int capacity = 0 ;

    public MyBlockingQueue2(int capacity){
        this.capacity = capacity ;

    }


    public  void put(Object object){
        synchronized(lock){
            while(list.size()>=capacity) {
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            lock.notifyAll();

            list.add(object);


        }

    }

    public Object pop(){
        synchronized(lock){
            while(list.size()<=0){
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            lock.notifyAll();
            Object o = list.removeFirst();
            //唤醒添加
            return o ;
        }

    }






}
