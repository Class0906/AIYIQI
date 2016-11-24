package com.bwf.aiyiqi.mvp.view;

import com.bwf.aiyiqi.entity.ResponseHomeAD;

/**
 * Created by Zoulin on 2016/11/23.
 */

public interface MainView {
    void showMainViewPager(ResponseHomeAD data);

    void showFailed();
}
