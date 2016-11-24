package com.bwf.aiyiqi.mvp.model.impl;

import android.util.Log;

import com.alibaba.fastjson.JSON;
import com.bwf.aiyiqi.entity.ResponseHomeAD;
import com.bwf.aiyiqi.kitutils.Apis;
import com.bwf.aiyiqi.mvp.model.MainModel;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import okhttp3.Call;

/**
 * Created by lmw on 2016/11/24.
 */

public class MainModelImpl implements MainModel {
    @Override
    public void loadViewpagerData(final MainModelCallback callback) {
        OkHttpUtils
                .get()
                .url(Apis.HOME_VIEWPAGER)
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        callback.onLoadFailed();
                        Log.d("MainModelImpl", "call:" + call);
                    }

                    @Override
                    public void onResponse(String response, int id) {
                        Log.d("MainModelImpl", response);
                        ResponseHomeAD data = JSON.parseObject(response, ResponseHomeAD.class);
                        callback.onLoadSuccess(data);
                    }
                });
    }
}
