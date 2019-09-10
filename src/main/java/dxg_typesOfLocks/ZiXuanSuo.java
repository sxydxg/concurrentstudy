package dxg_typesOfLocks;

/**
 * @auther 丁溪贵
 * @date 2019/9/10
 *
 *  自旋锁
 */
public class ZiXuanSuo {

    public static void main(String[] args) {
        //创建10个线程
        for (int i=0;i<10;i++){
            new Thread(){
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName());
                }
            }.start();
        }

        // 自旋锁
        while(Thread.activeCount()!=1){
            //只有当存活线程数量为1才停止while循环（也就是只剩一个main线程）
        }
        System.out.println("所有线程执行完毕！");

    }

}
