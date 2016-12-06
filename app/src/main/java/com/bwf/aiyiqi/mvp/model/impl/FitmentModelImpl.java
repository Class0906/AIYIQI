package com.bwf.aiyiqi.mvp.model.impl;

import android.util.Log;

import com.alibaba.fastjson.JSON;
import com.bwf.aiyiqi.entity.ResponseFitmentAD;
import com.bwf.aiyiqi.entity.ResponseFitmentDirectSeeding;
import com.bwf.aiyiqi.kitutils.Apis;
import com.bwf.aiyiqi.mvp.model.FitmentModel;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import okhttp3.Call;

/**
 * Created by Zoulin on 2016/11/25.
 */

public class FitmentModelImpl implements FitmentModel {
    @Override
    public void loadViewpagerData(final FitmentModelCallback callback) {
        OkHttpUtils.
                get()
                .url(Apis.FITMENT_VIEWPAGER)
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        Log.e("FitmentModelImpl", "call:" + call);
                        callback.onLoadFailed();
                    }

                    @Override
                    public void onResponse(String response, int id) {
                        Log.e("FitmentModelImpl", response);
                        ResponseFitmentAD data = JSON.parseObject(response, ResponseFitmentAD.class);
                        callback.onLoadSuccess(data);
                    }
                });
    }

    @Override
    public void fitmentSeedingDats(final FitmentSeedingModelCallback callback) {
        OkHttpUtils
                .get()
                .url(Apis.FITMENT_SEEDING)
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        Log.d("FitmentModelImpl", "call(fitmentSeedingDats):" + call);
                        callback.onLoadFailed();
                    }

                    @Override
                    public void onResponse(String response, int id) {
                        Log.d("FitmentModelImpl", "response(fitmentSeedingDats)"+response);
                        ResponseFitmentDirectSeeding data=JSON.parseObject(response,ResponseFitmentDirectSeeding.class);
                        callback.onLoadSuccess(data.getData());
                    }
                });
    }
}
