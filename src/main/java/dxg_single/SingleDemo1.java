package dxg_single;

/**
 * @auther 丁溪贵
 * @date 2019/9/10
 *                      线程是安全的
 */
public class SingleDemo1 {

    //恶汉方式的单例
    private static SingleDemo1 instacne = new SingleDemo1();
    //私有化构造方法
    private  SingleDemo1(){}

    public static SingleDemo1 getInstacne(){
        return SingleDemo1.instacne ;
    }


    public static void main(String[] args) {

    }


}
