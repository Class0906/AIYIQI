package com.bwf.aiyiqi.view;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.Scroller;

import java.lang.reflect.Field;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by lmw on 2016/11/24.
 */

public class FitmentAutoScorllViewPager extends ViewPager{
    private final int DURATION = 3000;
    public FitmentAutoScorllViewPager(Context context) {
        super(context);
        resetDuration(DURATION);
    }

    public FitmentAutoScorllViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
        resetDuration(DURATION);
    }

    private void resetDuration(int duration){
        try {
            Field mScroller = ViewPager.class.getDeclaredField("mScroller");
            mScroller.setAccessible(true);
            Scroller scroller = new Scroller(getContext()){
                @Override
                public void startScroll(int startX, int startY, int dx, int dy, int duration) {
                    super.startScroll(startX, startY, dx, dy, duration);
                }
            };
            mScroller.set(this,scroller);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void setAdapter(PagerAdapter adapter) {
        super.setAdapter(adapter);
        startAutoScroll();
    }

    private Timer timer = new Timer();
    private TimerTask task;
    private void startAutoScroll(){
        if(task==null){
            task = new TimerTask() {
                @Override
                public void run() {
                    scrollToNext();
                }
            };
            timer.schedule(task,3000,3000);
        }
    }

    private void stopAutoScoll(){
        if(task!=null){
            task.cancel();
            task=null;
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        switch (ev.getAction()){
            case MotionEvent.ACTION_DOWN:
                stopAutoScoll();
                break;
            case MotionEvent.ACTION_CANCEL:
            case MotionEvent.ACTION_UP:
                startAutoScroll();
                break;
        }
        return super.onTouchEvent(ev);
    }
    private void scrollToNext() {
        post(new Runnable() {
            @Override
            public void run() {
                setCurrentItem(getCurrentItem()+1);
            }
        });
    }


}
