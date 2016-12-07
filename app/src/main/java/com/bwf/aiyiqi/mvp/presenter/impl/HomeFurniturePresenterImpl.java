package com.bwf.aiyiqi.mvp.presenter.impl;

import com.bwf.aiyiqi.entity.ResponseHomeFurne;
import com.bwf.aiyiqi.mvp.model.HomeFurnitureModel;
import com.bwf.aiyiqi.mvp.model.impl.HomeFurnitureModelImpl;
import com.bwf.aiyiqi.mvp.presenter.HomeFurniturePresenter;
import com.bwf.aiyiqi.mvp.view.HomeFurnitureView;

/**
 * Created by Zoulin on 2016/12/6.
 */

public class HomeFurniturePresenterImpl implements HomeFurniturePresenter {

    private HomeFurnitureView view;
    private HomeFurnitureModel model;

    public HomeFurniturePresenterImpl(HomeFurnitureView view) {
        this.view = view;
        this.model = new HomeFurnitureModelImpl();
    }

    @Override
    public void homefunritureData() {
        model.loadViewpagerData(new HomeFurnitureModel.HomeFurnitureModelCallback() {
            @Override
            public void onLoadSuccess(ResponseHomeFurne data) {
                view.showMainViewPager(data);
            }

            @Override
            public void onLoadFailed() {
                view.showFailed();
            }
        });
    }

}
