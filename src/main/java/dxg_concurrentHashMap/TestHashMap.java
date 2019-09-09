package dxg_concurrentHashMap;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @auther 丁溪贵
 * @date 2019/9/9
 *
 *       encoding utf-8
 *      我提供的单线程和多线程并发修改异常的演示例子。
 *
 */
public class TestHashMap {

    public static void main(String[] args) {

//        SingleThread(); //单线程版
        manyThread();       //多线程版

    }


    //单程版并发修改异常
    public static void SingleThread(){
        System.out.println("单线程版并发修改异常例子！！！");
        // 普通map
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("1","1");
        map.put("2","2");
        //开始迭代
        Iterator<Map.Entry<String, String>> it = map.entrySet().iterator();
        // 取出一个元素
        it.next();
        //修改map里面的元素
        map.put("3","3");
        //在使用迭代器取出下一个元素
        it.next();  //             modCount的值与预期的不一致，抛出并发修改异常
    }

    //多线程版并发修改异常（英语不好不要介意）
    public static void manyThread(){
        System.out.println("多线程版并发修改异常例子！！！");
        // 普通map
        final HashMap<String, String> map = new HashMap<String, String>();
        map.put("1","1");
        map.put("2","2");

        //线程1负责迭代map中的元素
        new Thread(){
            @Override
            public void run() {
                Iterator<Map.Entry<String, String>> it = map.entrySet().iterator();
                //开始迭代
                while(it.hasNext()){
                    try {
                        Thread.sleep(2000); // 为了保证map.put(xx,xx)在迭代的过程发生，需要做一点小的操作
                        it.next();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }
        }.start();

        //线程2负责网map中添加一个元素
        new Thread(){
            @Override
            public void run() {

                try {
                    Thread.sleep(3000); // 为了保证map.put(xx,xx)在迭代的过程发生，需要做一点小的操作
                    map.put("3","3");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();

        //线程1每次迭代睡2秒，线程3执行前睡3秒--------你懂的，我相信大家应该都能理解我的苦心！！！

    }


}
