package dxg_typesOfLocks;

/**
 * @auther 丁溪贵
 * @date 2019/9/10
 *
 *  可重入锁
 */
public class TestReentrant {
    //a,b方法都是同锁对象，如果锁的种类不是可重入锁，那么就会进入死锁状态。反之证明该锁是可重入锁
    public synchronized void a(){

        System.out.println("a方法被调用了");
        b();
    }

    public synchronized void b(){

        System.out.println("b方法被调用了");

    }

    public static void main(String[] args) {
        new TestReentrant().a();
    }
}
