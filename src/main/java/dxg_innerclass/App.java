package dxg_innerclass;

import java.security.ProtectionDomain;

/**
 * @auther 丁溪贵
 * @date 2019/9/10
 *
 *    本包下所有类与并发无关 ， 可以忽略
 */
public class App {

    public static void main(String[] args) {

        People p  = new People("丁丁历险记"){}; //调用了父类的构造方法
        System.out.println(p.name);
    }
}
