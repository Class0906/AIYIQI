package com.bwf.aiyiqi.gui.adpter;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.bwf.aiyiqi.R;
import com.bwf.aiyiqi.entity.ResponseFitmentDirectSeeding;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Zoulin on 2016/11/28.
 * 装修直播
 */

public class FitmentDiredtSeedingAdpter extends BaseAdapter {
    private List<ResponseFitmentDirectSeeding.DataBean> datas;
    private LayoutInflater mInflater;

    public FitmentDiredtSeedingAdpter(Context context, List<ResponseFitmentDirectSeeding.DataBean> datas) {
        this.datas = datas;
        this.mInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return datas.size();
    }

    @Override
    public Object getItem(int position) {
        return datas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder=null;
        if (convertView==null){
            convertView=mInflater.inflate(R.layout.sub_fitmentdirectseeding,null);
            holder=new ViewHolder(convertView);
            holder.FitmentDirectSeedingImageListview.setImageURI(Uri.parse(datas.get(position).getImageUrl()));
            holder.FitmentDirectSeedingText1Listview.setText(datas.get(position).getOrderHouse().getCommunity());
            holder.FitmentDirectSeedingText2Listview.setText(datas.get(position).getOrderHouse().getLayout());
        }
        return convertView;
    }

    static class ViewHolder {
        @BindView(R.id.FitmentDirectSeeding_image_listview)
        SimpleDraweeView FitmentDirectSeedingImageListview;
        @BindView(R.id.FitmentDirectSeeding_Text1_listview)
        TextView FitmentDirectSeedingText1Listview;
        @BindView(R.id.FitmentDirectSeeding_Text2_listview)
        TextView FitmentDirectSeedingText2Listview;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
