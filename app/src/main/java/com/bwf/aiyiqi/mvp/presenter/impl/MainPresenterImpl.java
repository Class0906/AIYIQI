package com.bwf.aiyiqi.mvp.presenter.impl;

import com.bwf.aiyiqi.entity.ResponseHomeAD;
import com.bwf.aiyiqi.entity.ResponseHomeBBS;
import com.bwf.aiyiqi.mvp.model.MainModel;
import com.bwf.aiyiqi.mvp.model.impl.MainModelImpl;
import com.bwf.aiyiqi.mvp.presenter.MainPresenter;
import com.bwf.aiyiqi.mvp.view.MainView;

/**
 * Created by Zoulin on 2016/11/23.
 */

public class MainPresenterImpl implements MainPresenter {
    private MainModel model;
    private MainView view;

    public MainPresenterImpl(MainView view) {
        this.view = view;
        model = new MainModelImpl();
    }

    @Override
    public void firstLoadData() {
        model.loadViewpagerData(new MainModel.MainModelCallback() {

            @Override
            public void onLoadSuccess(ResponseHomeAD data) {
                view.showMainViewPager(data);
            }

            @Override
            public void onLoadFailed() {
                view.showFailed();
            }
        });
        model.loadRecyclerViewData(new MainModel.MainRecyclerViewCallback() {
            @Override
            public void onLoadSuccess(ResponseHomeBBS data) {
                view.showMainRecyclerView(data);
            }

            @Override
            public void onLoadFailed() {
                view.showFailed();
            }
        });
    }

    @Override
    public void loadMoreData() {
        model.loadRecyclerViewData(new MainModel.MainRecyclerViewCallback() {
            @Override
            public void onLoadSuccess(ResponseHomeBBS data) {
                view.showMainRecyclerView(data);
            }

            @Override
            public void onLoadFailed() {
                view.showFailed();
            }
        });
    }
}
