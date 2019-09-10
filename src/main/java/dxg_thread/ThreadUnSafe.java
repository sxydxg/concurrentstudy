package dxg_thread;

/**
 * @auther 丁溪贵
 * @date 2019/9/10
 * //线程安全问题
 */
public class ThreadUnSafe {

    int count= 0 ;
    public int get(){
        return count++ ;
    }

    public static void main(String[] args) {
        //观察结果看是否有相同的值即可

        final ThreadUnSafe t = new ThreadUnSafe();
        //创建3个线程
        for (int i=0;i<3;i++){
            new Thread(){

                public void run() {
                    while (true){
                        System.out.println(Thread.currentThread().getName()+"--->"+t.get());
                        try {
                            sleep(100); // 为了方便观察，让线程不要执行的那么快
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }.start();
        }

    }
}
