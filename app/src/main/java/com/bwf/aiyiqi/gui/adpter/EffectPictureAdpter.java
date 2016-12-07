package com.bwf.aiyiqi.gui.adpter;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.bwf.aiyiqi.R;
import com.bwf.aiyiqi.entity.ResponseEffectPicture;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Zoulin on 2016/12/2.
 */

public class EffectPictureAdpter extends BaseAdapter {

    private LayoutInflater inflater;
    private List<ResponseEffectPicture.DataBean.ListBean> databean;

    public EffectPictureAdpter(Context context) {
        inflater = LayoutInflater.from(context);
        this.databean = new ArrayList<>();
    }

    //添加可以扩编的LIST 并且刷新局部数据
    public void addDatas(List<ResponseEffectPicture.DataBean.ListBean> datas) {
        databean.addAll(datas);
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return databean.size();
    }

    @Override
    public Object getItem(int position) {
        return databean.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.effect_picture_activity_listview_adpter, null);
        }
        holder = new ViewHolder(convertView);
        holder.effectPictureSimpleiagme.setImageURI(Uri.parse(databean.get(position).getUrl()));
        holder.effectPictureTushang.setText(databean.get(position).getTitle());
        holder.effectPictureTextview.setText(databean.get(position).getCollected());
        holder.effectPictureActivityListText.setText(databean.get(position).getDesc());
        return convertView;
    }

    class ViewHolder {
        @BindView(R.id.effect_picture_simpleiagme)
        SimpleDraweeView effectPictureSimpleiagme;
        @BindView(R.id.effect_picture_tushang)
        TextView effectPictureTushang;
        @BindView(R.id.effect_picture_textview)
        TextView effectPictureTextview;
        @BindView(R.id.effect_picture_activity_list_text)
        TextView effectPictureActivityListText;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
