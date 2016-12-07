package com.bwf.aiyiqi.mvp.model.impl;

import android.util.Log;

import com.alibaba.fastjson.JSON;
import com.bwf.aiyiqi.entity.ResponseEffectPicture;
import com.bwf.aiyiqi.kitutils.Apis;
import com.bwf.aiyiqi.mvp.model.EffectPictureModel;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import okhttp3.Call;

/**
 * Created by Zoulin on 2016/12/2.
 */

public class EffectPictureModelImpl implements EffectPictureModel {
    //页数参数
    private int nextPage=1;
    @Override
    public void loadEffectPictureData(final EffectPictureModelCallback callback) {
        OkHttpUtils.post()
                .url(Apis.EFFECT_SPECOAL)
                .addParams("version","1")
                .addParams("page",nextPage+"")
                .addParams("pagesize","10")
                .addParams("action","ablumList2")
                .addParams("tagid ","1")
                .addParams("model","android")
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        Log.d("EffectPictureModelImpl", "call:" + call);
                        callback.onLoadFailed();
                    }

                    @Override
                    public void onResponse(String response, int id) {
                        Log.e("EffectPictureModelImpl", "response:"+response);
                        ResponseEffectPicture effectPicture=JSON.parseObject(response, ResponseEffectPicture.class);
                       if (effectPicture.getError().equals("0")){
                           callback.onLoadSuccess(effectPicture);
                           Log.e("EffectPictureModelImpl", "nextPage:" + nextPage);
                           nextPage++;
                       }else{
                           callback.onLoadFailed();
                       }

                    }
                });

    }
}
