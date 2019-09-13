package dxg_aqs;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * @auther 丁溪贵
 * @date 2019/9/11
 *
 *    半成品，等下次有时间写
 */
public class MyAQSLock implements Lock {
    // 继承aqs
    private static class MySync extends AbstractQueuedSynchronizer{

        @Override
        protected boolean tryAcquire(int arg) {
            return super.tryAcquire(arg);
        }

        @Override
        protected boolean tryRelease(int arg) {
            return super.tryRelease(arg);
        }
    }
    // 只实现2个方法
    public void lock() {

    }
    // 只实现2个方法
    public void unlock() {

    }

    public void lockInterruptibly() throws InterruptedException {

    }

    public boolean tryLock() {
        return false;
    }

    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return false;
    }



    public Condition newCondition() {
        return null;
    }


}
