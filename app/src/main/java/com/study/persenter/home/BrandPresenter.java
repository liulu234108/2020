package com.study.persenter.home;

import com.study.common.CommonSubscriber;
import com.study.interfaces.home.BrandContract;
import com.study.model.HttpManager;
import com.study.model.bean.BrandBean;
import com.study.model.bean.IndexBean;
import com.study.persenter.BasePersenter;
import com.study.utils.RxUtils;

public class BrandPresenter extends BasePersenter<BrandContract.View>implements BrandContract.Presenter {
    @Override
    public void getBrand(int page, int size) {
        addSubscribe(HttpManager.getMyApi().getBrandbean(page, size)
                .compose(RxUtils.<BrandBean>rxScheduler())
                .subscribeWith(new CommonSubscriber<BrandBean>(mView){

                    @Override
                    public void onNext(BrandBean brandBean) {
                       mView.getBean(brandBean);
                    }
                }));
    }
}
