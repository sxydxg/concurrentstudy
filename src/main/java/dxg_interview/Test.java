package dxg_interview;

import java.util.concurrent.ArrayBlockingQueue;

public class Test {
         
       public static void main(String[] args){  
             
           System.out.println("begin:"+(System.currentTimeMillis()/1000));  
           /*模拟处理16行日志，下面的代码产生了16个日志对象，当前代码需要运行16秒才能打印完这些日志。 
           修改程序代码，开四个线程让这16个对象在4秒钟打完。 
           */


           for(int i=0;i<16;i++){  //这行代码不能改动  
               final String log = ""+(i+1);//这行代码不能改动  
               {
                        Test.parseLog(log);
               }  
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