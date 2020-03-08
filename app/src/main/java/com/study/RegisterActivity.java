package com.study;

import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;


import com.study.base.BaseActivity;
import com.study.interfaces.register.RegisterConstract;
import com.study.model.bean.RegisterBean;
import com.study.persenter.register.RegisterPercenter;

import butterknife.BindView;
import butterknife.OnClick;


public class RegisterActivity extends BaseActivity<RegisterConstract.View, RegisterConstract.Persenter> implements RegisterConstract.View {


    @BindView(R.id.register_username)
    EditText mEditUsername;
    @BindView(R.id.register_pw1)
    EditText mEditPw1;
    @BindView(R.id.register_pw2)
    EditText mEditPw2;
    @BindView(R.id.register_verify)
    EditText mEditVerify;
    @BindView(R.id.layout_list)
    LinearLayout mLayoutList;

    @OnClick(R.id.btn_register)
    public void onRegister(){
        String uses = mEditUsername.getText().toString();
        String pwd1 = mEditPw1.getText().toString();
        String pwd2 = mEditPw2.getText().toString();
        if (pwd1.length() >=6 && pwd1.equals(pwd2)){
            persenter.getRegisterData(uses,pwd1);
        }else {
            showErrMsg("密码长度不对，或两次密码不一致");
        }
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_register;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {

    }

    @Override
    protected RegisterConstract.Persenter initPersenter() {
        return new RegisterPercenter();
    }


    @Override
    public void RegisterReturn(RegisterBean registerBean) {
        int errno = registerBean.getErrno();
        if (errno == 0){
            Toast.makeText(this, "注册成功", Toast.LENGTH_SHORT).show();
            finish();
        }
        if (errno == 1000){
            showErrMsg("用户已存在");
        }
    }
}
