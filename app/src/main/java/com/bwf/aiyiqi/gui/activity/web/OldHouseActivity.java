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
import com.bwf.aiyiqi.gui.activity.ActivityFitment;
import com.bwf.aiyiqi.kitutils.Apis;
import com.bwflmw.framwork.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Zoulin on 2016/11/28.
 */

public class OldHouseActivity extends BaseActivity implements View.OnClickListener {

    @BindView(R.id.main_titile_fitment_img)
    ImageView mainTitileFitmentImg;
    @BindView(R.id.icluce_text_activity)
    TextView icluceTextActivity;
    @BindView(R.id.newhouse_webview)
    WebView newhouseWebview;
    @BindView(R.id.includ_decorate_contact)
    LinearLayout includDecorateContact;
    @BindView(R.id.includ_decorate_answer)
    LinearLayout includDecorateAnswer;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        icluceTextActivity.setText("老房装修");

    }

    @Override
    protected int getContentViewResId() {
        return R.layout.avtivity_newhouse_ready;
    }

    /**
     * 初始化控件
     */
    @Override
    protected void initView() {
        ButterKnife.bind(this);
        mainTitileFitmentImg.setOnClickListener(this);
        includDecorateContact.setOnClickListener(this);
        includDecorateAnswer.setOnClickListener(this);
        newhouseWebview.loadUrl(Apis.FITMENT_OLDHOUSE);
        newhouseWebview.setScrollBarStyle(View.SCROLLBARS_OUTSIDE_OVERLAY);
        newhouseWebview.setHorizontalScrollBarEnabled(true);
        WebSettings settings = newhouseWebview.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setSupportZoom(true);
        settings.setAppCacheEnabled(true);// 开启缓存
        settings.setAppCacheMaxSize(8 * 1024 * 1024);// 设置最大缓存为8M
        settings.setBuiltInZoomControls(true);
        settings.setSupportMultipleWindows(true);//支持多窗口

    }


    /**
     * 初始化数据
     */
    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.main_titile_fitment_img:
                gotoFit();
                break;
            case R.id.includ_decorate_answer:
                Toast.makeText(this, "功能为开放，正在建设中！", Toast.LENGTH_SHORT).show();
                break;
            case R.id.includ_decorate_contact:
                Toast.makeText(this, "功能为开放，正在建设中！", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    public void gotoFit() {
        startActivity(new Intent(this, ActivityFitment.class));
        finish();
    }
}
