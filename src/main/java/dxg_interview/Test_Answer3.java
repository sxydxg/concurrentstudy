package dxg_interview;

import java.util.LinkedList;

public class Test_Answer3 {

       public static void main(String[] args) throws InterruptedException {

           System.out.println("begin:"+(System.currentTimeMillis()/1000));
           /*模拟处理16行日志，下面的代码产生了16个日志对象，当前代码需要运行16秒才能打印完这些日志。
           修改程序代码，开四个线程让这16个对象在4秒钟打完。
           */

           //没有帮助类
           //final LinkedList list = Collections.synchronizedList(new LinkedList());
           final LinkedList list = new LinkedList();
           final LinkedList list2 = new LinkedList();
           for(int i=0;i<16;i++){  //这行代码不能改动  
               final String log = ""+(i+1);//这行代码不能改动  
               {
                   list.add(log);
               }  
           }

           for (int i=0;i<4;i++){
                new Thread(){
                    Object currentLog = null ;
                    @Override
                    public void run() {
                        while (true){
                            String log = null ;
                            try {
                                // 写锁，在开启读锁
                                synchronized (Test_Answer3.class){
                                    log = (String) list.getFirst();

                                }

                                Test_Answer3.parseLog(log); // 这一段代码顺序可能会乱，怎么保证其不乱呢？

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