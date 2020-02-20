package com.study.view.home;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.google.android.material.tabs.TabLayout;
import com.study.R;
import com.study.base.BaseFragment;
import com.study.interfaces.home.HomeContract;
import com.study.model.bean.IndexBean;
import com.study.persenter.home.HomePersenter;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends BaseFragment<HomeContract.View, HomeContract.Persenter> implements HomeContract.View {

//    RecyclerView recyclerView;
//    TextView txtTitle;

    List<IndexBean.DataBean.BrandListBean> brandList;
    private BrandAdapter brandAdapter;
    private Banner banner;
    private TabLayout homeTab;
    private TextView hometextBrand;
    private RecyclerView homeBrand;
    private TextView hometextNewproduct;
    private RecyclerView homeNewproduct;
    private TextView hometextRecommend;
    private RecyclerView homeRecommend;
    private TextView hometextSubject;
    private LinearLayout homeLayout;
    private RecyclerView homeSubject;
    private TextView hometextLivingAtHome;
    private RecyclerView homeLivingAtHome;
    private List<IndexBean.DataBean.BannerBean> banners;
    private List<IndexBean.DataBean.CategoryListBean> categoryList;
    private ArrayList<String> banners_datas;
    private List<IndexBean.DataBean.TopicListBean> newproductlist;
    private NewProductAdapter newProductAdapter;

    @Override
    protected int getLayout() {
        return R.layout.fragment_home;
    }

    @Override
    protected void initView(View view) {
        banner = (Banner) view.findViewById(R.id.banner);

        homeTab = (TabLayout) view.findViewById(R.id.home_tab);
        hometextBrand = (TextView) view.findViewById(R.id.hometext_brand);
        //直供
        homeBrand = (RecyclerView) view.findViewById(R.id.home_brand);
//        hometextNewproduct = (TextView) view.findViewById(R.id.hometext_newproduct);
//        //新品首发
//        homeNewproduct = (RecyclerView) view.findViewById(R.id.home_newproduct);
//        hometextRecommend = (TextView) view.findViewById(R.id.hometext_recommend);
//        //人气推荐
//        homeRecommend = (RecyclerView) view.findViewById(R.id.home_recommend);
//        hometextSubject = (TextView) view.findViewById(R.id.hometext_subject);
//        homeLayout = (LinearLayout) view.findViewById(R.id.home_layout);
//        //专题
//        homeSubject = (RecyclerView) view.findViewById(R.id.home_subject);
//        hometextLivingAtHome = (TextView) view.findViewById(R.id.hometext_living_at_home);
//        //居家
//        homeLivingAtHome = (RecyclerView) view.findViewById(R.id.home_living_at_home);

        //这个就是第一个
        brandList = new ArrayList<>();
        brandAdapter = new BrandAdapter(brandList);
        homeBrand.setAdapter(brandAdapter);
        homeBrand.setLayoutManager(new GridLayoutManager(context, 2));

//        newproductlist = new ArrayList<>();
//        newProductAdapter = new NewProductAdapter(newproductlist);
//        homeNewproduct.setAdapter(brandAdapter);
//        homeNewproduct.setLayoutManager(new GridLayoutManager(getActivity(), 2));
//        homeRecommend.setLayoutManager(new LinearLayoutManager(getActivity()));
//        homeRecommend.addItemDecoration(new DividerItemDecoration(getActivity(), LinearLayout.VERTICAL));
//        homeSubject.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false));
//        homeLivingAtHome.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false));

//        private List<ShouYeBean.DataBean.TopicListBean> topicList;
//        private List<ShouYeBean.DataBean.HotGoodsListBean> hotGoodsList;
//        private List<ShouYeBean.DataBean.NewGoodsListBean> newGoodsList;
//        private List<ShouYeBean.DataBean.BrandListBean> brandList;
//        private List<ShouYeBean.DataBean.CategoryListBean.GoodsListBean> goodsList;

    }

    @Override
    protected void initData() {
        ((HomePersenter) persenter).getHomeData();
    }

    @Override
    protected HomeContract.Persenter createPersenter() {
        return new HomePersenter();
    }

    @Override
    public void homeDataReturn(IndexBean result) {
        banners = result.getData().getBanner();
        categoryList = result.getData().getCategoryList();
        //banner图片资源的集合
        final ArrayList<String> banners_datas = new ArrayList<>();
        for (int i = 0; i < banners.size(); i++) {
            String image_url = banners.get(i).getImage_url();
            banners_datas.add(image_url);
        }
        //tab数据集合
//        ArrayList<String> tab_datas = new ArrayList<>();
//        for (int i = 0; i < categoryList.size(); i++) {
//            String name = categoryList.get(i).getName();
//            tab_datas.add(name);
//        }
        //
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                tobanner(banners_datas);
                brandAdapter.addData(result.getData().getBrandList());
            }
        });

//        totab(tab_datas);

    }
//
//    private void totab(ArrayList<String> tab_datas) {
//
//    }

    private void tobanner(ArrayList<String> banners_datas) {

        //banner轮播图的实现
        banner.setImages(banners_datas).setImageLoader(new ImageLoader() {
            @Override
            public void displayImage(Context context, Object path, ImageView imageView) {
                Glide.with(context).load((String) path).into(imageView);
            }
        }).start();

    }

    @Override
    public void showErrMsg(String err) {

    }
}
