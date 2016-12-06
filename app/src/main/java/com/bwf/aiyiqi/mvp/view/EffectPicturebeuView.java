package com.bwf.aiyiqi.mvp.view;

import com.bwf.aiyiqi.entity.ResponseEffectbeutiPicture;

/**
 * Created by Zoulin on 2016/12/5.
 */

public interface EffectPicturebeuView {
    //专题数据加载
    void showEffectPicturebeugridView(ResponseEffectbeutiPicture data);

    void showFailed();
}
