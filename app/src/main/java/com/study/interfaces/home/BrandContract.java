package com.study.interfaces.home;

import com.study.interfaces.IBaseView;
import com.study.interfaces.IPersenter;
import com.study.model.bean.BrandBean;

public interface BrandContract {
    //创建契约类，连接viewBean和presenter
    interface View extends IBaseView{
        void  getBean(BrandBean brandBean);
    }
    interface Presenter extends IPersenter<View>{
        void getBrand(int page,int size);
    }
}
