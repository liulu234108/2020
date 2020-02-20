package com.study.view.home;

import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.study.R;
import com.study.base.adapter.BaseAdapter;
import com.study.model.bean.IndexBean;

import java.util.List;

public class SubjectAdapter extends BaseAdapter {
    public SubjectAdapter(List mDatas) {
        super(mDatas);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.layout_subject_item;
    }

    @Override
    protected void bindData(BaseViewHolder holder, int positon, Object o) {
        IndexBean.DataBean.TopicListBean bean = (IndexBean.DataBean.TopicListBean) mDatas.get(positon);
        TextView textName = (TextView) holder.getView(R.id.subject_text);
        TextView textTitle = (TextView) holder.getView(R.id.subject_title);
        TextView textDesc = (TextView) holder.getView(R.id.subject_desc);
        ImageView img = (ImageView) holder.getView(R.id.subject_img);

        textName.setText(bean.getTitle());
        textTitle.setText("￥"+bean.getPrice_info()+"元起");
        textDesc.setText(bean.getSubtitle());
        Glide.with(mContext).load(bean.getItem_pic_url()).into(img);
    }

}
