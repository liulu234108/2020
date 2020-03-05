package com.study.view.home.activity;

import android.widget.TextView;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.study.R;
import com.study.base.BaseActivity;
import com.study.interfaces.home.BrandContract;
import com.study.model.bean.BrandBean;
import com.study.persenter.home.BrandPresenter;
import com.study.utils.RecyclerViewSpacesItemDecoration;
import com.study.view.home.adapter.BrandActivityAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class BrandActivity extends BaseActivity<BrandContract.View, BrandContract.Presenter>implements BrandContract.View {
    private android.widget.TextView tvPublic;
    private androidx.recyclerview.widget.RecyclerView brandRecy;
    private List<BrandBean.DataBeanX.DataBean> list;
    private BrandActivityAdapter brandActivityAdapter;

    @Override
    protected int getLayout() {
        return R.layout.activity_brand;
    }

    @Override
    protected void initView() {

        tvPublic = (TextView) findViewById(R.id.tv_public);
        brandRecy = (RecyclerView) findViewById(R.id.brand_recy);
        brandRecy.setLayoutManager(new GridLayoutManager(context,1));
        HashMap<String, Integer> stringIntegerHashMap = new HashMap<>();
        //添加item之间的间距
        //stringIntegerHashMap.put(RecyclerViewSpacesItemDecoration.BOTTOM_DECORATION,10);//底部间距
        brandRecy.addItemDecoration(new RecyclerViewSpacesItemDecoration(stringIntegerHashMap));
        list = new ArrayList<>();
        brandActivityAdapter = new BrandActivityAdapter(list);
        brandRecy.setAdapter(brandActivityAdapter);
    }

    @Override
    protected void initData() {
        persenter.getBrand(1,1000);
    }
    //填充bean数据
    @Override
    public void getBean(BrandBean brandBean) {
        List<BrandBean.DataBeanX.DataBean> data = brandBean.getData().getData();
        brandActivityAdapter.addData(data);
    }

    @Override
    protected BrandContract.Presenter initPersenter() {
        return new BrandPresenter();
    }
}
