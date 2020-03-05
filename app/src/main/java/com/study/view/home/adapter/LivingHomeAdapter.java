package com.study.view.home.adapter;

import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.study.R;
import com.study.base.adapter.BaseAdapter;
import com.study.model.bean.IndexBean;

import java.util.List;

public class LivingHomeAdapter extends BaseAdapter {
    public LivingHomeAdapter(List mDatas) {
        super(mDatas);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.layout_livinghome_item;
    }

    @Override
    protected void bindData(BaseViewHolder holder, int positon, Object o) {
        IndexBean.DataBean.CategoryListBean.GoodsListBean list = (IndexBean.DataBean.CategoryListBean.GoodsListBean) mDatas.get(positon);
        ImageView img = (ImageView) holder.getView(R.id.iv_item_shouye_livinghome);
        TextView name = (TextView) holder.getView(R.id.tv_item_shouye_livinghometitle);
        TextView price = (TextView) holder.getView(R.id.tv_item_shouye_livinghomeprice);
        name.setText(list.getName());
        price.setText("￥"+list.getRetail_price());
        Glide.with(mContext).load(list.getList_pic_url()).into(img);
    }

}
