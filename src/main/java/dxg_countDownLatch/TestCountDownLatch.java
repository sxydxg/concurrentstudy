package dxg_countDownLatch;

import dxg_condition.TestCondition;

import javax.sound.midi.SoundbankResource;
import java.util.concurrent.CountDownLatch;

/**
 * @auther 丁溪贵
 * @date 2019/9/13
 *
 *    3个人一起玩游戏 ，2个人必须等待最后一个人完成任务才能进入下一关
 */
public class TestCountDownLatch {

    CountDownLatch countDownLatch = new CountDownLatch(3);

    public void A (){
        System.out.println("A已经通关");
        System.out.println("A等待其他人完成...");
        countDownLatch.countDown();
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("A进入下一个关");
    }
    public void B (){
        System.out.println("B已经通关");
        System.out.println("B等待其他人完成...");
        countDownLatch.countDown();
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("B进入下一个关");
    }
    public  void C(){
        try {
            System.out.println("C正再闯关，请其他人等一下");
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("C已经通关");
        System.out.println("C等待其他人完成...");
        countDownLatch.countDown();      // 计数键到0 ，await方法就失效了
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("C进入下一个关");
    }

    public static void main(String[] args) {
        final TestCountDownLatch tcdl = new TestCountDownLatch();
        new Thread(){
            @Override
            public void run() {
                tcdl.A();
            }
        }.start();

        new Thread(){
            @Override
            public void run() {
                tcdl.B();
            }
        }.start();

        new Thread(){
            @Override
            public void run() {
                tcdl.C();
            }
        }.start();

    }

}
