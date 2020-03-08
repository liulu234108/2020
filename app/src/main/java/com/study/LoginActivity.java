package com.study;


import android.content.Intent;
import android.widget.Button;
import android.widget.EditText;

import com.study.base.BaseActivity;
import com.study.interfaces.login.LoginConstract;
import com.study.model.bean.UserBean;
import com.study.persenter.login.LoginPercenter;
import com.study.utils.SpUtils;

import butterknife.BindView;
import butterknife.OnClick;

public class LoginActivity extends BaseActivity<LoginConstract.View, LoginConstract.Persenter> implements LoginConstract.View {

    @BindView(R.id.edit_username)
    EditText editUsername;
    @BindView(R.id.edit_password)
    EditText editPassword;
    @BindView(R.id.btn_login)
    Button btnLogin;

    @Override
    protected int getLayout() {
        return R.layout.activity_login;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {
    }


    @OnClick(R.id.btn_login)
    public void onLogin(){
        String nickname = editUsername.getText().toString();
        String password = editPassword.getText().toString();
        persenter.login(nickname,password);
    }
    @OnClick(R.id.btn_register)
    public void onRegister(){
        startActivity(new Intent(this,RegisterActivity.class));
    }

    @Override
    protected LoginConstract.Persenter initPersenter() {
        return new LoginPercenter();
    }

    @Override
    public void loginReturn(UserBean result) {
        //登录成功以后存入sp
        SpUtils.getInstance().setValue("token",result.getData().getToken());
        finish();
    }

    @Override
    public void showTips(String error) {

    }
}
