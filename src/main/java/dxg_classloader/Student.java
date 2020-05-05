package dxg_classloader;

/**
 * @auther 丁溪贵
 * @date 2020/5/5
 */
public class Student extends Person{

    public Student(){

        System.out.println("Student 初始化了 ，该类定义类加载器为 ："+this.getClass().getClassLoader());
    }

    public void say(){
        System.out.println("Student say");
    }
}
