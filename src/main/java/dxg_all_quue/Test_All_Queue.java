package dxg_all_quue;

import java.util.Comparator;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.SynchronousQueue;

/**
 * @auther 丁溪贵
 * @date 2019/10/1
 *
 *    介绍一些juc包下常见的队列
 */
public class Test_All_Queue {

    public static void main(String[] args) {

        // 可以将下列绝大部分的队列存储数量调到最大

        // 固定长度的阻塞队列（底层的数据结构为数组）
        ArrayBlockingQueue<Object> q1 = new ArrayBlockingQueue<>(10);
        // 固定长度的阻塞队列（底层的数据结构为链表）
        LinkedBlockingQueue q2 = new LinkedBlockingQueue(10);
        //优先级高的线程一般先执行
        PriorityBlockingQueue<Integer> q3 = new PriorityBlockingQueue<Integer>(10, new Comparator<Integer>() {

            public int compare(Integer o1, Integer o2) {
                return 0;
            }
        });

        //一个不存储元素的阻塞队列。每个插入操作必须等到另一个线程调用移除操作，否则插入操作一直处于阻塞状态，吞吐量通常要高于LinkedBlockingQueue，静态工厂方法Executors.newCachedThreadPool使用了这个队列。
        SynchronousQueue q4 = new SynchronousQueue(true);


    }

}
