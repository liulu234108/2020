package com.study.view;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.tabs.TabLayout;
import com.study.R;
import com.study.base.adapter.MainFragmentAdapter;
import com.study.view.catalog.CatalogFragment;
import com.study.view.home.HomeFragment;
import com.study.view.own.OwnFragment;
import com.study.view.shopp.ShoppFragment;
import com.study.view.subject.SubjectFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView navigationView;

    HomeFragment homeFragment;
    OwnFragment ownFragment;
    CatalogFragment catalogFragment;
    FragmentManager fragmentManager;
    SubjectFragment subjectFragment;
    private ShoppFragment shoppFragment;
    private ViewPager main_viewpager;
    private TabLayout main_tab;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        main_viewpager = (ViewPager) findViewById(R.id.main_viewpager);
        main_tab = (TabLayout) findViewById(R.id.main_tab);
        homeFragment = new HomeFragment();//首页
        subjectFragment = new SubjectFragment();//专题
        catalogFragment = new CatalogFragment();//分类
        shoppFragment = new ShoppFragment();//购物车
        ownFragment = new OwnFragment();//我的
        fragmentManager = getSupportFragmentManager();
        List<Fragment> fragments = new ArrayList<>();
        fragments.add(homeFragment);
        fragments.add(subjectFragment);
        fragments.add(catalogFragment);
        fragments.add(shoppFragment);
        fragments.add(ownFragment);
        MainFragmentAdapter mainFragmentAdapter = new MainFragmentAdapter(getSupportFragmentManager(), fragments);
        main_viewpager.setAdapter(mainFragmentAdapter);
        main_tab.setupWithViewPager(main_viewpager);
        main_tab.getTabAt(0).setText("首页").setIcon(R.drawable.shouye);
        main_tab.getTabAt(1).setText("专题").setIcon(R.drawable.zhuanti);
        main_tab.getTabAt(2).setText("分类").setIcon(R.drawable.fenlei);
        main_tab.getTabAt(3).setText("购物车").setIcon(R.drawable.gouwuche);
        main_tab.getTabAt(4).setText("我的").setIcon(R.drawable.wode);
        initFragment();
    }

    private void initFragment() {
        main_tab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
            //触发tab的点击事件

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }
}
