package com.bwf.aiyiqi.gui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bwf.aiyiqi.entity.ResponseHomeBBS;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lmw on 2016/11/24.
 */
public class MainRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<ResponseHomeBBS.DataBean> data;
    private LayoutInflater inflater;
    private int TYPE_HEADER = 0;
    private int TYPE_FOOTER = 1;
    private int TYPE_ARTICLE = 2;
    private int TYPE_BBS = 3;


    public MainRecyclerViewAdapter(Context context) {
        data = new ArrayList<>();
        inflater = LayoutInflater.from(context);
    }

    public void addData(){
        data.addAll(data);
        notifyDataSetChanged();
    }

    @Override
    public int getItemViewType(int position) {
        if(position == 0)
            return TYPE_HEADER;
        if (position == getItemCount()-1)
            return TYPE_FOOTER;
        if (data.get(position).getType()==1){
            return TYPE_ARTICLE;
        }else
            return TYPE_BBS;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return data.size()+getHeaderCount()+getFooterCount();
    }

    private int getHeaderCount() {
        return 1;
    }

    private int getFooterCount() {
        return 1;
    }

    private class HeaderViewHolder extends RecyclerView.ViewHolder{

        public HeaderViewHolder(View itemView) {
            super(itemView);
        }
    }
}
