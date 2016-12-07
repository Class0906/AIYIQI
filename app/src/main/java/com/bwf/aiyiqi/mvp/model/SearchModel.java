package com.bwf.aiyiqi.mvp.model;


import com.bwf.aiyiqi.entity.ResponseSearch;

/**
 * Created by lmw on 2016/12/6.
 */

public interface SearchModel {
    void loadSearchData(String key,SearchCallback callback);
    interface SearchCallback{
        void onSuccess(ResponseSearch data);
        void onFailed();
    }
}
