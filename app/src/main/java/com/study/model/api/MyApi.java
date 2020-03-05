package com.study.model.api;


import com.study.model.bean.BrandBean;
import com.study.model.bean.CatalogListBean;
import com.study.model.bean.CatalogTabBean;
import com.study.model.bean.IndexBean;

import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MyApi {


    //主页数据接口
    @GET("index")
    Flowable<IndexBean> getIndexData();

    //获取分类导航数据接口
    @GET("catalog/index")
    Flowable<CatalogTabBean> getCatalogTabData();

    //获取列表选中的数据
    @GET("catalog/current")
    Flowable<CatalogListBean> getCatalogList(@Query("id") int id);

    //获取直供文字的列表数据
    @GET("brand/list")
    Flowable<BrandBean> getBrandbean(@Query("page") int page,@Query("size")int size);


}
