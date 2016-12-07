package com.bwf.aiyiqi.view;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bwf.aiyiqi.R;

/**
 * Created by lmw on 2016/11/25.
 */

public class ViewPagerIndicator {
    private LinearLayout container;
    private int count;
    private LayoutInflater inflater;

    public ViewPagerIndicator(Context context, LinearLayout container, int count) {
        inflater = LayoutInflater.from(context);
        this.container = container;
        this.count = count;
    }

    /**
     * 必须在viewpager获取数据之后再设置关联
     *
     * @param viewPager
     */
    public void setupWithViewPager(ViewPager viewPager) {
        container.removeAllViews();
        for (int i = 0; i < count; i++) {
            View view = inflater.inflate(R.layout.indicator_viewpager_dot, container, false);
            ImageView iv = (ImageView) view.findViewById(R.id.image_indicator);
            if (i == 0) {
                iv.setImageResource(R.mipmap.indicator);
            } else
                iv.setImageResource(R.mipmap.indicator_nor);
            container.addView(view);
        }
        viewPager.addOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                for (int i = 0; i < count; i++) {
                    ImageView iv = (ImageView) container.getChildAt(i).findViewById(R.id.image_indicator);
                    if (i == position % count) {
                        iv.setImageResource(R.mipmap.indicator);
                    } else
                        iv.setImageResource(R.mipmap.indicator_nor);
                }
            }
        });
    }


}
