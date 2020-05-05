package dxg_threadLocal;

/**
 * threal Local
 *
 * @author dingxigui
 * @date 2020/4/26
 */
public class TestThreaLocal {

    static ThreadLocal tl = new ThreadLocal() ;

    public static void main(String[] args) {

        tl.set("v1");
        tl.set(null);

    }
}
