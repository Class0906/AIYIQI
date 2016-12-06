package com.bwf.aiyiqi.gui.fragment.designfragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.bwf.aiyiqi.R;
import com.bwf.aiyiqi.kitutils.Apis;
import com.bwflmw.framwork.BaseFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Zoulin on 2016/12/2.
 */

public class DesignRoomFirtment extends BaseFragment {
    @BindView(R.id.design_discharge_room_ragment_web)
    WebView designDischargeRoomRagmentWeb;
    @BindView(R.id.includ_decorate_contact)
    LinearLayout includDecorateContact;
    @BindView(R.id.includ_decorate_answer)
    LinearLayout includDecorateAnswer;

    @Override
    protected int getContentViewResId() {
        return R.layout.design_fragment_web;
    }

    @Override
    protected void initView() {
        designDischargeRoomRagmentWeb.loadUrl(Apis.DESIGN_ROOM_FIRST);
        WebSettings settings = designDischargeRoomRagmentWeb.getSettings();
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

    @OnClick({R.id.includ_decorate_contact, R.id.includ_decorate_answer})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.includ_decorate_contact:
                Toast.makeText(getContext(), "功能未开放，请等待", Toast.LENGTH_SHORT).show();
                break;
            case R.id.includ_decorate_answer:
                Toast.makeText(getContext(), "功能未开放，请等待", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
