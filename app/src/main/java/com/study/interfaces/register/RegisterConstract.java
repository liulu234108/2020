package com.study.interfaces.register;


import com.study.interfaces.IBaseView;
import com.study.interfaces.IPersenter;
import com.study.model.bean.RegisterBean;

public interface RegisterConstract {

    interface View extends IBaseView {
        void RegisterReturn(RegisterBean registerBean);
    }

    interface Persenter extends IPersenter<View> {
        void getRegisterData(String nickname, String password);
    }
}
