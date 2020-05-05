package dxg_classloader;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @auther 丁溪贵
 * @date 2020/5/5
 */
public class App {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {

        //想要营造 父类用系统类加载器加载，子类用自定义类加载器加载，
        //然后用父类去调用子类的say
        //把子类Student.class从类路径下删掉，然后放到setPath路径下
        MyClassLoader myClassLoader = new MyClassLoader(ClassLoader.getSystemClassLoader());
        myClassLoader.setPath("C:/Users/ASUS/Desktop/");
        Class<?> personClass = myClassLoader.loadClass("dxg_classloader.Person");
        Class<?> studentClass = myClassLoader.loadClass("dxg_classloader.Student");
        Object person = personClass.newInstance();
        //studentClass.newInstance();
        Method sayMethod = personClass.getMethod("say", personClass);
        //子类创建会调用父类的构造方法
        Object invoke = sayMethod.invoke(person, studentClass.newInstance());


    }
}
