package com.bwf.aiyiqi.mvp.model;

import com.bwf.aiyiqi.entity.ResponseHomeFurne;

/**
 * Created by Zoulin on 2016/12/6.
 */

public interface HomeFurnitureModel {
    void loadViewpagerData(HomeFurnitureModelCallback callback);

    interface HomeFurnitureModelCallback {
        void onLoadSuccess(ResponseHomeFurne data);

        void onLoadFailed();
    }
}
