package com.bwf.aiyiqi.mvp.model;

import com.bwf.aiyiqi.entity.ResponseHomeAD;

/**
 * Created by Zoulin on 2016/11/23.
 */

public interface MainModel {
    void loadViewpagerData(MainModelCallback callback);
    interface MainModelCallback{
        void onLoadSuccess(ResponseHomeAD data);
        void onLoadFailed();
    }

}
