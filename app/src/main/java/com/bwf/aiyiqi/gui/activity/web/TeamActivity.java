package com.bwf.aiyiqi.gui.activity.web;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bwf.aiyiqi.R;
import com.bwf.aiyiqi.gui.activity.ActivityFitment;
import com.bwf.aiyiqi.gui.adpter.MyAdapter;
import com.bwflmw.framwork.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Zoulin on 2016/11/28.
 * 一起团队
 */

public class TeamActivity extends BaseActivity {


    @BindView(R.id.main_titile_fitment_img)
    ImageView mainTitileFitmentImg;
    @BindView(R.id.icluce_text_activity)
    TextView icluceTextActivity;
    @BindView(R.id.fitment_team_title_tablayout)
    TabLayout fitmentTeamTitleTablayout;
    @BindView(R.id.fitment_team_title_viewpgaer)
    ViewPager fitmentTeamTitleViewpgaer;

    @Override
    protected int getContentViewResId() {
        return R.layout.activity_fitment_team;
    }

    /**
     * 初始化控件
     */
    @Override
    protected void initView() {
        ButterKnife.bind(this);
        //设置页卡名称
        fitmentTeamTitleTablayout.addTab(fitmentTeamTitleTablayout.newTab().setText("设计师"));
        fitmentTeamTitleTablayout.addTab(fitmentTeamTitleTablayout.newTab().setText("工长"));
        fitmentTeamTitleTablayout.addTab(fitmentTeamTitleTablayout.newTab().setText("监理"));
        //方向设置
        fitmentTeamTitleTablayout.setTabGravity(TabLayout.GRAVITY_FILL);
        //绑定适配器
        MyAdapter myAdapter = new MyAdapter(getSupportFragmentManager(), fitmentTeamTitleTablayout.getTabCount());
        fitmentTeamTitleViewpgaer.setAdapter(myAdapter);
        //开启监听 使得viewpager与tablayout滑动一体
        fitmentTeamTitleViewpgaer.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(fitmentTeamTitleTablayout));
        fitmentTeamTitleTablayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                fitmentTeamTitleViewpgaer.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        mainTitileFitmentImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoFit();
            }
        });
    }


    /**
     * 初始化数据
     */
    @Override
    protected void initData() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
        icluceTextActivity.setText("一起团队");
    }

    public void gotoFit() {
        startActivity(new Intent(this, ActivityFitment.class));
        finish();
    }
}
