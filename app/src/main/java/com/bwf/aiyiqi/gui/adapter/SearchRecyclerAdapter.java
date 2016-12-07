package com.bwf.aiyiqi.gui.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bwf.aiyiqi.R;
import com.bwf.aiyiqi.entity.ResponseSearch;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by lmw on 2016/12/6.
 */
public class SearchRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private LayoutInflater inflater;
    private List<ResponseSearch.DataBean> data;

    private int TYPE_HEADER = 0;
    private int TYPE_CONTENT = 1;
    private int TYPE_FOOTER = 2;


    public SearchRecyclerAdapter(Context context) {
        this.context = context;
        inflater = LayoutInflater.from(context);
        data = new ArrayList<>();
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return TYPE_HEADER;
        }
        if (position == getItemCount() - 1) {
            return TYPE_FOOTER;
        }
        return TYPE_CONTENT;
    }

    public void setData(List<ResponseSearch.DataBean> data){
        Log.d("SearchRecyclerAdapter", "data:" + data);
        this.data.clear();
        this.data.addAll(data);
        notifyDataSetChanged();
    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == TYPE_HEADER) {
            View view = inflater.inflate(R.layout.item_header_serch_recycler, parent, false);
            return new HeaderViewHolder(view);
        } else if (viewType == TYPE_FOOTER) {
            View view = inflater.inflate(R.layout.item_footer_main_recycler, parent, false);
            return new FooterViewHolder(view);
        } else {
            View view = inflater.inflate(R.layout.item_search_content_recycler, parent, false);
            return new ContentViewHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (getItemViewType(position)==TYPE_CONTENT) {
            ResponseSearch.DataBean itemData = getItemData(position);
            ContentViewHolder viewHolder = (ContentViewHolder) holder;
            viewHolder.imageAuthorBbsFace.setImageURI(Uri.parse(itemData.getAvtUrl()));
            viewHolder.textNickName.setText(itemData.getAuthor());
            viewHolder.textBbsTitle.setText(itemData.getSubject());
            if (itemData.getAttachments()!=null){
                viewHolder.imageBbsItem.setVisibility(View.VISIBLE);
                viewHolder.imageBbsItem.setImageURI(Uri.parse(itemData.getAttachments().get(0)));
            }
            viewHolder.textLinkedToBbs.setText("精选自"+itemData.getFname()+">");
            viewHolder.textPublishTime.setText(itemData.getDateline());
            viewHolder.textCommentCount.setText(itemData.getReplies());
        }
    }

    public ResponseSearch.DataBean getItemData(int position){
        return data.get(position-getHeaderCount());
    }
    @Override
    public int getItemCount() {
        return data.size() + getHeaderCount() + getFooterCount();
    }

    public int getHeaderCount() {
        return 1;
    }

    public int getFooterCount() {
        return 1;
    }

    public void setOnItemClickListener(OnItemClickListener listener){
        this.listener = listener;
    }
    public interface OnItemClickListener{
        void onclick(int position);
    }
    private OnItemClickListener listener;

    static class HeaderViewHolder extends RecyclerView.ViewHolder {
        private LinearLayout llRelativeUserContainer;
        HeaderViewHolder(View view) {
            super(view);
            llRelativeUserContainer = (LinearLayout) view.findViewById(R.id.ll_relative_user_container);
        }
    }

    static class FooterViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.text_loading)
        TextView textLoading;
        @BindView(R.id.textview_nomore_data)
        TextView textviewNomoreData;
        @BindView(R.id.text_reload)
        TextView textReload;

        FooterViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

    class ContentViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.image_author_bbs_face)
        SimpleDraweeView imageAuthorBbsFace;
        @BindView(R.id.text_nick_name)
        TextView textNickName;
        @BindView(R.id.text_bbs_title)
        TextView textBbsTitle;
        @BindView(R.id.image_bbs_item)
        SimpleDraweeView imageBbsItem;
        @BindView(R.id.text_linked_to_bbs)
        TextView textLinkedToBbs;
        @BindView(R.id.image_article_share)
        ImageView imageArticleShare;
        @BindView(R.id.text_comment_count)
        TextView textCommentCount;
        @BindView(R.id.image_comment)
        ImageView imageComment;
        @BindView(R.id.image_collection)
        ImageView imageCollection;
        @BindView(R.id.text_publish_time)
        TextView textPublishTime;

        ContentViewHolder(View view) {
            super(view);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (listener!=null){
                        listener.onclick(getAdapterPosition());
                    }
                }
            });
            ButterKnife.bind(this, view);
        }
    }
}
