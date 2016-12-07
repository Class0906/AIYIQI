package com.bwf.aiyiqi.gui.activity.web;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bwf.aiyiqi.R;
import com.bwflmw.framwork.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Zoulin on 2016/12/1.
 */

public class ThrSameHtmlSendActiity extends BaseActivity {

    @BindView(R.id.main_titile_fitment_img)
    ImageView mainTitileFitmentImg;
    @BindView(R.id.icluce_text_activity)
    TextView icluceTextActivity;
    @BindView(R.id.trame_sub_webview_send)
    WebView trameSubWebviewSend;
    @BindView(R.id.trame_sub_html_send_ed)
    EditText trameSubHtmlSendEd;
    @BindView(R.id.ic_taochan_like_trame_html)
    ImageView icTaochanLikeTrameHtml;
    @BindView(R.id.article_uncollect_trame_html)
    ImageView articleUncollectTrameHtml;
    @BindView(R.id.ic_share_trame_html)
    ImageView icShareTrameHtml;

    @Override
    protected int getContentViewResId() {
        return R.layout.trame_sub_html_send_activity;
    }

    @Override
    protected void initView() {
        ButterKnife.bind(this);
        String texturl = getIntent().getStringExtra("getUrls");
        Log.d("ThrSameHtmlSendActiity", "texturl"+texturl);
        trameSubWebviewSend.loadUrl(texturl);
        trameSubWebviewSend.setScrollBarStyle(View.SCROLLBARS_OUTSIDE_OVERLAY);
        trameSubWebviewSend.setHorizontalScrollBarEnabled(true);
        WebSettings settings = trameSubWebviewSend.getSettings();
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
        icluceTextActivity.setText("活动详情");
    }

    @OnClick({R.id.main_titile_fitment_img, R.id.ic_taochan_like_trame_html, R.id.article_uncollect_trame_html, R.id.ic_share_trame_html})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.main_titile_fitment_img:
                gotoFit();
                break;
            case R.id.ic_taochan_like_trame_html:
                Toast.makeText(this, "功能未开放，敬请期待", Toast.LENGTH_SHORT).show();
                break;
            case R.id.article_uncollect_trame_html:
                Toast.makeText(this, "功能未开放，敬请期待", Toast.LENGTH_SHORT).show();
                break;
            case R.id.ic_share_trame_html:
                Toast.makeText(this, "功能未开放，敬请期待", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    public void gotoFit() {
        startActivity(new Intent(this, TheSameActivity.class));
        finish();
    }
}
