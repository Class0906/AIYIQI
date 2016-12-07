package com.bwf.aiyiqi.mvp.presenter.impl;

import com.bwf.aiyiqi.entity.ResponseBBS;
import com.bwf.aiyiqi.entity.ResponseBBSComments;
import com.bwf.aiyiqi.entity.ResponseBBSLikedList;
import com.bwf.aiyiqi.mvp.model.BBSModel;
import com.bwf.aiyiqi.mvp.model.impl.BBSModelImpl;
import com.bwf.aiyiqi.mvp.presenter.BBSPresenter;
import com.bwf.aiyiqi.mvp.view.BBSView;

/**
 * Created by lmw on 2016/11/29.
 */

public class BBSPresenterImpl implements BBSPresenter {
    private BBSModel model;
    private BBSView view;
    public BBSPresenterImpl(BBSView view) {
        this.view = view;
        model = new BBSModelImpl();
    }

    @Override
    public void loadBBSData(String bbsId) {
        model.loadData(bbsId, new BBSModel.BBSCallback() {
            @Override
            public void onSuccess(ResponseBBS data) {
                view.showBBSDetail(data);
            }

            @Override
            public void onFailed() {
                view.showFailed();
            }
        });
        model.loadLikedData(bbsId, new BBSModel.BBSLikedCallback() {
            @Override
            public void onSuccess(ResponseBBSLikedList data) {
                view.showLickedList(data);
            }

            @Override
            public void onFailed() {

            }
        });
        model.loadCommentsData(bbsId, new BBSModel.BBSCommentsCallback() {
            @Override
            public void onSuccess(ResponseBBSComments data) {
                view.showComments(data);
            }

            @Override
            public void onFailed() {

            }
        });
    }

    @Override
    public void loadMoreComments(String bbsId) {
        model.loadCommentsData(bbsId, new BBSModel.BBSCommentsCallback() {
            @Override
            public void onSuccess(ResponseBBSComments data) {
                view.showComments(data);
            }

            @Override
            public void onFailed() {

            }
        });
    }
}
