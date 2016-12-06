package com.bwf.aiyiqi.mvp.model.impl;

import android.util.Log;

import com.alibaba.fastjson.JSON;
import com.bwf.aiyiqi.entity.ResponseEffectbeutiPicture;
import com.bwf.aiyiqi.kitutils.Apis;
import com.bwf.aiyiqi.mvp.model.EffectPicturebeuModel;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import okhttp3.Call;

/**
 * Created by Zoulin on 2016/12/5.
 */

public class EffectPicturebeuModelImpl implements EffectPicturebeuModel {
    private int nextpage;
    @Override
    public void loadEffectPictureData(final EffectPicturebeuModelCallback callback) {
        OkHttpUtils.post()
                .url(Apis.EFFECT_PICTURE)
                .addParams("version", "1")
                .addParams("page", nextpage + "")
                .addParams("pagesize", "10")
                .addParams("action", "imageList2")
                .addParams("tagid", "0")
                .addParams("model", "android")
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        callback.onLoadFailed();
                    }

                    @Override
                    public void onResponse(String response, int id) {
                        Log.d("EffectPicturebeuModelIm", response);
                        ResponseEffectbeutiPicture effectbeutiPicture = JSON.parseObject(response, ResponseEffectbeutiPicture.class);
                        if (effectbeutiPicture.getError().equals("0")) {
                            callback.onLoadSuccess(effectbeutiPicture);
                            nextpage++;
                        } else {
                            callback.onLoadFailed();
                        }
                    }
                });
    }
}
