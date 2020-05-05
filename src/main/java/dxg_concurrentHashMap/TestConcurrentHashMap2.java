package dxg_concurrentHashMap;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @auther 丁溪贵
 * @date 2019/10/18
 *    Concurrent不会在迭代的时候复制一个map，而是直接在map上操作。代码最底下
 */
public class TestConcurrentHashMap2 {

    public static void main(String[] args) {

        ConcurrentHashMap<Object, Object> map = new ConcurrentHashMap<>();
        map.put("1","1");
        map.put("2","2");
        map.put("3","3");
        System.out.println(map.size());
        Iterator<Map.Entry<Object, Object>> it = map.entrySet().iterator();
        // 移除一个元素，看一下map容器中元素有没有减少
        it.next();
        it.remove();
        //往map中添加一个元素
        map.put("4","4");
        // 遍历迭代器
        while(it.hasNext()){
            Map.Entry<Object, Object> next = it.next();
            System.out.println("value "+next.getValue());
        }

        System.out.println(map.size());

    }
}
/**
 static final class EntrySetView<K,V> extends CollectionView<K,V,Map.Entry<K,V>>
 implements Set<Map.Entry<K,V>>, java.io.Serializable {
 private static final long serialVersionUID = 2249069246763182397L;
 EntrySetView(ConcurrentHashMap<K,V> map) { super(map); }

 public boolean contains(Object o) {
 Object k, v, r; Map.Entry<?,?> e;
 return ((o instanceof Map.Entry) &&
 (k = (e = (Map.Entry<?,?>)o).getKey()) != null &&
 (r = map.get(k)) != null &&
 (v = e.getValue()) != null &&
 (v == r || v.equals(r)));
 }

 public boolean remove(Object o) {
 Object k, v; Map.Entry<?,?> e;
 return ((o instanceof Map.Entry) &&
 (k = (e = (Map.Entry<?,?>)o).getKey()) != null &&
 (v = e.getValue()) != null &&
 map.remove(k, v));
 }

 */