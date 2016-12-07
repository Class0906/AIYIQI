package com.bwf.aiyiqi.mvp.model;

import com.bwf.aiyiqi.entity.ResponseEffectPicture;

/**
 * Created by Zoulin on 2016/12/2.
 */

public interface EffectPictureModel {
    void loadEffectPictureData(EffectPictureModelCallback callback);
    interface EffectPictureModelCallback{
        void onLoadSuccess(ResponseEffectPicture data);
        void onLoadFailed();
    }

}
