package dxg_forkjoin;

import java.util.concurrent.ForkJoinTask;

/**
 * @auther 丁溪贵
 * @date 2019/9/14
 */
public class Demo extends ForkJoinTask<Integer> {

    @Override
    public Integer getRawResult() {
        return null;
    }

    @Override
    protected void setRawResult(Integer value) {

    }

    @Override
    protected boolean exec() {
        return false;
    }
}
