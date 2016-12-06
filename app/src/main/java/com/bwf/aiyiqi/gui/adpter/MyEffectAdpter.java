package com.bwf.aiyiqi.gui.adpter;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.bwf.aiyiqi.R;
import com.bwf.aiyiqi.entity.ResponseEffectbeutiPicture;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Zoulin on 2016/12/5.
 */
public class MyEffectAdpter extends BaseAdapter {
    private LayoutInflater inflater;
    private List<ResponseEffectbeutiPicture.DataBean.ListBean> data;

    public MyEffectAdpter(Context context) {
        inflater = LayoutInflater.from(context);
        this.data = new ArrayList<>();
    }

    //添加数据集合 扩展数据
    public void addList(List<ResponseEffectbeutiPicture.DataBean.ListBean> datas) {
        this.data.addAll(datas);
        notifyDataSetChanged();//刷新数据
    }


    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.effect_picture_activity_gridview_adpter, null);
        }
        holder = new ViewHolder(convertView);
        holder.effectPictureActivityListAd.setImageURI(Uri.parse(data.get(position).getUrl()));
        holder.effectPictureActivityListGridText.setText(data.get(position).getCollected());
        holder.effectPictureActivityListViewText.setText(data.get(position).getIscollect());

        return convertView;
    }

    static class ViewHolder {
        @BindView(R.id.effect_picture_activity_list_ad)
        SimpleDraweeView effectPictureActivityListAd;
        @BindView(R.id.effect_picture_activity_list_grid_text)
        TextView effectPictureActivityListGridText;
        @BindView(R.id.effect_picture_activity_list_view_text)
        TextView effectPictureActivityListViewText;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
