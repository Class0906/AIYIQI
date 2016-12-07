package com.bwf.aiyiqi.mvp.model;

import com.bwf.aiyiqi.entity.ResponseNews;
import com.bwf.aiyiqi.entity.ResponseNewsComments;

/**
 * Created by lmw on 2016/12/1.
 */

public interface NewsModel {
    void loadNewsData(String newsId,NewsCallback callback);
    void loadNewsCommentsData(String newsId,NewsCommentCallback callback);
    interface NewsCallback{
        void onSuccess(ResponseNews data);
        void onFailed();
    }
    interface NewsCommentCallback{
        void onSuccess(ResponseNewsComments data);
        void onFailed();
    }
}
