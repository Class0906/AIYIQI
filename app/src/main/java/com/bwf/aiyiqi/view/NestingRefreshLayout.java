package com.bwf.aiyiqi.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;

import com.cjj.MaterialRefreshLayout;

/**
 * Created by lmw on 2016/11/27.
 */

public class NestingRefreshLayout extends MaterialRefreshLayout{
    private boolean isCanPull = true;
    public NestingRefreshLayout(Context context) {
        super(context);
    }

    public NestingRefreshLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public NestingRefreshLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        if(!isCanPull){
            return false;
        }
        return super.onInterceptTouchEvent(ev);
    }

    public void setisCanPull(boolean isCanPull){
        this.isCanPull = isCanPull;
    }
}
