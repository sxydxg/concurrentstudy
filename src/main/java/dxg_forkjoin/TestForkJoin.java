package dxg_forkjoin;

import java.util.concurrent.ForkJoinPool;

/**
 * @auther 丁溪贵
 * @date 2019/9/14
 *
 *   Fork/Join 框架 ，充分利用多核cpu的优势（当然是强劲的服务器机子，不是我们的pc机）
 */
public class TestForkJoin {


    public static void main(String[] args) {
        // 使用3个线程
        ForkJoinPool pool = new ForkJoinPool(3);
//        pool.execute(); 执行无返回值的任务
//        pool.submit()


    }
}
