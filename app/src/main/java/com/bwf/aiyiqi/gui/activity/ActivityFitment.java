package com.bwf.aiyiqi.gui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.Toast;

import com.bwf.aiyiqi.R;
import com.bwf.aiyiqi.entity.ResponseFitmentAD;
import com.bwf.aiyiqi.entity.ResponseFitmentDirectSeeding;
import com.bwf.aiyiqi.gui.activity.web.NewHouseAcitivity;
import com.bwf.aiyiqi.gui.activity.web.OldHouseActivity;
import com.bwf.aiyiqi.gui.activity.web.TeamActivity;
import com.bwf.aiyiqi.gui.adpter.FitmentDiredtSeedingAdpter;
import com.bwf.aiyiqi.gui.adpter.FitmentPagerAdpter;
import com.bwf.aiyiqi.mvp.presenter.FitmentPresenter;
import com.bwf.aiyiqi.mvp.presenter.impl.FitmentPresenterImpl;
import com.bwf.aiyiqi.mvp.view.FitmentView;
import com.bwf.aiyiqi.view.FitmentAutoScorllViewPager;
import com.bwf.aiyiqi.view.ViewPagerIndicator;
import com.bwflmw.framwork.BaseActivity;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Zoulin on 2016/11/24.
 */

public class ActivityFitment extends BaseActivity implements FitmentView {
    private ViewPagerIndicator indicator;

    @BindView(R.id.main_titile_fitment_img)
    ImageView mainTitileFitmentImg;
    @BindView(R.id.viewpager_fitment_title)
    FitmentAutoScorllViewPager viewpagerFitmentTitle;
    @BindView(R.id.fitment_container_viewpager_indicator)
    LinearLayout fitmentContainerViewpagerIndicator;
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
        ButterKnife.bind(this);
        viewpagerFitmentTitle.setOffscreenPageLimit(1);

    }

    @Override
    protected void initData() {
        FitmentPresenter presenter = new FitmentPresenterImpl(this);
        presenter.firstLoadData();
        presenter.fitmentseedingData();
    }

    @OnClick({R.id.activity_fragment_fitment_linner1, R.id.activity_fragment_fitment_linner2, R.id.fitment_look_site, R.id.fitment_site_playing, R.id.fitment_yiqi_group, R.id.main_titile_fitment_img})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.main_titile_fitment_img:
                gotoMain();
                break;
            case R.id.activity_fragment_fitment_linner1:
                startActivity(new Intent(this, NewHouseAcitivity.class));
                break;
            case R.id.activity_fragment_fitment_linner2:
                startActivity(new Intent(this, OldHouseActivity.class));
                break;
            case R.id.fitment_look_site:
                break;
            case R.id.fitment_site_playing:
                break;
            case R.id.fitment_yiqi_group:
                startActivity(new Intent(this, TeamActivity.class));
                break;
        }
    }

    public void gotoMain() {
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }

    @Override
    public void showMainViewPager(ResponseFitmentAD data) {
        Toast.makeText(this, "sucess", Toast.LENGTH_SHORT).show();
        viewpagerFitmentTitle.setAdapter(new FitmentPagerAdpter(this, data.getData()));
        indicator=new ViewPagerIndicator(this,fitmentContainerViewpagerIndicator,data.getData().size());
        indicator.setupWithViewPager(viewpagerFitmentTitle);
    }

    @Override
    public void showFitmentViewPager(List<ResponseFitmentDirectSeeding.DataBean> data) {
        FitmentDiredtSeedingAdpter adpter=new FitmentDiredtSeedingAdpter(this,data);
        DecorateLiveLinner.setAdapter(adpter);
    }


    @Override
    public void showFailed() {
        Toast.makeText(this, "failed", Toast.LENGTH_SHORT).show();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
