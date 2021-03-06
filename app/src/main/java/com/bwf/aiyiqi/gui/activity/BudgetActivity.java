package com.bwf.aiyiqi.gui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;

import com.bwf.aiyiqi.R;
import com.bwf.aiyiqi.gui.adpter.MyBudgetAdapter;
import com.bwflmw.framwork.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Zoulin on 2016/12/6.
 */
public class BudgetActivity extends BaseActivity implements View.OnClickListener {
    @BindView(R.id.design_discharge_room_activity_back)
    ImageView designDischargeRoomActivityBack;
    @BindView(R.id.design_discharge_room_activity_tablayout)
    TabLayout designDischargeRoomActivityTablayout;
    @BindView(R.id.design_discharge_room_activity_viewpager)
    ViewPager designDischargeRoomActivityViewpager;

    @Override
    protected int getContentViewResId() {
        return R.layout.budget_mian_activity;
    }

    @Override
    protected void initView() {
        ButterKnife.bind(this);
        designDischargeRoomActivityBack.setOnClickListener(this);
        //设置页卡
        designDischargeRoomActivityTablayout.addTab(designDischargeRoomActivityTablayout.newTab().setText("免费设计"));
        designDischargeRoomActivityTablayout.addTab(designDischargeRoomActivityTablayout.newTab().setText("免费量房"));
        //方向设置
        designDischargeRoomActivityTablayout.setTabGravity(TabLayout.GRAVITY_FILL);
        //绑定适配器
        MyBudgetAdapter budgetAdapter = new MyBudgetAdapter(getSupportFragmentManager(), designDischargeRoomActivityTablayout.getTabCount());
        designDischargeRoomActivityViewpager.setAdapter(budgetAdapter);
        //开启监听实现滑动一体
        designDischargeRoomActivityViewpager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(designDischargeRoomActivityTablayout));
        designDischargeRoomActivityTablayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                designDischargeRoomActivityViewpager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }

    @Override
    protected void initData() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.design_discharge_room_activity_back:
                startActivity(new Intent(this,MainActivity.class));
                finish();
        }
    }
}
