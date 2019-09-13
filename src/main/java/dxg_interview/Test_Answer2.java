package dxg_interview;

import com.sun.org.apache.xalan.internal.xsltc.runtime.ErrorMessages_ca;

import javax.sound.midi.SoundbankResource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.concurrent.ArrayBlockingQueue;

public class Test_Answer2 {

       public static void main(String[] args) throws InterruptedException {

           System.out.println("begin:"+(System.currentTimeMillis()/1000));
           /*模拟处理16行日志，下面的代码产生了16个日志对象，当前代码需要运行16秒才能打印完这些日志。
           修改程序代码，开四个线程让这16个对象在4秒钟打完。
           */

           //没有帮助类
           //final LinkedList list = Collections.synchronizedList(new LinkedList());
           final LinkedList list = new LinkedList();
           for(int i=0;i<16;i++){  //这行代码不能改动  
               final String log = ""+(i+1);//这行代码不能改动  
               {
                   list.add(log);
               }  
           }

           for (int i=0;i<4;i++){
                new Thread(){
                    @Override
                    public void run() {
                        while (true){
                            String log = null ;
                            try {
                                synchronized (Test_Answer2.class){
                                    log = (String) list.getFirst();
                                    list.removeFirst();
                                }

                                Test_Answer2.parseLog(log); // 这一段代码顺序会乱

                            }catch (Exception e){
                                break;
                            }




                        }
                    }
                }.start();
           }

       }  
         
       //parseLog方法内部的代码不能改动  
       public static void parseLog(String log){  
           System.out.println(log+":"+(System.currentTimeMillis()/1000));  
             
           try {  
               Thread.sleep(1000);  
           } catch (InterruptedException e) {  
               e.printStackTrace();  
           }          
       }  





   }