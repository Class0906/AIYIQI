package com.bwf.aiyiqi.mvp.model.impl;

import android.util.Log;

import com.alibaba.fastjson.JSON;
import com.bwf.aiyiqi.entity.ResponseTheSame;
import com.bwf.aiyiqi.kitutils.Apis;
import com.bwf.aiyiqi.mvp.model.TheSameModel;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import okhttp3.Call;

/**
 * Created by Zoulin on 2016/11/30.
 */

public class TheSameModelImpl implements TheSameModel {
    @Override
    public void thesameData(final TheSameModelCallback callback) {
        OkHttpUtils.get()
                .url(Apis.THE_SAME)
                .addParams("page","1")
                .addParams("pageSize","10")
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        callback.onLoadFailed();
                    }

                    @Override
                    public void onResponse(String response, int id) {
                        Log.d("TheSameModelImpl","response:"+response);
                        ResponseTheSame theSame=JSON.parseObject(response, ResponseTheSame.class);
                        callback.onLoadSuccess(theSame);
                    }
                });

    }
}
