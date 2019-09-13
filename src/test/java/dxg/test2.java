package dxg;

import java.security.ProtectionDomain;
import java.util.LinkedList;

/**
 * @auther 丁溪贵
 * @date 2019/9/11
 */
public class test2 {

    public static void main(String[] args) {

        LinkedList list = new LinkedList();
        list.add(1);
        list.removeFirst();
        System.out.println(list.getFirst());

    }
}
