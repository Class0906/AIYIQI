package com.bwf.aiyiqi.mvp.model.impl;

import android.util.Log;

import com.alibaba.fastjson.JSON;
import com.bwf.aiyiqi.entity.ResponseHomeAD;
import com.bwf.aiyiqi.entity.ResponseHomeBBS;
import com.bwf.aiyiqi.kitutils.Apis;
import com.bwf.aiyiqi.mvp.model.MainModel;
import com.bwflmw.framwork.utils.UrlHandler;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import okhttp3.Call;

/**
 * Created by lmw on 2016/11/24.
 */

public class MainModelImpl implements MainModel {
    private int nextPage = 1;
    private int lastType;
    private String lastId;

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
                    }

                    @Override
                    public void onResponse(String response, int id) {
                        Log.d("MainModelImpl", response);
                        ResponseHomeAD data = JSON.parseObject(response, ResponseHomeAD.class);
                        callback.onLoadSuccess(data);
                    }
                });
    }

    @Override
    public void loadRecyclerViewData(final MainRecyclerViewCallback callback) {
        if (nextPage == 1) {
            OkHttpUtils.get()
                    .url(Apis.HOME_BBS_BASE)
                    .build()
                    .execute(new StringCallback() {
                        @Override
                        public void onError(Call call, Exception e, int id) {
                            callback.onLoadFailed();
                        }
                        @Override
                        public void onResponse(String response, int id) {
                            ResponseHomeBBS data = JSON.parseObject(response, ResponseHomeBBS.class);
                            String error = data.getError();
                            if (error.equals("0")){
                                callback.onLoadSuccess(data);
                                nextPage++;
                                lastType = data.getData().get(data.getData().size()-1).getType();
                                lastId = data.getData().get(data.getData().size()-1).getId();

                            }else
                                callback.onLoadFailed();
                        }
                    });
        }else {
            OkHttpUtils.get()
                    .url(UrlHandler.handleUrl(Apis.HOME_BBS_MORE,nextPage,lastType,lastId))
                    .build()
                    .execute(new StringCallback() {
                        @Override
                        public void onError(Call call, Exception e, int id) {
                            callback.onLoadFailed();
                        }
                        @Override
                        public void onResponse(String response, int id) {
                            ResponseHomeBBS data = JSON.parseObject(response, ResponseHomeBBS.class);
                            String error = data.getError();
                            if (error.equals("0")){
                                callback.onLoadSuccess(data);
                                nextPage++;
                                lastType = data.getData().get(data.getData().size()-1).getType();
                                lastId = data.getData().get(data.getData().size()-1).getId();
                            }else
                                callback.onLoadFailed();
                        }
                    });
        }
    }
}
