package com.bwf.aiyiqi.mvp.presenter.impl;

import com.bwf.aiyiqi.entity.ResponseTheSame;
import com.bwf.aiyiqi.mvp.model.TheSameModel;
import com.bwf.aiyiqi.mvp.model.impl.TheSameModelImpl;
import com.bwf.aiyiqi.mvp.presenter.TheSamePresenter;
import com.bwf.aiyiqi.mvp.view.TheSameView;

/**
 * Created by Zoulin on 2016/11/30.
 */

public class TheSamePresenterImpl implements TheSamePresenter {
    private TheSameView view;
    private TheSameModel model;


    public TheSamePresenterImpl(TheSameView view) {
        this.view = view;
        model = new TheSameModelImpl();
    }

    @Override
    public void thesameData() {
        model.thesameData(new TheSameModel.TheSameModelCallback() {
            @Override
            public void onLoadSuccess(ResponseTheSame responseTheSame) {
                view.thasameView(responseTheSame);
            }

            @Override
            public void onLoadFailed() {
                view.showFailed();
            }
        });
    }
}
