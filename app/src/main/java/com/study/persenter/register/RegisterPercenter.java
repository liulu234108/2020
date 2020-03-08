package com.study.persenter.register;


import com.study.common.CommonSubscriber;
import com.study.interfaces.register.RegisterConstract;
import com.study.model.HttpManager;
import com.study.model.bean.RegisterBean;
import com.study.persenter.BasePersenter;
import com.study.utils.RxUtils;

public class RegisterPercenter extends BasePersenter<RegisterConstract.View> implements RegisterConstract.Persenter {

    @Override
    public void getRegisterData(String nickname, String password) {
        addSubscribe(HttpManager.getMyApi().register(nickname,password)
                .compose(RxUtils.<RegisterBean>rxScheduler())
                .subscribeWith(new CommonSubscriber<RegisterBean>(mView) {
                    @Override
                    public void onNext(RegisterBean registerBean) {
                        mView.RegisterReturn(registerBean);
                    }
                })
        );
    }
}
