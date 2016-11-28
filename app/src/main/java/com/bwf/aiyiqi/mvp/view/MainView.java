package com.bwf.aiyiqi.mvp.view;

import com.bwf.aiyiqi.entity.ResponseHomeAD;
import com.bwf.aiyiqi.entity.ResponseHomeBBS;

/**
 * Created by Zoulin on 2016/11/23.
 */

public interface MainView {
    void showMainViewPager(ResponseHomeAD data);
    void showMainRecyclerView(ResponseHomeBBS data);
    void showViewpagerFailed();
    void showRecyclerFailed();
}
