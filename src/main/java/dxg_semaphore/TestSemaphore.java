package dxg_semaphore;

import java.util.Random;
import java.util.concurrent.Semaphore;

/**
 * @auther 丁溪贵
 * @date 2019/9/13
 */
public class TestSemaphore {



    public static void main(String[] args) {
        final Semaphore semaphore = new Semaphore(3); // 3 盏信号灯，每次最多只能有3个线程争抢资源。
        final Random random = new Random();

        for(int i=0;i<10;i++){
            new Thread(){
                public void run() {
                    try {
                        semaphore.acquire();
                        System.out.println(Thread.currentThread().getName()+" 完成了"+" 现在还有"+semaphore.availablePermits()+"盏灯");
                        Thread.sleep(random.nextInt(10)*1000);
                        semaphore.release(); // 释放信号灯
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }.start();
        }



    }


}
