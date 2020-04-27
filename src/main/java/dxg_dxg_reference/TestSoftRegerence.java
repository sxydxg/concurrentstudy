package dxg_dxg_reference;

import java.lang.ref.PhantomReference;
import java.lang.ref.SoftReference;

/**
 *  软引用
 *
 * @author dingxigui
 * @date 2020/4/26
 */
public class TestSoftRegerence {

    public static void main(String[] args) {

        //-Xms30M -Xmx30m     最小堆和最大堆大小都设置为30M
        //新生代和老年代的默认比例约为   1:2
        //通过jinfo -flags 命令查看到了
        // -XX:NewSize=10485760      -XX:OldSize=20971520
        //如果分配的这个数字大于20971520这个数字，那么jvm直接报错（java.lang.OutOfMemoryError）
        //因为没有任何一块区域能单独开辟一块这么的内存区域了
        SoftReference<byte []> softReference = new SoftReference<byte []>(new byte[20951510]);

        System.out.println(softReference.get());
        System.gc();
        try {
            //睡10秒
            Thread.sleep(10000);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        SoftReference<byte []> softReference2 = new SoftReference<byte []>(new byte[1024*1024*10]);
        System.out.println(softReference.get());
        System.out.println(softReference2.get());

    }

}
