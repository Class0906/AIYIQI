package com.bwf.aiyiqi.mvp.model;

import com.bwf.aiyiqi.entity.ResponseTheSame;

/**
 * Created by Zoulin on 2016/11/30.
 */

public interface TheSameModel {
    void thesameData(TheSameModelCallback callback);

    interface  TheSameModelCallback{
        void onLoadSuccess(ResponseTheSame responseTheSame);
        void onLoadFailed();
    }
}
