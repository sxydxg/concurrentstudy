package dxg_aqs;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @auther 丁溪贵
 * @date 2019/9/11
 */
public class View_AQS {


    public static void main(String[] args) {

        ReentrantLock lock = new ReentrantLock();
        lock.lock();

        lock.unlock();

    }
}
