package com.bwf.aiyiqi.mvp.presenter.impl;

import com.bwf.aiyiqi.entity.ResponseEffectPicture;
import com.bwf.aiyiqi.mvp.model.EffectPictureModel;
import com.bwf.aiyiqi.mvp.model.impl.EffectPictureModelImpl;
import com.bwf.aiyiqi.mvp.presenter.EffectPicturePreseenter;
import com.bwf.aiyiqi.mvp.view.EffectPictureView;

/**
 * Created by Zoulin on 2016/12/2.
 */

public class EffectPicturePreseenterImpl implements EffectPicturePreseenter {
    private EffectPictureModel model;
    private EffectPictureView view;


    public EffectPicturePreseenterImpl(EffectPictureView view) {
        this.view = view;
        model = new EffectPictureModelImpl();
    }
    //加载专题的数据
    @Override
    public void EffectPictureData() {
        model.loadEffectPictureData(new EffectPictureModel.EffectPictureModelCallback() {
            @Override
            public void onLoadSuccess(ResponseEffectPicture data) {
                view.showEffectPicturelistView(data);
            }

            @Override
            public void onLoadFailed() {
                view.showFailed();
            }
        });
    }
}
