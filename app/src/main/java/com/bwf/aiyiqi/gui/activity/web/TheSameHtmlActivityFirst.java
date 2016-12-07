package com.bwf.aiyiqi.gui.activity.web;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bwf.aiyiqi.R;
import com.bwflmw.framwork.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Zoulin on 2016/11/30.
 */

public class TheSameHtmlActivityFirst extends BaseActivity {


    @BindView(R.id.main_titile_fitment_img)
    ImageView mainTitileFitmentImg;
    @BindView(R.id.icluce_text_activity)
    TextView icluceTextActivity;
    @BindView(R.id.trame_sub_webview_fist)
    WebView trameSubWebviewFist;
    @BindView(R.id.includ_decorate_contact)
    LinearLayout includDecorateContact;
    @BindView(R.id.includ_decorate_answer)
    LinearLayout includDecorateAnswer;

    @Override
    protected int getContentViewResId() {
        return R.layout.trame_sub_html_activity;
    }

    @Override
    protected void initView() {
        ButterKnife.bind(this);
        String texturl="http://m.17house.com/tuan/2704.html";
        trameSubWebviewFist.loadUrl(texturl);
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
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
        icluceTextActivity.setText("团购会");
    }

    @OnClick({R.id.main_titile_fitment_img, R.id.includ_decorate_contact, R.id.includ_decorate_answer})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.main_titile_fitment_img:
                startActivity(new Intent(this, TheSameActivity.class));
                finish();
                break;
            case R.id.includ_decorate_contact:
                Toast.makeText(this, "功能未开放，敬请期待", Toast.LENGTH_SHORT).show();
                break;
            case R.id.includ_decorate_answer:
                Toast.makeText(this, "功能未开放，敬请期待", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
