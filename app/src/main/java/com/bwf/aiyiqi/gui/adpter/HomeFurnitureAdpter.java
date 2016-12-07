package com.bwf.aiyiqi.gui.adpter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.bwf.aiyiqi.R;
import com.bwf.aiyiqi.entity.ResponseHomeFurne;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Zoulin on 2016/12/6.
 */

public class HomeFurnitureAdpter extends BaseAdapter {

    private List<ResponseHomeFurne.DataBean.ChildrenBean> datas;
    private LayoutInflater inflater;
    private Context context;
    public HomeFurnitureAdpter(Context context) {
        this.context = context;
        this.inflater = LayoutInflater.from(context);
        datas = new ArrayList<>();
    }

    /**
     * 添加数据
     *
     * @return
     */
    public void setDatas(List<ResponseHomeFurne.DataBean.ChildrenBean> datas) {
        this.datas.clear();
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
        ViewHolder holder=null;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.list_home_first_adpter, null, false);
        }
        holder=new ViewHolder(convertView);
        holder.listHomeFirstAdpterText.setText(datas.get(position).getTitle());
        return convertView;
    }

    static class ViewHolder {
        @BindView(R.id.list_home_first_adpter_text)
        TextView listHomeFirstAdpterText;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
