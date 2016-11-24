package com.bwf.aiyiqi.mvp.view;

import com.bwf.aiyiqi.entity.ResponseBatching;

/**
 * Created by Zoulin on 2016/11/23.
 */

public interface MainView {
    void showBatchingData(ResponseBatching batching);
    void showLoadBatchingError();
}
