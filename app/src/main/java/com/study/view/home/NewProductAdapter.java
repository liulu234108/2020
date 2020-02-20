package com.study.view.home;

import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.study.R;
import com.study.base.adapter.BaseAdapter;
import com.study.model.bean.IndexBean;

import java.util.List;

public class NewProductAdapter extends BaseAdapter {
    public NewProductAdapter(List mDatas) {
        super(mDatas);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.layout_newproduct_item;
    }

    @Override
    protected void bindData(BaseViewHolder holder, int positon, Object o) {
        IndexBean.DataBean.NewGoodsListBean bean = (IndexBean.DataBean.NewGoodsListBean) mDatas.get(positon);
        TextView txtName = (TextView) holder.getView(R.id.item_text);
        TextView txtPrice = (TextView) holder.getView(R.id.item_desc);
        ImageView img = (ImageView) holder.getView(R.id.item_img);
        txtName.setText(bean.getName());
        txtPrice.setText("￥"+bean.getRetail_price());
        Glide.with(mContext).load(bean.getList_pic_url()).into(img);
    }

}
