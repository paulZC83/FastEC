package cn.sh.changxing.latte.WeChat;

import android.app.Activity;

import com.tencent.mm.opensdk.modelmsg.SendAuth;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;

import cn.sh.changxing.latte.WeChat.callbacks.IWeChatSignInCallback;
import cn.sh.changxing.latte.app.ConfigKeys;
import cn.sh.changxing.latte.app.Latte;

/**
 * Created by ZengChao on 2018/2/7.
 */

public class LatteWeChat {

    static final String APP_ID = Latte.getConfigurations(ConfigKeys.WE_CHAT_APP_ID);
    static final String APP_SECRET = Latte.getConfigurations(ConfigKeys.WE_CHAT_APP_SECRET);
    private final IWXAPI WXAPI;
    private IWeChatSignInCallback mIWeChatSignInCallback;

    private static final class Holder{
        private static final LatteWeChat INSTANCE = new LatteWeChat();
    }

    public static LatteWeChat getInstance(){
        return Holder.INSTANCE;
    }

    private LatteWeChat(){
        final Activity activity = Latte.getConfigurations(ConfigKeys.ACTIVITY);
        WXAPI = WXAPIFactory.createWXAPI(activity,APP_ID, true);
        WXAPI.registerApp(APP_ID);
    }

    public final IWXAPI getWXAPI(){
        return WXAPI;
    }

    public LatteWeChat onSignSuccess(IWeChatSignInCallback callback){
        mIWeChatSignInCallback = callback;
        return this;
    }

    public IWeChatSignInCallback getSignInCallback(){
        return mIWeChatSignInCallback;
    }

    public final void signIn(){
        final SendAuth.Req req = new SendAuth.Req();
        req.scope = "snsapi_userinfo";
        req.state = "random_state";
        WXAPI.sendReq(req);
    }
}
