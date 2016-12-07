package com.bwf.aiyiqi.mvp.model.impl;

import com.alibaba.fastjson.JSON;
import com.bwf.aiyiqi.entity.ResponseBBS;
import com.bwf.aiyiqi.entity.ResponseBBSComments;
import com.bwf.aiyiqi.entity.ResponseBBSLikedList;
import com.bwf.aiyiqi.kitutils.Apis;
import com.bwf.aiyiqi.mvp.model.BBSModel;
import com.bwflmw.framwork.utils.UrlHandler;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import okhttp3.Call;

/**
 * Created by lmw on 2016/11/29.
 */

public class BBSModelImpl implements BBSModel {
    private int nextPage = 1;

    @Override
    public void loadData(String bbsID, final BBSCallback callback) {
        OkHttpUtils
                .get()
                .url(UrlHandler.handleUrl(Apis.BBS, bbsID))
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        callback.onFailed();
                    }

                    @Override
                    public void onResponse(String response, int id) {
                        ResponseBBS data = JSON.parseObject(response, ResponseBBS.class);
                        if (data != null && data.getError().equals("0")) {
                            callback.onSuccess(data);
                        } else
                            callback.onFailed();
                    }
                });
    }

    @Override
    public void loadLikedData(String bbsID, final BBSLikedCallback callback) {
        OkHttpUtils
                .get()
                .url(UrlHandler.handleUrl(Apis.BBS_LICKED, bbsID))
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        callback.onFailed();
                    }

                    @Override
                    public void onResponse(String response, int id) {
                        ResponseBBSLikedList data = JSON.parseObject(response, ResponseBBSLikedList.class);
                        if (data.getError().equals("0"))
                            callback.onSuccess(data);
                        else
                            callback.onFailed();
                    }
                });
    }

    @Override
    public void loadCommentsData(String bbsID, final BBSCommentsCallback callback) {
        OkHttpUtils
                .get()
                .url(UrlHandler.handleUrl(Apis.BBS_COMMENTS, bbsID, nextPage))
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        callback.onFailed();
                    }

                    @Override
                    public void onResponse(String response, int id) {
                        ResponseBBSComments data = JSON.parseObject(response, ResponseBBSComments.class);
                        if (data.getError().equals("0")) {
                            nextPage++;
                            callback.onSuccess(data);
                        } else
                            callback.onFailed();
                    }
                });
    }
}
