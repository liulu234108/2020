package com.study.persenter.login;

import com.study.common.CommonSubscriber;
import com.study.interfaces.login.LoginConstract;
import com.study.model.HttpManager;
import com.study.model.bean.UserBean;
import com.study.persenter.BasePersenter;
import com.study.utils.RxUtils;

public class LoginPercenter extends BasePersenter<LoginConstract.View> implements LoginConstract.Persenter{
    @Override
    public void login(String nickname, String password) {
        addSubscribe(HttpManager.getMyApi().login(nickname,password)
                .compose(RxUtils.<UserBean>rxScheduler())
                .subscribeWith(new CommonSubscriber<UserBean>(mView){

                    @Override
                    public void onNext(UserBean userBean) {
                        if(userBean.getErrno() == 0){
                            mView.loginReturn(userBean);
                        }else{
                            mView.showTips(userBean.getErrmsg());
                        }
                    }
                }));
    }
}
