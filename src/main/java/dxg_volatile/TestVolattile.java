package dxg_volatile;

/**
 * @auther 丁溪贵
 * @date 2019/9/9
 * encoding utf-8
 *
 *  测试volatile关键字的线程不可见问题
 *  思路：开启2个线程去操作一个int类型的公共变量count，每次操作count，都将count++，
 *  不管count值是多少一定是奇数或者偶数，2个线程一定会不断的执行下去。
 *      但是由于线程不可见，线程都各自缓存了变量没有更新，就会导致2个线程都在执行一段时间后停止执行
 *
 *  测试方法：  对count变量 去掉 volatie关键字和加上volatile关键字，分别观察二者的情况即可
 */
public class TestVolattile {

    volatile int count = 0;  // 去掉volatile关键字，程序只会运行一段时间就会停止


    public static void main(String[] args) {

        final TestVolattile tv = new TestVolattile();
        //线程1
        new Thread(){

            @Override
            public void run() {
                while(true){
                    // if里面的操作都不是原子操作
                    if(tv.count%2==0){
                        tv.count++; // 变成奇数
                        System.out.println("count 为偶数");
                    }
                }


            }
        }.start();

        // 线程2
        new Thread(){

            @Override
            public void run() {
                while(true){
                    // if里面的操作都不是原子操作
                    if(tv.count%2==1){
                        tv.count++; // 变成偶数
                        System.out.println("count 为奇数");
                    }
                }


            }
        }.start();


    }


}
