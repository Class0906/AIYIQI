package com.bwf.aiyiqi.mvp.presenter.impl;

import com.bwf.aiyiqi.entity.ResponseNews;
import com.bwf.aiyiqi.entity.ResponseNewsComments;
import com.bwf.aiyiqi.mvp.model.NewsModel;
import com.bwf.aiyiqi.mvp.model.impl.NewsModelImpl;
import com.bwf.aiyiqi.mvp.presenter.NewsPresenter;
import com.bwf.aiyiqi.mvp.view.NewsView;

/**
 * Created by lmw on 2016/12/2.
 */

public class NewsPresenterImpl implements NewsPresenter {
    private NewsModel model;
    private NewsView view;

    public NewsPresenterImpl( NewsView view) {
        model = new NewsModelImpl();
        this.view = view;
    }

    @Override
    public void loadData(String newsId) {
        model.loadNewsData(newsId, new NewsModel.NewsCallback() {
            @Override
            public void onSuccess(ResponseNews data) {
                view.showNewsContent(data);
            }

            @Override
            public void onFailed() {
                view.showContentFailed();
            }
        });

        model.loadNewsCommentsData(newsId, new NewsModel.NewsCommentCallback() {
            @Override
            public void onSuccess(ResponseNewsComments data) {
                view.showNewsComments(data);
            }

            @Override
            public void onFailed() {
                view.showCommentsFailed();
            }
        });
    }
}
