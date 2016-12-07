package com.bwf.aiyiqi.mvp.presenter.impl;

import com.bwf.aiyiqi.entity.ResponseEffectbeutiPicture;
import com.bwf.aiyiqi.mvp.model.EffectPicturebeuModel;
import com.bwf.aiyiqi.mvp.model.impl.EffectPicturebeuModelImpl;
import com.bwf.aiyiqi.mvp.presenter.EffectPicturebeuPresenter;
import com.bwf.aiyiqi.mvp.view.EffectPicturebeuView;

/**
 * Created by Zoulin on 2016/12/5.
 */

public class EffectPicturebeuPresenterImpl implements EffectPicturebeuPresenter {
    private EffectPicturebeuModel model;
    private EffectPicturebeuView view;

    public EffectPicturebeuPresenterImpl(EffectPicturebeuView view){
        this.view=view;
        model=new EffectPicturebeuModelImpl();
    }

    @Override
    public void EffectPicturebeuData() {
        model.loadEffectPictureData(new EffectPicturebeuModel.EffectPicturebeuModelCallback() {
            @Override
            public void onLoadSuccess(ResponseEffectbeutiPicture data) {
                view.showEffectPicturebeugridView(data);
            }

            @Override
            public void onLoadFailed() {
                view.showFailed();
            }
        });
    }
}
