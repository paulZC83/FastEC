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

public class SignUpDelegate extends LatteDelegate {

    @BindView(R2.id.edit_sign_up_name)
    TextInputEditText mName = null;
    @BindView(R2.id.edit_sign_up_phone)
    TextInputEditText mPhone = null;
    @BindView(R2.id.edit_sign_up_email)
    TextInputEditText mEmail = null;
    @BindView(R2.id.edit_sign_up_password)
    TextInputEditText mPassword = null;
    @BindView(R2.id.edit_sign_up_re_password)
    TextInputEditText mRePassword = null;

    @OnClick(R2.id.btn_sign_up)
    void onClick(){
        if (checkForm()) {
//            RestClient.builder()
//                    .url("sing_up")
//                    .params("","")
//                    .success(new ISuccess() {
//                        @Override
//                        public void onSuccess(String response) {
//
//                        }
//                    })
//                    .build()
//                    .post();
            Toast.makeText(getContext(), "注册成功", Toast.LENGTH_SHORT).show();
        }
    }

    private boolean checkForm(){
        boolean isPass = true;
        final String name = mName.getText().toString().trim();
        final String phone = mPhone.getText().toString().trim();
        final String email = mEmail.getText().toString().trim();
        final String password = mPassword.getText().toString().trim();
        final String rePassword = mRePassword.getText().toString().trim();
        if (name.isEmpty()) {
            mName.setError("姓名没有输入");
            isPass = false;
        }  else {
            mName.setError(null);
        }
        if (phone.isEmpty() || phone.length() != 11) {
            mPhone.setError("手机号码输入位数错误");
            isPass = false;
        }  else {
            mPhone.setError(null);
        }
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
        if (rePassword.isEmpty() || rePassword.length() < 6 || !rePassword.equals(password)) {
            mRePassword.setError("密码验证错误");
            isPass = false;
        }  else {
            mRePassword.setError(null);
        }
        return isPass;
    }

    @Override
    public Object setLayout() {
        return R.layout.delegate_sign_up;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, View rootView) {

    }
}
