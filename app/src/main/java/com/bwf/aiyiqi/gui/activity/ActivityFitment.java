package com.bwf.aiyiqi.gui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ScrollView;

import com.bwf.aiyiqi.R;
import com.bwf.aiyiqi.view.AutoScorllViewPager;
import com.bwflmw.framwork.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Zoulin on 2016/11/24.
 */

public class ActivityFitment extends BaseActivity {
    @BindView(R.id.main_titile_fitment_img)
    ImageView mainTitileFitmentImg;
    @BindView(R.id.viewPager_main_list_slide)
    AutoScorllViewPager viewPagerMainListSlide;
    @BindView(R.id.linearLayout_pager_indicator)
    LinearLayout linearLayoutPagerIndicator;
    @BindView(R.id.activity_fragment_fitment_linner1)
    LinearLayout activityFragmentFitmentLinner1;
    @BindView(R.id.activity_fragment_fitment_linner2)
    LinearLayout activityFragmentFitmentLinner2;
    @BindView(R.id.fitment_look_site)
    ImageView fitmentLookSite;
    @BindView(R.id.fitment_site_playing)
    ImageView fitmentSitePlaying;
    @BindView(R.id.fitment_yiqi_group)
    ImageView fitmentYiqiGroup;
    @BindView(R.id.Decorate_live_linner)
    ListView DecorateLiveLinner;
    @BindView(R.id.scrollView_fitment)
    ScrollView scrollViewFitment;

    @Override
    protected int getContentViewResId() {
        return R.layout.activity_fitment;
    }

    @Override
    protected void initView() {

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

    @OnClick({R.id.activity_fragment_fitment_linner1, R.id.activity_fragment_fitment_linner2, R.id.fitment_look_site, R.id.fitment_site_playing, R.id.fitment_yiqi_group,R.id.main_titile_fitment_img})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.main_titile_fitment_img:
                gotoMain();
                break;
            case R.id.activity_fragment_fitment_linner1:
                break;
            case R.id.activity_fragment_fitment_linner2:
                break;
            case R.id.fitment_look_site:
                break;
            case R.id.fitment_site_playing:
                break;
            case R.id.fitment_yiqi_group:
                break;
        }
    }
    public void gotoMain(){
        startActivity(new Intent(this,MainActivity.class));
        finish();
    }
}
