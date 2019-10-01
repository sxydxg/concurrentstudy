package dxg_blockingQueue;

import java.util.Random;

/**
 * @auther 丁溪贵
 * @date 2019/9/14
 */
public class App {

    public static void main(String[] args) {

        final MyBlockingQueue queue = new MyBlockingQueue(5);
        final Random r = new Random();
        for(int i=0;i<3;i++) {
            new Thread() {

                public void run() {
                    while (true) {

                        queue.take();
                        System.out.println(Thread.currentThread().getName() + ": 已经take值成功！");
                    }
                }
            }.start();
        }

        new Thread(){
            public void run() {
                while(true){
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    queue.put(r.nextInt(1000));
                    System.out.println(Thread.currentThread().getName() + ": 已经put值成功！");
                }

            }
        }.start();

    }
}
