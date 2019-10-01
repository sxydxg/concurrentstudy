package dxg;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

/**
 * @auther 丁溪贵
 * @date 2019/10/1
 */
public class test3 {

    public static class Studnet{
        public Studnet(int id,String name){
            this.id = id ;
            this.name = name ;
        }
        public int id ;
        public String name ;

        @Override
        public String toString() {
            return "Studnet{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    '}';
        }
    }

    public static void main(String[] args) {
        TreeMap<Studnet, Studnet> map = new TreeMap<Studnet, Studnet>(new Comparator<Studnet>() {

            public int compare(Studnet o1, Studnet o2) {

                if(o1.id>o2.id){
                    return 1 ;
                }
                return -1;
            }
        });

        map.put(new Studnet(3,"d3"),new Studnet(3,"d3"));
        map.put(new Studnet(2,"d2"),new Studnet(2,"d2"));
        map.put(new Studnet(4,"d4"),new Studnet(4,"d4"));
        map.put(new Studnet(1,"d1"),new Studnet(1,"d1"));


        //根据比较规则从小到大进行遍历（红黑树嘛，不就是前、中、后 序遍历）
        Iterator<Map.Entry<Studnet, Studnet>> it = map.entrySet().iterator();
        while (it.hasNext()){
            Map.Entry<Studnet, Studnet> s = it.next();
            System.out.println(s.getValue());
        }
    }
}
