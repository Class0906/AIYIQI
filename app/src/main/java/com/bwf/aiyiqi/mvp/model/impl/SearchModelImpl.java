package com.bwf.aiyiqi.mvp.model.impl;

import com.alibaba.fastjson.JSON;
import com.bwf.aiyiqi.entity.ResponseSearch;
import com.bwf.aiyiqi.kitutils.Apis;
import com.bwf.aiyiqi.mvp.model.SearchModel;
import com.bwflmw.framwork.utils.UrlHandler;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import okhttp3.Call;

/**
 * Created by lmw on 2016/12/7.
 */

public class SearchModelImpl implements SearchModel {
    private int nextPage=1;
    private String lastKey;
    @Override
    public void loadSearchData(final String key, final SearchCallback callback) {
        if (lastKey!=null&&!key.equals(lastKey))
            nextPage=1;
        OkHttpUtils.get()
                .url(UrlHandler.handleUrl(Apis.SEARCH,nextPage,key))
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        callback.onFailed();
                    }

                    @Override
                    public void onResponse(String response, int id) {
                        ResponseSearch data = JSON.parseObject(response, ResponseSearch.class);
                        if (data.getError().equals("0")){
                            nextPage++;
                            lastKey = key;
                            callback.onSuccess(data);
                        }else
                            callback.onFailed();
                    }
                });
    }
}
