package dxg_classloader;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;

/**
 * @auther 丁溪贵
 * @date 2020/5/5
 */
public class MyClassLoader extends ClassLoader {

    private String path ;

    private String ext = ".class" ;

    public MyClassLoader(ClassLoader parent){
        super(parent);
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        System.out.println("MyClassLoader#MyClassLoader被执行了。。。");
        byte[] bytes = loadClassData(name);
        return defineClass(name,bytes,0,bytes.length) ;
    }

    private byte[] loadClassData(String name) {
        System.out.println("MyClassLoader#loadClassData被执行了。。。");
        name = name.replaceAll("\\.","/");
        try {
            FileInputStream in = new FileInputStream(path + name + ext);
            int c = 0 ;
            ByteBuffer buffer = ByteBuffer.allocate(in.available());
            while ((c=  in.read()) !=-1){

                buffer.put((byte) c);
            }

            return buffer.array();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null ;
    }


    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getExt() {
        return ext;
    }

    public void setExt(String ext) {
        this.ext = ext;
    }
}
