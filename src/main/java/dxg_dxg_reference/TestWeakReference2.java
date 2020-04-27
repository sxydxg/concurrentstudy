package dxg_dxg_reference;

import javax.sound.midi.SoundbankResource;
import java.lang.ref.WeakReference;

/**
 * 类说明
 *
 * @author dingxigui
 * @date 2020/4/26
 */
public class TestWeakReference2 {
    /**
     *
     *   默认初始化堆大小为内存的 1/64  ，16个g为250M ，   新生代80m左右，老年代170m左右，加起来==初始化堆大小
     * -XX:CICompilerCount=4 -XX:InitialHeapSize=266338304 -XX:MaxHeapSize=4255121408 -XX:MaxNewSize=1418199040 -XX:MinHeapDeltaBytes=524288
     * -XX:NewSize=88604672 -XX:OldSize=177733632 -XX:+UseCompressedClassPointers -XX:+UseCompressedOops -XX:+UseFastUnorderedTimeStamps -XX:-UseLargePagesIndividualAllocation -XX:+UseParallelGC
     Command line:  -javaagent:C:\Program Files\JetBrains\IntelliJ IDEA 2017.3.5\lib\idea_rt.jar=64549:C:\Program Files\JetBrains\IntelliJ IDEA 2017.3.5\bin -Dfile.encoding=UTF-8
     */
    public static void main(String[] args) {



        WeakReference<byte[]> weakReference = new WeakReference<>(new byte[1024*1024*10]);
        System.out.println(weakReference.get());
        //建议Gc（而且是fullGc）
        System.gc();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {

        }
        // null
        System.out.println(weakReference.get());
    }
}
