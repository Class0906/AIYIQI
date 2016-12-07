package com.bwf.aiyiqi.view;

import android.util.Log;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;

/**
 * Created by Zoulin on 2016/11/30.
 * 滚动至列表底部，读取下一页数据
 */

public class AutoLoadListener implements OnScrollListener {

    //构建一个回调函数
    public interface AutoLoadCallBack {
        void excute();
    }

    private int getLastVisiblePosition = 0, lastVisiblePositionY = 0;
    private AutoLoadCallBack mCallback;

    public AutoLoadListener(AutoLoadCallBack mCallback) {
        this.mCallback = mCallback;
    }

    @Override
    public void onScrollStateChanged(AbsListView view, int scrollState) {
        if (scrollState == OnScrollListener.SCROLL_STATE_IDLE) {
            //滚动到底部
            if (view.getLastVisiblePosition() == (view.getCount() - 1)) {
                View view1 = view.getChildAt(view.getChildCount() - 1);
                int[] location = new int[2];
                view1.getLocationOnScreen(location);//获取整个屏幕内的绝对坐标
                int y = location[1];
                Log.e("x" + location[0], "y" + location[1]);


                if (view.getLastVisiblePosition() != getLastVisiblePosition && lastVisiblePositionY != y) {
                    //第一次拖动到底部
                    Log.d("AutoLoadListener", "已经拖动至底部，再次拖动即可翻页");
                    getLastVisiblePosition = view.getLastVisiblePosition();
                    lastVisiblePositionY = y;
                    return;
                } else if (view.getLastVisiblePosition() == getLastVisiblePosition && lastVisiblePositionY == y) {
                    //第二次拖动到底部
                    mCallback.excute();
                }
            }
            //未滚动到底部，第二次拖至底部都初始化
            getLastVisiblePosition=0;
            lastVisiblePositionY=0;
        }
    }

    @Override
    public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {

    }
}
