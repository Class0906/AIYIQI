package com.bwf.aiyiqi.gui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bwf.aiyiqi.R;
import com.bwf.aiyiqi.entity.ResponseHomeBBS;
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


    public MainRecyclerViewAdapter(Context context) {
        data = new ArrayList<>();
        inflater = LayoutInflater.from(context);
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
        @BindView(R.id.layout_main_header_company)
        LinearLayout layoutMainHeaderCompany;
        @BindView(R.id.layout_main_header_activity)
        LinearLayout layoutMainHeaderActivity;
        @BindView(R.id.layout_main_header_school)
        LinearLayout layoutMainHeaderSchool;
        @BindView(R.id.layout_main_header_money)
        LinearLayout layoutMainHeaderMoney;
        @BindView(R.id.layout_main_header_category)
        LinearLayout layoutMainHeaderCategory;
        @BindView(R.id.layout_main_header_picture)
        LinearLayout layoutMainHeaderPicture;
        @BindView(R.id.layout_main_header_order)
        LinearLayout layoutMainHeaderOrder;
        @BindView(R.id.layout_main_header_design)
        LinearLayout layoutMainHeaderDesign;

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

    public class ArticleViewHolder extends RecyclerView.ViewHolder{
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
