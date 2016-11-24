package com.bwf.aiyiqi.gui.fragment;


import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bwf.aiyiqi.R;
import com.bwf.aiyiqi.entity.ResponseHomeAD;
import com.bwf.aiyiqi.entity.ResponseHomeBBS;
import com.bwf.aiyiqi.gui.adapter.MainRecyclerViewAdapter;
import com.bwf.aiyiqi.gui.adapter.UnlimitPagerAdapter;
import com.bwf.aiyiqi.mvp.presenter.MainPresenter;
import com.bwf.aiyiqi.mvp.presenter.impl.MainPresenterImpl;
import com.bwf.aiyiqi.mvp.view.MainView;
import com.bwf.aiyiqi.view.AutoScorllViewPager;
import com.bwflmw.framwork.BaseFragment;
import com.cjj.MaterialRefreshLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * Created by Zoulin on 2016/11/23.
 */

public class FragmentMain extends BaseFragment implements MainView {

    @BindView(R.id.viewpager_home_title)
    AutoScorllViewPager viewpagerHomeTitle;
    @BindView(R.id.container_viewpager_indicator)
    LinearLayout containerViewpagerIndicator;
    @BindView(R.id.image_scan)
    ImageView imageScan;
    @BindView(R.id.image_home_flag)
    ImageView imageHomeFlag;
    @BindView(R.id.text_city)
    TextView textCity;
    @BindView(R.id.layout_home_title_search)
    LinearLayout layoutHomeTitleSearch;
    @BindView(R.id.recyclerview)
    RecyclerView recyclerview;
    @BindView(R.id.refreshlayout)
    MaterialRefreshLayout refreshlayout;

    @Override
    protected int getContentViewResId() {
        return R.layout.fragment_main;
    }

    @Override
    protected void initData() {
        MainPresenter presenter = new MainPresenterImpl(this);
        presenter.firstLoadData();
    }

    @Override
    protected void initView() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerview.setLayoutManager(layoutManager);
        recyclerview.setAdapter(new MainRecyclerViewAdapter());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.bind(this, rootView);
        return rootView;
    }

    @OnClick({R.id.image_scan, R.id.image_home_flag, R.id.text_city, R.id.layout_home_title_search})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.image_scan:
                break;
            case R.id.image_home_flag:
                break;
            case R.id.text_city:
                break;
            case R.id.layout_home_title_search:
                break;
        }
    }

    @Override
    public void showMainViewPager(ResponseHomeAD data) {
        Log.d("FragmentMain", "success");
        viewpagerHomeTitle.setAdapter(new UnlimitPagerAdapter(getActivity(),data.getData()));
    }

    @Override
    public void showMainRecyclerView(ResponseHomeBBS data) {

    }

    @Override
    public void showFailed() {
        Log.d("FragmentMain", "failed");
    }
}
