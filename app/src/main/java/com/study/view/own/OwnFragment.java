package com.study.view.own;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.study.R;
import com.study.model.bean.MineBean;

import java.util.ArrayList;
import java.util.List;

public class OwnFragment extends Fragment {
    private Mine_Recyadapter mine_recyadapter;
    private Toolbar spcialToolbar;
    private ImageView mineImg;
    private TextView mineText;
    private RecyclerView mineRecy;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = LayoutInflater.from(getActivity()).inflate(R.layout.item_mine, null);
        initview(inflate);
        return inflate;
    }
    private void initview(View view) {
//        spcialToolbar = (Toolbar) view.findViewById(R.id.spcial_toolbar);
        mineImg = (ImageView)  view.findViewById(R.id.mine_img);
        mineText = (TextView)  view.findViewById(R.id.mine_text);
        mineRecy = (RecyclerView)  view.findViewById(R.id.mine_recy);
        //设置加载图片为圆形

        RequestOptions requestOptions = new RequestOptions().circleCrop();
        Glide.with(getActivity()).load(R.drawable.wx).apply(requestOptions).into(mineImg);
        List<MineBean> mineBeans = new ArrayList<>();
        mineBeans.add(new MineBean(R.drawable.a, "我的订单"));
        mineBeans.add(new MineBean(R.drawable.q, "优惠券"));
        mineBeans.add(new MineBean(R.drawable.b, "礼品卡"));
        mineBeans.add(new MineBean(R.drawable.c, "我的收藏"));
        mineBeans.add(new MineBean(R.drawable.d, "我的足迹"));
        mineBeans.add(new MineBean(R.drawable.e, "会员福利"));
        mineBeans.add(new MineBean(R.drawable.c, "地址管理"));
        mineBeans.add(new MineBean(R.drawable.d, "账号安全"));
        mineBeans.add(new MineBean(R.drawable.e, "联系客服"));
        mineBeans.add(new MineBean(R.drawable.f, "帮助中心"));
        mineBeans.add(new MineBean(R.drawable.g, "意见反聩"));
        mineRecy.setLayoutManager(new GridLayoutManager(getActivity(), 3));
        mine_recyadapter = new Mine_Recyadapter(getActivity());
        mineRecy.setAdapter(mine_recyadapter);

        mine_recyadapter.setDatas(mineBeans);
    }
}
