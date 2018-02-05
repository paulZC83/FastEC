package cn.sh.changxing.latte.app;

import cn.sh.changxing.latte.utils.storage.LattePreference;

/**
 * Created by ZengChao on 2018/2/5.
 */

public class AccountManager {
    private enum SignTag {
        SIGN_TAG
    }

    // 保存用户登录状态，登陆后调用
    public static void setSignState(boolean state) {
        LattePreference.setAppFlag(SignTag.SIGN_TAG.name(), state);
    }

    private static boolean isSignIn() {
        return LattePreference.getAppFlag(SignTag.SIGN_TAG.name());
    }

    public static void checkAccoun(IUserChecker checker) {
        if (isSignIn()) {
            checker.onSignIn();
        } else {
            checker.onNotSignIn();
        }
    }
}
