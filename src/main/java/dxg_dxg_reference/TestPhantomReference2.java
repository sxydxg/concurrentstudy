package dxg_dxg_reference;

import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

/**
 * 虚引用
 *
 *
 *
 * @author dingxigui
 * @date 2020/4/26
 */
public class TestPhantomReference2 {

    static volatile ReferenceQueue<Object> queue = new ReferenceQueue<>();
    public static void main(String[] args) {

        byte[] buffer = new byte[1024*1024*100];

        final PhantomReference<byte[]> phantomReference = new PhantomReference<>(buffer, queue);

        System.out.println("main : "+phantomReference.get());

        new Thread(){
            @Override
            public void run() {
                for (;;){
                    Reference<?> poll = queue.poll();
                    System.out.println(poll);
                    if (poll!=null){
                        break ;
                    }
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {

                    }
                }
            }
        }.start();


        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        byte[] buffer2 = new byte[1024*1024*100];
        buffer = null ;
    }
}
