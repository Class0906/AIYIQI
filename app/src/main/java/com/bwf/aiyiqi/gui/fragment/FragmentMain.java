package com.bwf.aiyiqi.gui.fragment;


import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
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
import com.bwf.aiyiqi.view.NestingRefreshLayout;
import com.bwf.aiyiqi.view.ViewPagerIndicator;
import com.bwflmw.framwork.BaseFragment;
import com.bwflmw.framwork.utils.ToastUtil;
import com.cjj.MaterialRefreshLayout;
import com.cjj.MaterialRefreshListener;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * Created by Zoulin on 2016/11/23.
 */

public class FragmentMain extends BaseFragment implements MainView {
    @BindView(R.id.appBarLayout)
    AppBarLayout appBarLayout;
    private MainPresenter presenter;
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
    NestingRefreshLayout refreshlayout;

    @Override
    protected int getContentViewResId() {
        return R.layout.fragment_main;
    }

    @Override
    protected void initData() {
        presenter = new MainPresenterImpl(this);
        presenter.firstLoadData();
    }

    private MainRecyclerViewAdapter adapter;
    private ViewPagerIndicator indicator;
    private boolean isLoading =false;

    @Override
    protected void initView() {
        final LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerview.setLayoutManager(layoutManager);
        adapter = new MainRecyclerViewAdapter(getActivity());
        recyclerview.setAdapter(adapter);
        //下拉刷新
        refreshlayout.setMaterialRefreshListener(new MaterialRefreshListener() {
            @Override
            public void onRefresh(MaterialRefreshLayout materialRefreshLayout) {
                adapter.clearData();
                presenter.firstLoadData();
            }
        });
        appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                if (verticalOffset == 0)
                    refreshlayout.setisCanPull(true);
                else
                    refreshlayout.setisCanPull(false);

            }
        });

        recyclerview.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                if(!isLoading&&layoutManager.findLastVisibleItemPosition()==adapter.getItemCount()-1){
                    isLoading=true;
                    presenter.loadMoreData();
                }
            }
        });
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
        refreshlayout.finishRefresh(); //刷新完成
        viewpagerHomeTitle.setAdapter(new UnlimitPagerAdapter(getActivity(), data.getData()));
        LinearLayout container = (LinearLayout) getView().findViewById(R.id.container_viewpager_indicator);
        indicator = new ViewPagerIndicator(getActivity(), container, data.getData().size());
        indicator.setupWithViewPager(viewpagerHomeTitle);
        Log.d("FragmentMain", "success");
        viewpagerHomeTitle.setAdapter(new com.bwf.aiyiqi.gui.adapter.UnlimitPagerAdapter(getActivity(),data.getData()));
    }

    @Override
    public void showMainRecyclerView(ResponseHomeBBS data) {
        Log.d("FragmentMain", "success");
        isLoading = false;
        adapter.addData(data.getData());
    }

    @Override
    public void showViewpagerFailed() {
        refreshlayout.finishRefresh();//刷新失败
        ToastUtil.toToast("加载失败，请检查网络");
    }

    @Override
    public void showRecyclerFailed() {
        isLoading =false;
    }

}
