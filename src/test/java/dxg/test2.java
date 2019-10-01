package dxg;

import java.security.ProtectionDomain;
import java.util.LinkedList;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @auther 丁溪贵
 * @date 2019/9/11
 */
public class test2 {

    public static void main(String[] args) {

      int a=0;
      a=a++ ;
      //  tmep=a=0 ,a++ ,  a=tmep
      System.out.println(a);

        Object c = null;
        c=( null == "" ? 0 :"hh");
    }
}
