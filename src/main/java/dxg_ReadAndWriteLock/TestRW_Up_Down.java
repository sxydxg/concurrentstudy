package dxg_ReadAndWriteLock;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @auther 丁溪贵
 * @date 2019/9/12
 *
 *   读写锁的降级和升级：
 *      1.在读锁内加上写锁------锁升级，读锁升级为写锁
 *      2.在写锁内加上读锁--------锁降级，写锁降级为读锁
 *
 *
 */
public class TestRW_Up_Down {

    // 资源类
    static class Resource{
        // 创建公平的读写锁
        ReentrantReadWriteLock rwl = new ReentrantReadWriteLock(true);
        // 获取读写锁（这2把锁在rwl创建后就初始化了，为单例对象）
        ReentrantReadWriteLock.ReadLock readLock = rwl.readLock();
        ReentrantReadWriteLock.WriteLock writeLock = rwl.writeLock();

        public void get(){


            writeLock.lock();
            System.out.println("修改值");
            readLock.lock();


            readLock.unlock();
            writeLock.unlock();



        }
        public void mysleep(){
            try {
                System.out.println("打印某些值,需要1秒钟！");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


    }



}
