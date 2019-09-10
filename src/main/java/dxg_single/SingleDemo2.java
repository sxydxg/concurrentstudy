package dxg_single;

/**
 * @auther 丁溪贵
 * @date 2019/9/10
 *
 *  懒汉方式的单例------线程不安全的
 */
public class SingleDemo2 {

    private static SingleDemo2 instance ;
    //私有化构造方法
    private  SingleDemo2(){}

    public static SingleDemo2 getInstance(){
        if(instance==null){
            instance = new SingleDemo2();
            return instance ;
        }
        return instance ;
    }


}
