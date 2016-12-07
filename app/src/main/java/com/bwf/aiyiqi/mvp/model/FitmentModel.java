package com.bwf.aiyiqi.mvp.model;

import com.bwf.aiyiqi.entity.ResponseFitmentAD;
import com.bwf.aiyiqi.entity.ResponseFitmentDirectSeeding;

import java.util.List;

/**
 * Created by Zoulin on 2016/11/25.
 */

public interface FitmentModel {
    void loadViewpagerData(FitmentModelCallback callback);
    void fitmentSeedingDats(FitmentSeedingModelCallback callback);
    interface   FitmentModelCallback{
        void onLoadSuccess(ResponseFitmentAD data);
        void onLoadFailed();
    }
    interface  FitmentSeedingModelCallback{
        void onLoadSuccess(List<ResponseFitmentDirectSeeding.DataBean> data);
        void onLoadFailed();
    }
}
