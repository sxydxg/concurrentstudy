package dxg;

import javax.sound.midi.SoundbankResource;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Lock;

/**
 * @auther 丁溪贵
 * @date 2019/9/9
 *
 *  sleep          ------自动唤醒，超时后自动进入就绪状态
 *  wait/notify/notifyAll (需要有监视器状态，可以理解为被synchronized同步区域)    ---- 需要手动唤醒
 */
public class test {

    public static void main(String[] args) throws IOException {

//        Lock

        new Thread(){

            @Override
            public void run() {
                System.out.println("主线程启动了");
                Thread t = new Thread(){
                    @Override
                    public void run() {
                        System.out.println("守护线程启动了");
                        while(true){
                            System.out.println("守护线程一直在工作");
                        }

                    };
                };

                t.setDaemon(true);
                t.start();
                try {
                    sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("主线程执行完毕");
            }
        }.start();

        System.in.read();
    }

}
