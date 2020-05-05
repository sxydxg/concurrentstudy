package dxg_copyOnWriteArrayList;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @auther 丁溪贵
 * @date 2019/10/18
 */
public class TestCopyOnWriteArrayList2 {

    public static void main(String[] args) {
        CopyOnWriteArrayList list = new CopyOnWriteArrayList();
        list.add("1");
        list.add("2");
        list.add("3");
        Iterator it = list.iterator();
        list.add("4");

        while(it.hasNext()){
            System.out.println(it.next());
        }



        System.out.println("size: "+list.size());

    }
}
