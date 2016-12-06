package com.bwf.aiyiqi.gui.fragment.BudgetQuoteFragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;

import com.bwf.aiyiqi.R;
import com.bwf.aiyiqi.kitutils.Apis;
import com.bwflmw.framwork.BaseFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Zoulin on 2016/12/6.
 */

public class BudgetQuotefistFirtment extends BaseFragment {
    @BindView(R.id.trame_sub_webview_fist)
    WebView trameSubWebviewFist;

    @Override
    protected int getContentViewResId() {
        return R.layout.trame_budget_html_activity;
    }

    @Override
    protected void initView() {
        trameSubWebviewFist.loadUrl(Apis.BUDGET_SPECOAL);
        trameSubWebviewFist.setScrollBarStyle(View.SCROLLBARS_OUTSIDE_OVERLAY);
        trameSubWebviewFist.setHorizontalScrollBarEnabled(true);
        WebSettings settings = trameSubWebviewFist.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setSupportZoom(true);
        settings.setAppCacheEnabled(true);// 开启缓存
        settings.setAppCacheMaxSize(8 * 1024 * 1024);// 设置最大缓存为8M
        settings.setBuiltInZoomControls(true);
        settings.setSupportMultipleWindows(true);//支持多窗口
    }

    @Override
    protected void initData() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.bind(this, rootView);
        return rootView;
    }
}
