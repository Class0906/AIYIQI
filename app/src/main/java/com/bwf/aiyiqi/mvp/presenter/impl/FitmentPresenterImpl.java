package com.bwf.aiyiqi.mvp.presenter.impl;

import com.bwf.aiyiqi.entity.ResponseFitmentAD;
import com.bwf.aiyiqi.entity.ResponseFitmentDirectSeeding;
import com.bwf.aiyiqi.mvp.model.FitmentModel;
import com.bwf.aiyiqi.mvp.model.impl.FitmentModelImpl;
import com.bwf.aiyiqi.mvp.presenter.FitmentPresenter;
import com.bwf.aiyiqi.mvp.view.FitmentView;

import java.util.List;

/**
 * Created by Zoulin on 2016/11/25.
 */

public class FitmentPresenterImpl implements FitmentPresenter {
    private FitmentModel model;
    private FitmentView view;

    public FitmentPresenterImpl(FitmentView view){
        this.view=view;
        model=new FitmentModelImpl();
    }
    //轮播图片的数据
    @Override
    public void firstLoadData() {
        //加载ViewPager
        model.loadViewpagerData(new FitmentModel.FitmentModelCallback() {
            @Override
            public void onLoadSuccess(ResponseFitmentAD data) {
                view.showMainViewPager(data);
            }

            @Override
            public void onLoadFailed() {
                view.showFailed();
            }
        });
    }
    //装修直播的数据
    @Override
    public void fitmentseedingData() {
        model.fitmentSeedingDats(new FitmentModel.FitmentSeedingModelCallback() {
            @Override
            public void onLoadSuccess(List<ResponseFitmentDirectSeeding.DataBean> data) {
                view.showFitmentViewPager(data);
            }

            @Override
            public void onLoadFailed() {
                view.showFailed();
            }
        });
    }
}
