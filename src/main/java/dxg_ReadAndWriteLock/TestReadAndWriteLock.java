package dxg_ReadAndWriteLock;

import java.security.ProtectionDomain;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @auther 丁溪贵
 * @date 2019/9/12
 *
 *  读写锁:
 *      1.读写锁是重重入锁
 *      2.读锁是共享锁
 *      3.写锁是独占锁
 *
 */
public class TestReadAndWriteLock {

    // 资源类
    static class Resource{
        // 创建公平的读写锁
        ReentrantReadWriteLock rwl = new ReentrantReadWriteLock(true);
        // 获取读写锁（这2把锁在rwl创建后就初始化了，为单例对象）
        ReentrantReadWriteLock.ReadLock readLock = rwl.readLock();
        ReentrantReadWriteLock.WriteLock writeLock = rwl.writeLock();

        public void get(){
            readLock.lock();
            System.out.println("读取某种资源");
            try {
                Thread.sleep(3000);         // 加点佐料，睡3秒
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            readLock.unlock();
        }
        public void set(){
            writeLock.lock();
            System.out.println("修改某种资源");
            try {
                Thread.sleep(3000);         // 加点佐料，睡3秒
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            writeLock.unlock();
        }

    }

    public static void main(String[] args) {

        // 创建2个线程，分别不断的调用get/set 方法
        // 读写互斥，你可以看到每隔3秒只会打印一条语句
        final Resource r = new Resource() ;
        //线程1
        new Thread(){

            public void run() {
                while(true){
                    r.get();
                }
            }
        }.start();

        //线程2
        new Thread(){

            public void run() {
                while(true){
                    r.set();
                }
            }
        }.start();





    }



}
