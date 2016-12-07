package com.bwf.aiyiqi.mvp.model;

import com.bwf.aiyiqi.entity.ResponseBBS;
import com.bwf.aiyiqi.entity.ResponseBBSComments;
import com.bwf.aiyiqi.entity.ResponseBBSLikedList;

/**
 * Created by lmw on 2016/11/29.
 */

public interface BBSModel {
    void loadData(String bbsID,BBSCallback callback);
    void loadLikedData(String bbsID,BBSLikedCallback callback);
    void loadCommentsData(String bbsID,BBSCommentsCallback callback);
    interface BBSCallback{
        void onSuccess(ResponseBBS data);
        void onFailed();
    }
    interface BBSLikedCallback{
        void onSuccess(ResponseBBSLikedList data);
        void onFailed();
    }
    interface BBSCommentsCallback{
        void onSuccess(ResponseBBSComments data);
        void onFailed();
    }
}
