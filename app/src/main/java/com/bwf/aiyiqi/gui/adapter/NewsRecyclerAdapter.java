package com.bwf.aiyiqi.gui.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bwf.aiyiqi.R;
import com.bwf.aiyiqi.entity.ResponseNews;
import com.bwf.aiyiqi.entity.ResponseNewsComments;
import com.facebook.drawee.view.SimpleDraweeView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * Created by lmw on 2016/12/1.
 */
public class NewsRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private final int TYPE_HEADER = 0;
    private final int TYPE_RELATED_ARTICLE = 1;
    private final int TYPE_COMMENTS = 2;
    private final int TYPE_FOOTER = 3;
    private LayoutInflater inflater;
    private Context context;
    private ResponseNews contentData;
    private List<ResponseNewsComments.DataBeanX.DataBean> commentsData;

    public NewsRecyclerAdapter(Context context) {
        inflater = LayoutInflater.from(context);
        this.context = context;
        commentsData = new ArrayList<>();
    }

    public void setContentData(ResponseNews data) {
        contentData = data;
        notifyItemChanged(0);
    }

    public void addCommentsData(List<ResponseNewsComments.DataBeanX.DataBean> data) {
        commentsData.addAll(data);
        notifyDataSetChanged();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == TYPE_HEADER) {
            View view = inflater.inflate(R.layout.layout_news_content, parent, false);
            return new HeaderViewHolder(view);
        }
        if (viewType == TYPE_RELATED_ARTICLE) {
            View view = inflater.inflate(R.layout.layout_related_article, parent, false);
            return new RelatedArticleViewHolder(view);
        }
        if (viewType == TYPE_FOOTER) {
            View view = inflater.inflate(R.layout.item_bbs_footer_recycler, parent, false);
            return new FooterViewHolder(view);
        }
        View view = inflater.inflate(R.layout.item_news_comment_recycler, parent, false);
        return new CommentViewHolder(view);
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return TYPE_HEADER;
        } else if (position == 1)
            return TYPE_RELATED_ARTICLE;
        else if (position == getItemCount() - 1)
            return TYPE_FOOTER;
        else
            return TYPE_COMMENTS;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (getItemViewType(position) == TYPE_HEADER) {
            HeaderViewHolder viewHolder = (HeaderViewHolder) holder;
            if (contentData != null) {
                viewHolder.textBbsTitle.setText(contentData.getData().getCurrentNews().getTitle());
                //添加标签
                for (Map.Entry<String, String> entry : contentData.getData().getTags().entrySet()) {
                    View view = inflater.inflate(R.layout.layout_news_tag, viewHolder.layoutTag, false);
                    TextView tag = (TextView) view.findViewById(R.id.text_tag);
                    tag.setText(entry.getValue());
                    viewHolder.layoutTag.addView(view);
                }
                //加载webView
                List<String> content = contentData.getData().getCurrentNews().getContent();
                StringBuilder builder = new StringBuilder();
                for (String paragraph : content) {
                    if (paragraph.startsWith("http"))
                        builder.append("<img src='"+paragraph+"'/>");
                    else
                    builder.append(paragraph);
                }
                String url = builder.toString();
                viewHolder.webviewNews.loadDataWithBaseURL("", url, "text/html", "utf-8", "");
            }
        } else if (getItemViewType(position) == TYPE_RELATED_ARTICLE) {
            RelatedArticleViewHolder viewHolder = (RelatedArticleViewHolder) holder;
            if (contentData != null) {
                for (ResponseNews.RelatedNewsBean data : contentData.getRelatedNews()) {
                    View view = inflater.inflate(R.layout.item_related_article, viewHolder.layoutContentContainer, false);
                    SimpleDraweeView image = (SimpleDraweeView) view.findViewById(R.id.image_preview);
                    if (!TextUtils.isEmpty(data.getThumb())) {
                        image.setImageURI(Uri.parse(data.getThumb()));
                    }
                    TextView title = (TextView) view.findViewById(R.id.text_bbs_title);
                    title.setText(data.getTitle());
                    TextView lookedCount = (TextView) view.findViewById(R.id.text_looked_count);
                    lookedCount.setText(data.getClick() + "");
                    TextView collectionCount = (TextView) view.findViewById(R.id.text_collection_count);
                    collectionCount.setText(data.getFavNums() + "");
                    TextView commentsCount = (TextView) view.findViewById(R.id.text_comment_count);
                    commentsCount.setText(data.getComment_count());
                    viewHolder.layoutContentContainer.addView(view);
                }
            }
            viewHolder.textCommentsCount.setText(context.getString(R.string.comment_count, commentsData.size()));
        } else if (getItemViewType(position) == TYPE_COMMENTS) {
            CommentViewHolder viewHolder = (CommentViewHolder) holder;
            if (commentsData.get(0) != null) {
                viewHolder.imageUserFace.setImageURI(Uri.parse(getCommentItem(position).getUserheadimage()));
                viewHolder.textNickName.setText(getCommentItem(position).getComment_user_name());
                long timeStr = Long.parseLong(getCommentItem(position).getComment_time());
                Date date = new Date(timeStr);
                SimpleDateFormat formatter = new SimpleDateFormat("MM-dd");
                String formatDate = formatter.format(date);
                viewHolder.textPublishTime.setText(formatDate);
                viewHolder.textCommentContent.setText(getCommentItem(position).getComment_content());
            }
        } else if (getItemViewType(position) == TYPE_FOOTER) {
            FooterViewHolder viewHolder = (FooterViewHolder) holder;
            viewHolder.textFooter.setText("没有更多评论了");
        }
    }

    public ResponseNewsComments.DataBeanX.DataBean getCommentItem(int position) {
        return commentsData.get(position - getHeaderCount());
    }

    @Override
    public int getItemCount() {
        return getFooterCount() + getHeaderCount() + getCommentsCount();
    }

    private int getHeaderCount() {
        return 2;
    }

    private int getFooterCount() {
        return 1;
    }
    private int getCommentsCount(){
        if (commentsData.size()>0&&commentsData.get(0) == null){
            return 0;
        }else
            return commentsData.size();
    }

    static class HeaderViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.text_bbs_title)
        TextView textBbsTitle;
        @BindView(R.id.webview_news)
        WebView webviewNews;
        private LinearLayout layoutTag;

        HeaderViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
            layoutTag = (LinearLayout) view.findViewById(R.id.layout_tag);
        }
    }

    static class RelatedArticleViewHolder extends RecyclerView.ViewHolder {
        private LinearLayout layoutContentContainer;
        private TextView textCommentsCount;

        RelatedArticleViewHolder(View view) {
            super(view);
            layoutContentContainer = (LinearLayout) view.findViewById(R.id.layout_content_container);
            textCommentsCount = (TextView) view.findViewById(R.id.text_comment_count);
        }
    }

    static class FooterViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.text_footer)
        TextView textFooter;

        FooterViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);

        }
    }

    static class CommentViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.image_user_face)
        SimpleDraweeView imageUserFace;
        @BindView(R.id.text_nick_name)
        TextView textNickName;
        @BindView(R.id.text_publish_time)
        TextView textPublishTime;
        @BindView(R.id.text_comment_content)
        TextView textCommentContent;

        CommentViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
