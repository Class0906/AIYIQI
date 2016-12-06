package com.bwf.aiyiqi.mvp.view;

import com.bwf.aiyiqi.entity.ResponseEffectPicture;

/**
 * Created by Zoulin on 2016/12/2.
 */

public interface EffectPictureView {
    //专题数据加载
    void showEffectPicturelistView(ResponseEffectPicture data);

    void showFailed();
}
