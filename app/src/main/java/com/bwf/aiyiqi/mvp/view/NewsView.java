package com.bwf.aiyiqi.mvp.view;

import com.bwf.aiyiqi.entity.ResponseNews;
import com.bwf.aiyiqi.entity.ResponseNewsComments;

/**
 * Created by lmw on 2016/12/2.
 */

public interface NewsView {
    void showNewsContent(ResponseNews data);
    void showNewsComments(ResponseNewsComments data);
    void showContentFailed();
    void showCommentsFailed();
}
