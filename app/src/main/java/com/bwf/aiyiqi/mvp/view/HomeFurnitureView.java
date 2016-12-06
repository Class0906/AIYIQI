package com.bwf.aiyiqi.mvp.view;

import com.bwf.aiyiqi.entity.ResponseHomeFurne;

/**
 * Created by Zoulin on 2016/12/6.
 */

public interface HomeFurnitureView {
    void showMainViewPager(ResponseHomeFurne homeFurne);
    void showFailed();
}
