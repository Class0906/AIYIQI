package com.bwf.aiyiqi.mvp.presenter.impl;

import com.bwf.aiyiqi.entity.ResponseSearch;
import com.bwf.aiyiqi.mvp.model.SearchModel;
import com.bwf.aiyiqi.mvp.model.impl.SearchModelImpl;
import com.bwf.aiyiqi.mvp.presenter.SearchPresenter;
import com.bwf.aiyiqi.mvp.view.SearchView;

/**
 * Created by lmw on 2016/12/7.
 */

public class SearchPresenterImpl implements SearchPresenter {
    private SearchModel model;
    private SearchView view;

    public SearchPresenterImpl(SearchView view) {
        this.view = view;
        model = new SearchModelImpl();
    }

    @Override
    public void loadSearchData(String key) {
        model.loadSearchData(key, new SearchModel.SearchCallback() {
            @Override
            public void onSuccess(ResponseSearch data) {
                view.showSearchData(data);
            }

            @Override
            public void onFailed() {
                view.showSearchFailed();
            }
        });
    }
}
