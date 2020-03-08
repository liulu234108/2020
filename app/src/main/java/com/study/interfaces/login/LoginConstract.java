package com.study.interfaces.login;

import com.study.interfaces.IBaseView;
import com.study.interfaces.IPersenter;
import com.study.model.bean.UserBean;

public interface LoginConstract {

    interface View extends IBaseView {
        void loginReturn(UserBean result);
        void showTips(String error);
    }

    interface Persenter extends IPersenter<View> {
        void login(String nickname, String password);
    }
}
