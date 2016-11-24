package com.bwf.aiyiqi.gui.activity;

import android.content.Intent;
import android.os.Bundle;

import com.bwf.aiyiqi.R;
import com.bwflmw.baselibrary.BaseActivity;

/**
 * Created by Zoulin on 2016/11/23.
 * 欢迎界面
 */

public class WelcomeActivity  extends BaseActivity{
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
           gotoMain();
            }
        }).start();
    }
    public void gotoMain(){
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
