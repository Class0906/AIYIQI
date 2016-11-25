package com.bwf.aiyiqi.gui.activity;


import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import com.bwf.aiyiqi.R;
import com.bwflmw.framwork.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * Created by Zoulin on 2016/11/24.
 * 搜索界面
 */

public class ActivitySeek extends BaseActivity {


    @BindView(R.id.Z_ed_seek_text)
    EditText ZEdSeekText;
    @BindView(R.id.seek_titile_text)
    TextView seekTitileText;

    @Override
    protected int getContentViewResId() {
        return R.layout.activity_mian_seek;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick(R.id.seek_titile_text)
    public void onClick() {
        gotoMain();
    }
    public void gotoMain(){
        startActivity(new Intent(this,MainActivity.class));
        finish();
    }
}
