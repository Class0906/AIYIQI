package com.bwf.aiyiqi.mvp.view;

import com.bwf.aiyiqi.entity.ResponseBBS;
import com.bwf.aiyiqi.entity.ResponseBBSComments;
import com.bwf.aiyiqi.entity.ResponseBBSLikedList;

/**
 * Created by lmw on 2016/11/29.
 */

public interface BBSView {
    void showBBSDetail(ResponseBBS data);
    void showFailed();

    void showLickedList(ResponseBBSLikedList data);

    void showComments(ResponseBBSComments data);
}
