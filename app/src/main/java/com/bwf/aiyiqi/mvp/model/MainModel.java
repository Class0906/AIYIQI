package com.bwf.aiyiqi.mvp.model;

import com.bwf.aiyiqi.entity.ResponseHomeAD;
import com.bwf.aiyiqi.entity.ResponseHomeBBS;

/**
 * Created by Zoulin on 2016/11/23.
 */

public interface MainModel {
    void loadViewpagerData(MainModelCallback callback);
    void loadRecyclerViewData(MainRecyclerViewCallback callback);
    interface MainModelCallback{
        void onLoadSuccess(ResponseHomeAD data);
        void onLoadFailed();
    }
    interface MainRecyclerViewCallback{
        void onLoadSuccess(ResponseHomeBBS data);
        void onLoadFailed();
    }
}
