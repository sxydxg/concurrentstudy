package dxg_single;

/**
 * @auther 丁溪贵
 * @date 2019/9/10
 *
 *   双重if的锁
 */
public class SingleDemo4 {

    private static SingleDemo4 instance ;
    //私有化构造方法
    private  SingleDemo4(){}
    // 双重if判断，效率非常之高
    public static SingleDemo4 getInstance(){
        if(instance==null){
            synchronized(SingleDemo4.class){
                if (instance==null){
                    instance = new SingleDemo4();
                    return instance ;
                }
            }

        }

        return instance ;
    }


}
