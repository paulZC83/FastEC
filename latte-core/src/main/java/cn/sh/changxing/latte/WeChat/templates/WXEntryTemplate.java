package cn.sh.changxing.latte.WeChat.templates;

import cn.sh.changxing.latte.WeChat.BaseWXEntryActivity;
import cn.sh.changxing.latte.WeChat.LatteWeChat;

/**
 * Created by ZengChao on 2018/2/6.
 */

public class WXEntryTemplate extends BaseWXEntryActivity {

    @Override
    protected void onResume() {
        super.onResume();
        // 微信登录成功会回调到这个界面，此时把这个界面finish并把背景设为透明
        finish();
        overridePendingTransition(0,0);
    }

    @Override
    protected void onSignInSuccess(String userInfo) {
        LatteWeChat.getInstance().getSignInCallback().onSingInSuccess(userInfo);
    }
}
