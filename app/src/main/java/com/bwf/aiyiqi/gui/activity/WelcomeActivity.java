package com.bwf.aiyiqi.gui.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

import com.bwf.aiyiqi.R;
import com.bwf.aiyiqi.kitutils.Constant;
import com.bwflmw.framwork.BaseActivity;

/**
 * Created by Zoulin on 2016/11/23.
 * 欢迎界面
 */

public class WelcomeActivity  extends BaseActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SharedPreferences sp = getSharedPreferences(Constant.SP_USER_INFO, MODE_PRIVATE);
        boolean firstUse = sp.getBoolean(Constant.FIRSTUSE, true);
        int cancelCount = sp.getInt(Constant.CANCEL_COUNT,0);
        if(firstUse&&cancelCount<3){
            gotoGuide();
        }else {
            new Handler(){
                @Override
                public void handleMessage(Message msg) {
                    gotoMain();
                }
            }.sendEmptyMessageDelayed(0,3000);
        }

    }
    private void gotoGuide(){
        startActivity(new Intent(this,GuideActivity.class));
        finish();
    }

    private void gotoMain(){
        startActivity(new Intent(this,MainActivity.class));
        finish();
    }
    @Override
    protected int getContentViewResId() {
        return R.layout.activity_welcome;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {

    }
}
