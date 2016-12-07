package com.bwf.aiyiqi.mvp.view;

import com.bwf.aiyiqi.entity.ResponseFitmentAD;
import com.bwf.aiyiqi.entity.ResponseFitmentDirectSeeding;

import java.util.List;

/**
 * Created by Zoulin on 2016/11/25.
 */

public interface FitmentView {
    void showMainViewPager(ResponseFitmentAD data);
    void showFitmentViewPager(List<ResponseFitmentDirectSeeding.DataBean> data);
    void showFailed();
}
