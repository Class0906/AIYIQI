package com.bwf.aiyiqi.gui.adpter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bwf.aiyiqi.R;
import com.bwf.aiyiqi.entity.ResponseHomeBBS;
import com.bwf.aiyiqi.gui.activity.ActivityFitment;
import com.bwf.aiyiqi.gui.activity.BudgetActivity;
import com.bwf.aiyiqi.gui.activity.web.DesignDischargeRoomActivity;
import com.bwf.aiyiqi.gui.activity.web.EffectPictureActivity;
import com.bwf.aiyiqi.gui.activity.web.HomeFurnitureActivity;
import com.bwf.aiyiqi.gui.activity.web.TheSameActivity;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

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
    private Context contenx;


    public MainRecyclerViewAdapter(Context context) {
        data = new ArrayList<>();
        inflater = LayoutInflater.from(context);
        this.contenx = context;
    }

    public void addData() {
        data.addAll(data);
        notifyDataSetChanged();
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0)
            return TYPE_HEADER;
        if (position == getItemCount() - 1)
            return TYPE_FOOTER;
        if (data.get(position).getType() == 1) {
            return TYPE_ARTICLE;
        } else
            return TYPE_BBS;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == TYPE_HEADER) {
            View headerView = inflater.inflate(R.layout.item_header_main_recycler, parent, false);
            //点击跳转到装修公司页面
            LinearLayout ll_activiy = (LinearLayout) headerView.findViewById(R.id.layout_main_header_company);
            ll_activiy.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    contenx.startActivity(new Intent(contenx, ActivityFitment.class));
                }
            });
            //跳转同城活动
            LinearLayout ll_activity1 = (LinearLayout) headerView.findViewById(R.id.layout_main_header_activity);
            ll_activity1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    contenx.startActivity(new Intent(contenx, TheSameActivity.class));
                }
            });
            //跳转到设计量房
            LinearLayout ll_activity2 = (LinearLayout) headerView.findViewById(R.id.layout_main_header_design);
            ll_activity2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    contenx.startActivity(new Intent(contenx, DesignDischargeRoomActivity.class));
                }
            });
            //跳转到效果图界面
            LinearLayout ll_activity3 = (LinearLayout) headerView.findViewById(R.id.layout_main_header_picture);
            ll_activity3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    contenx.startActivity(new Intent(contenx, EffectPictureActivity.class));
                }
            });
            //跳转到建材家居
            LinearLayout ll_activity4 = (LinearLayout) headerView.findViewById(R.id.layout_main_header_category);
            ll_activity4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    contenx.startActivity(new Intent(contenx, HomeFurnitureActivity.class));
                }
            });
            //跳转到装修预算
            LinearLayout ll_activity5 = (LinearLayout) headerView.findViewById(R.id.layout_main_header_money);
            ll_activity5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    contenx.startActivity(new Intent(contenx, BudgetActivity.class));
                }
            });
            //todo 跳转到其他到页面

            return new HeaderViewHolder(headerView);
        }
        if (viewType == TYPE_FOOTER) {
            View footerView = inflater.inflate(R.layout.item_footer_main_recycler, parent, false);
            return new HeaderViewHolder(footerView);
        }
        if (viewType == TYPE_ARTICLE) {
            View articleView = inflater.inflate(R.layout.item_article_main_recycler, parent, false);
            return new HeaderViewHolder(articleView);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (getItemViewType(position) == TYPE_HEADER) {
            HeaderViewHolder headerViewHolder = (HeaderViewHolder) holder;
        }
    }

    @Override
    public int getItemCount() {
        return data.size() + getHeaderCount() + getFooterCount();
    }

    private int getHeaderCount() {
        return 1;
    }

    private int getFooterCount() {
        return 1;
    }

    public class HeaderViewHolder extends RecyclerView.ViewHolder {
        public HeaderViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

        }
    }

    public class FooterViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.text_loading)
        TextView textLoading;
        @BindView(R.id.textview_nomore_data)
        TextView textviewNomoreData;
        @BindView(R.id.text_reload)
        TextView textReload;

        public FooterViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    public class ArticleViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.text_main_recycler_item_title)
        TextView textMainRecyclerItemTitle;
        @BindView(R.id.image_main_recycler_item)
        SimpleDraweeView imageMainRecyclerItem;
        @BindView(R.id.text_publish_time)
        TextView textPublishTime;
        @BindView(R.id.text_comment_count)
        TextView textCommentCount;
        @BindView(R.id.text_looked_count)
        TextView textLookedCount;

        ArticleViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
