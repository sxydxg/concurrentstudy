package dxg_copyOnWriteArrayList;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @auther 丁溪贵
 * @date 2019/9/14
 *
 *      读写分离的ArrayList
 *      // 通过观看源码可知
 *
 *      1.每次add（该方法使用了lock同步），创建一个当前数组长度+1 的新数组，
 *        将原来的元素和新元素添加到这个新数组中，并让list指向该新数组
 *      2.当调用Iterator方法会将list的数组引用赋值给COWIterator（CopyOnWriteIterator）
 *      3.只要对list元素进行了修改（增，删，改）都会进行创建新数组，并开始相应的赋值操作，且这些操作都是同步方法
 *      4.读操作都使用无所操作（如get，Iterator），原因是都是获取摸个时刻的list中array的元素，
 *         每次读要读取的是增，删，改之前的array数据，要么是增，删，改之后的数据，并不会造成线程安全问题。
 *
 *
 *
 *      适用于大量读操作，因为写的操作太消耗性能了
 */
public class TestCopyOnWriteArrayList {

    public static void main(String[] args) {

//      CopyOnWriteArrayList的源码真的是非常简单
        CopyOnWriteArrayList list = new CopyOnWriteArrayList();
        list.add("1");
        list.get(0);
        list.remove("1");
        list.set(0,"2");

//      new COWIterator<E>(getArray(), 0); getArray() {return array}返回的是list内部数组，
//      这样就可以避免并发修改异常了
        Iterator iterator = list.iterator();
        list.toArray(); //Arrays.copyOf(elements, elements.length);


    }

}
