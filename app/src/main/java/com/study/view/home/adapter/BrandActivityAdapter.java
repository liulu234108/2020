package com.study.view.home.adapter;


import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.study.R;
import com.study.base.adapter.BaseAdapter;
import com.study.model.bean.BrandBean;

import java.util.List;

public class BrandActivityAdapter extends BaseAdapter {

    private ImageView brandItemDirectimg;
    private TextView textItemDirect;

    public BrandActivityAdapter(List mDatas) {
        super(mDatas);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_brand_item;
    }

    @Override
    protected void bindData(BaseViewHolder holder, int positon, Object o) {
        BrandBean.DataBeanX.DataBean datas= (BrandBean.DataBeanX.DataBean) o;
        brandItemDirectimg = (ImageView) holder.getView(R.id.brand_item_directimg);
        textItemDirect = (TextView) holder.getView(R.id.text_item_direct);
        textItemDirect.setText(datas.getName());
        Glide.with(mContext).load(datas.getApp_list_pic_url()).into(brandItemDirectimg);
    }
}
