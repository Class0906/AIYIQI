package com.bwflmw.framwork;

import android.content.pm.ActivityInfo;
import android.graphics.Rect;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;

/**
 * Created by lmw on 2016/11/23.
 */

public abstract class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //设置为竖屏
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(getContentViewResId());
        initView();
        initData();
    }

    /**
     * 设置状态栏透明
     */
    private void setTransparentTitlebar() {
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
    }

    /**
     * 设置全屏
     */
    protected void setFullScreen(){
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }

    /**
     * 不用强转的findViewById
     */
    protected  <T extends View> T findViewByIdNoCast(int id){
        return (T)findViewById(id);
    }

    /**
     * dip转像素
     */
    protected int dip2px(float dpValue){
        float scale = this.getResources().getDisplayMetrics().density;
        return (int)(dpValue*scale+0.5f);
    }
    /**
     * 像素转dip
     */
    protected int px2dip(float pxValue){
        float scale = this.getResources().getDisplayMetrics().density;
        return (int)(pxValue/scale+0.5f);
    }

    /**
     * 判断是否有网络
     */
    protected boolean isNetWork(){
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(CONNECTIVITY_SERVICE);
        return connectivityManager!=null
                &&connectivityManager.getActiveNetworkInfo()!=null
                &&connectivityManager.getActiveNetworkInfo().isAvailable();
    }
    /**
     * 获取状态栏高度
     */
    public int getStatusHeight() {
        final Rect rect = new Rect();
        getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
        int n = rect.top;
        if (n != 0) {
            return n;
        }
        try {
            final Class<?> forName = Class.forName("com.android.internal.R$dimen");
            n = getResources().getDimensionPixelSize(Integer.parseInt(forName.getField("status_bar_height").get(forName.newInstance()).toString()));
            return n;
        }catch (ClassNotFoundException ex) {
            ex.printStackTrace();
            return n;
        }catch (IllegalAccessException ex2) {
            ex2.printStackTrace();
            return n;
        }catch (InstantiationException ex3) {
            ex3.printStackTrace();
            return n;
        }catch (NumberFormatException ex4) {
            ex4.printStackTrace();
            return n;
        }catch (IllegalArgumentException ex5) {
            ex5.printStackTrace();
            return n;
        }catch (SecurityException ex6) {
            ex6.printStackTrace();
            return n;
        }catch (NoSuchFieldException ex7) {
            ex7.printStackTrace();
            return n;
        }
    }

    /**
     * 提供Activity要绑定的xml资源id
     * @return
     */
    protected abstract int getContentViewResId();

    /**
     * 初始化控件
     */
    protected abstract void initView();
    /**
     * 初始化数据
     */
    protected abstract void initData();

}
