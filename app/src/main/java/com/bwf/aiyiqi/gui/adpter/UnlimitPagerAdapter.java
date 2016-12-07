package com.bwf.aiyiqi.gui.adpter;

import android.content.Context;
import android.net.Uri;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bwf.aiyiqi.R;
import com.bwf.aiyiqi.entity.ResponseHomeAD;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lmw on 2016/11/24.
 */

public class UnlimitPagerAdapter extends PagerAdapter{
    private List<ResponseHomeAD.DataBean> datas;
    private List<View> views;
    public UnlimitPagerAdapter(Context context,List<ResponseHomeAD.DataBean> datas) {
        this.datas = datas;
        views = new ArrayList<>();
        LayoutInflater inflater = LayoutInflater.from(context);
        for(int i=0; i<datas.size();i++){
            View view = inflater.inflate(R.layout.viewpager_main_page,null);
            views.add(view);
        }
    }

    @Override
    public int getCount() {
        return views.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view = views.get(position%datas.size());
        SimpleDraweeView image = (SimpleDraweeView) view.findViewById(R.id.image_viewpager_main_page);
        image.setImageURI(Uri.parse(datas.get(position%datas.size()).getImagesrc2()));
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(views.get(position%datas.size()));
    }
}
