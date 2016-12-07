package com.bwf.aiyiqi.mvp.view;

import com.bwf.aiyiqi.entity.ResponseSearch;

/**
 * Created by lmw on 2016/12/7.
 */
public interface SearchView {
    void showSearchData(ResponseSearch data);
    void showSearchFailed();
}
