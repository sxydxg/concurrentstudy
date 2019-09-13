package dxg_waitAndNotify;

/**
 * @auther 丁溪贵
 * @date 2019/9/12
 */
public class App {


    public static void main(String[] args) {

        new Thread(){

            public void run() {
                new Producer("锁").create();
            }
        }.start();

        new Thread(){

            public void run() {
                new Consumer("锁").consume();
            }
        }.start();
    }
}
