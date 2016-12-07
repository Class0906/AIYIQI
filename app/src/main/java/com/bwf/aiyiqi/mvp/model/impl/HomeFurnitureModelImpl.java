package com.bwf.aiyiqi.mvp.model.impl;

import android.util.Log;

import com.alibaba.fastjson.JSON;
import com.bwf.aiyiqi.entity.ResponseHomeFurne;
import com.bwf.aiyiqi.kitutils.Apis;
import com.bwf.aiyiqi.mvp.model.HomeFurnitureModel;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import okhttp3.Call;

/**
 * Created by Zoulin on 2016/12/6.
 */

public class HomeFurnitureModelImpl implements HomeFurnitureModel {
    @Override
    public void loadViewpagerData(final HomeFurnitureModelCallback callback) {
        OkHttpUtils.post()
                .url(Apis.HOME_FURNITURE)
                .addParams("a", "product")
                .addParams("m", "misc")
                .addParams("uuid", "a444d1b2af4f")
                .addParams("app_version ", "android_com.aiyiqi.galaxy_1.1")
                .addParams("model", "android")
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        Log.d("HomeFurnitureModelImpl", "call:" + call);
                        callback.onLoadFailed();
                    }

                    @Override
                    public void onResponse(String response, int id) {
                        Log.d("HomeFurnitureModelImpl", response);
                        ResponseHomeFurne homeFurne = JSON.parseObject(response, ResponseHomeFurne.class);
                        callback.onLoadSuccess(homeFurne);
                    }
                });
    }
}
