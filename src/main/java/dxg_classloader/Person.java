package dxg_classloader;

/**
 * @auther 丁溪贵
 * @date 2020/5/5
 */
public class Person {

    public Person(){

        System.out.println("persion 初始化了 ，该类定义类加载器为 ："+this.getClass().getClassLoader());
    }

    public void say(){
        System.out.println("person say");
    }

    public void say(Person person){
        person.say();
    }
}
