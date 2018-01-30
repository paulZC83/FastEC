package cn.sh.changxing.latte.utils.timer;

import java.util.TimerTask;

/**
 * Created by ZengChao on 2018/1/30.
 */

public class BaseTimerTask extends TimerTask {

    private ITimerListener mITimerListener;

    public BaseTimerTask(ITimerListener timerListener) {
        this.mITimerListener = timerListener;
    }

    @Override
    public void run() {
        if (mITimerListener != null) {
            mITimerListener.onTimer();
        }
    }
}
