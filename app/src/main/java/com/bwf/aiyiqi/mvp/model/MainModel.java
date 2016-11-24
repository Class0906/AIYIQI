package com.bwf.aiyiqi.mvp.model;

import com.bwf.aiyiqi.entity.ResponseBatching;

/**
 * Created by Zoulin on 2016/11/23.
 */

public interface MainModel {
    void loadDatas(OnBatchingLoadCallback callback);
    public interface OnBatchingLoadCallback{
        void onBatchingLoadSuccess(ResponseBatching batching);
        void onBatchingLoadFailed();
    }
}
