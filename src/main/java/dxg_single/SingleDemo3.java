package dxg_single;

/**
 * @auther 丁溪贵
 * @date 2019/9/10
 *
 *  懒汉方式的单例-----通过 synchronized
 */
public class SingleDemo3 {

    private static SingleDemo3 instance ;

    //私有化构造方法
    private  SingleDemo3(){}
    // 同步此方法
    public synchronized static SingleDemo3 getInstance(){

        if(instance==null){
            instance = new SingleDemo3();
            return instance ;
        }
        return instance ;
    }


}
