package com.bwf.aiyiqi.mvp.model;

import com.bwf.aiyiqi.entity.ResponseEffectbeutiPicture;

/**
 * Created by Zoulin on 2016/12/2.
 */

public interface EffectPicturebeuModel {
    void loadEffectPictureData(EffectPicturebeuModelCallback callback);
    interface EffectPicturebeuModelCallback{
        void onLoadSuccess(ResponseEffectbeutiPicture data);
        void onLoadFailed();
    }

}
