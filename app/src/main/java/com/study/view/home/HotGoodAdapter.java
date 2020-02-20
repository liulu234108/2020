package com.study.view.home;

import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.study.R;
import com.study.base.adapter.BaseAdapter;
import com.study.model.bean.IndexBean;

import java.util.List;

public class HotGoodAdapter extends BaseAdapter {
    public HotGoodAdapter(List mDatas) {
        super(mDatas);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.layout_hotgood_item;
    }

    @Override
    protected void bindData(BaseViewHolder holder, int positon, Object o) {
        IndexBean.DataBean.HotGoodsListBean bean = (IndexBean.DataBean.HotGoodsListBean) mDatas.get(positon);
        TextView textName = (TextView) holder.getView(R.id.tv_hot_title);
        TextView textDesc = (TextView) holder.getView(R.id.tv_hot_desc);
        TextView textPrice = (TextView) holder.getView(R.id.tv_hot_price);
        ImageView img = (ImageView) holder.getView(R.id.tv_hot_img);
        textName.setText(bean.getName());
        textDesc.setText(bean.getGoods_brief());
        textPrice.setText("￥"+bean.getRetail_price());
        Glide.with(mContext).load(bean.getList_pic_url()).into(img);
    }

}
