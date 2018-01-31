package cn.sh.changxing.latte.ec.sign;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.util.Patterns;
import android.view.View;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.OnClick;
import cn.sh.changxing.latte.delegates.LatteDelegate;
import cn.sh.changxing.latte.ec.R;
import cn.sh.changxing.latte.ec.R2;

/**
 * Created by ZengChao on 2018/1/31.
 */

public class SignInDelegate extends LatteDelegate {
    @BindView(R2.id.edit_sign_in_email)
    TextInputEditText mEmail = null;
    @BindView(R2.id.edit_sign_in_password)
    TextInputEditText mPassword = null;

    @OnClick(R2.id.btn_sign_in)
    void onClickSignIn(){
        if (checkForm()) {
            Toast.makeText(getContext(), "登录成功",Toast.LENGTH_SHORT).show();
        }
    }

    @OnClick(R2.id.tv_sing_in_link_sign_up)
    void onClickLink(){
        start(new SignUpDelegate());
    }

    @OnClick(R2.id.icon_sign_in_we_chat)
    void oonClickaWeChat(){
        start(new SignUpDelegate());
    }

    private boolean checkForm(){
        boolean isPass = true;
        final String email = mEmail.getText().toString().trim();
        final String password = mPassword.getText().toString().trim();
        if (email.isEmpty() || !Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            mEmail.setError("邮箱输入格式错误");
            isPass = false;
        }  else {
            mEmail.setError(null);
        }
        if (password.isEmpty() || password.length() < 6) {
            mPassword.setError("密码至少输入6位");
            isPass = false;
        }  else {
            mPassword.setError(null);
        }
        return isPass;
    }

    @Override
    public Object setLayout() {
        return R.layout.delegate_sign_in;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, View rootView) {

    }
}
