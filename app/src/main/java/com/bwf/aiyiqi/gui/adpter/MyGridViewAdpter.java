package com.bwf.aiyiqi.gui.adpter;

import android.content.Context;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RatingBar;
import android.widget.TextView;

import com.bwf.aiyiqi.R;
import com.bwf.aiyiqi.entity.ResponseTeam;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Zoulin on 2016/11/29.
 */

public class MyGridViewAdpter extends BaseAdapter {
    private LayoutInflater inflater;
    private List<ResponseTeam.DataBean> datas;

    public MyGridViewAdpter(Context context) {
        inflater = LayoutInflater.from(context);
        this.datas = new ArrayList<>();
    }

    public void addDatas(List<ResponseTeam.DataBean> datas){
        this.datas.addAll(datas);
        notifyDataSetChanged();
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
        ViewHolder holder = null;
        Log.d("MyGridViewAdpter", "111");
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.blankfragment_gridview, null);
        }
            holder = new ViewHolder(convertView);
            holder.imageViewpagerMainGridview.setImageURI(Uri.parse(datas.get(position).getAvatar()));
            holder.teamGridviewText.setText(datas.get(position).getVendorName());
            holder.teamGridviewTextCaseCeshi.setText(datas.get(position).getCaseNumber());
            holder.ratingScore.setNumStars(datas.get(position).getRating());

        return convertView;

    }


    static class ViewHolder {
        @BindView(R.id.image_viewpager_main_gridview)
        SimpleDraweeView imageViewpagerMainGridview;
        @BindView(R.id.team_gridview_text)
        TextView teamGridviewText;
        @BindView(R.id.team_gridview_text_case_ceshi)
        TextView teamGridviewTextCaseCeshi;
        @BindView(R.id.rating_score)
        RatingBar ratingScore;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
