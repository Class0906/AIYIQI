package com.bwf.aiyiqi.mvp.model.impl;

import android.util.Log;

import com.alibaba.fastjson.JSON;
import com.bwf.aiyiqi.entity.ResponseTeam;
import com.bwf.aiyiqi.kitutils.Apis;
import com.bwf.aiyiqi.mvp.model.TeamModel;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import okhttp3.Call;

/**
 * Created by Zoulin on 2016/11/29.
 */

public class TeamModelImpl implements TeamModel {
    private int nextPage = 0;

    @Override
    public void TeamStylistDats(final TeamModelCallback callback) {

        OkHttpUtils.post()
                .url(Apis.FITMENT_TEAM)
                .addParams("token", "DAB088BA50C9405E84C789055D657614")
                .addParams("app_version", "android_com.aiyiqi.galaxy_1.1")
                .addParams("type", "1701")
                .addParams("haspermission", "yes")
                .addParams("pageNo", nextPage + "")
                .addParams("pageSize", "10")
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        Log.d("TeamModelImpl", "call:" + call);
                        callback.onLoadFailed();
                    }

                    @Override
                    public void onResponse(String response, int id) {


                        ResponseTeam responseTeam = JSON.parseObject(response, ResponseTeam.class);
                        if (responseTeam.getBaseOutput().getCode().equals("0")) {
                            callback.onLoadSuccess(responseTeam);
                            Log.d("TeamModelImpl", "nextPage:" + nextPage);
                            nextPage++;
                            Log.d("TeamModelImpl", "response" + response);
                        } else {
                            callback.onLoadFailed();
                        }
                    }
                });

    }

    @Override
    public void TeamMasterData(final TeamModelCallback callback) {
        OkHttpUtils
                .post()
                .url(Apis.FITMENT_TEAM)
                .addParams("token", "DAB088BA50C9405E84C789055D657614")
                .addParams("app_version", "android_com.aiyiqi.galaxy_1.1")
                .addParams("type", "1703")
                .addParams("haspermission", "yes")
                .addParams("pageNo", nextPage + "")
                .addParams("pageSize", "10")
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        Log.d("TeamModelImpl", "call:" + call);
                        callback.onLoadFailed();
                    }

                    @Override
                    public void onResponse(String response, int id) {


                        ResponseTeam responseTeam = JSON.parseObject(response, ResponseTeam.class);
                        if (responseTeam.getBaseOutput().getCode().equals("0")) {
                            callback.onLoadSuccess(responseTeam);
                            Log.d("TeamModelImpl", "nextPage1:" + nextPage);
                            nextPage++;
                            Log.d("TeamModelImpl", "response1" + response);
                        } else {
                            callback.onLoadFailed();
                        }
                    }
                });
    }

    @Override
    public void TeamSupervisionData(final TeamModelCallback callback) {
        OkHttpUtils
                .post()
                .url(Apis.FITMENT_TEAM)
                .addParams("token", "DAB088BA50C9405E84C789055D657614")
                .addParams("app_version", "android_com.aiyiqi.galaxy_1.1")
                .addParams("type", "1702")
                .addParams("haspermission", "yes")
                .addParams("pageNo", nextPage + "")
                .addParams("pageSize", "10")
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        Log.d("TeamModelImpl", "call:" + call);
                        callback.onLoadFailed();
                    }

                    @Override
                    public void onResponse(String response, int id) {


                        ResponseTeam responseTeam = JSON.parseObject(response, ResponseTeam.class);
                        if (responseTeam.getBaseOutput().getCode().equals("0")) {
                            callback.onLoadSuccess(responseTeam);
                            Log.d("TeamModelImpl", "nextPage2:" + nextPage);
                            nextPage++;
                            Log.d("TeamModelImpl", "response2" + response);
                        } else {
                            callback.onLoadFailed();
                        }
                    }
                });
    }

}
