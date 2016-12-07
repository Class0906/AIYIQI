package com.bwf.aiyiqi.gui.adpter;

import android.content.Context;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.bwf.aiyiqi.R;
import com.bwf.aiyiqi.entity.ResponseTheSame;
import com.facebook.drawee.view.SimpleDraweeView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Zoulin on 2016/11/30.
 * 同城活动
 */

public class TheSameAdpter extends BaseAdapter {
    private LayoutInflater inflater;
    private List<ResponseTheSame.DataBean.ForumlistBean> dataBeen;

    public TheSameAdpter(Context context, List<ResponseTheSame.DataBean.ForumlistBean> dataBeen) {
        this.dataBeen = dataBeen;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return dataBeen.size();
    }

    @Override
    public Object getItem(int position) {
        return dataBeen.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.the_same_recyclerview_view, null);
        }
        holder = new ViewHolder(convertView);
        holder.activityTheSameRecyclerviewSimple.setImageURI(Uri.parse(dataBeen.get(position).getAttachments()));
        holder.activityTheSameRecyclerviewText.setText(getTestData(dataBeen.get(position).getLastpost()));
        return convertView;
    }

    static class ViewHolder {
        @BindView(R.id.activity_the_same_recyclerview_simple)
        SimpleDraweeView activityTheSameRecyclerviewSimple;
        @BindView(R.id.activity_the_same_recyclerview_text)
        TextView activityTheSameRecyclerviewText;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
    /**
     *    判断拿到的时间
     */
    public  static  String getTestData(String datatime){
        String str=null;
        if (datatime.equals("")){
            return  null;
        }else{
             str=DataTime(StrToDate(datatime));
        }
        return  str;
    }

    /**
     * 日期转换成字符串
     * @param datatime
     * @return str
     */
    public static String DataTime(Date datatime){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
        Log.d("TheSameAdpter", "datatime:" + datatime);
        String str=sdf.format(datatime);
        return str;
    }
    /**
     * 字符串转换成日期
     * @param str
     * @return date
     */
    public static Date StrToDate(String str) {

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = format.parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }
}
