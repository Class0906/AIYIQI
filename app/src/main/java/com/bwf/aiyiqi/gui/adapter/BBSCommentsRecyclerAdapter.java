package com.bwf.aiyiqi.gui.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bwf.aiyiqi.R;
import com.bwf.aiyiqi.entity.ResponseBBSComments;
import com.bwf.aiyiqi.view.FlowLayout;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * Created by lmw on 2016/11/30.
 */
public class BBSCommentsRecyclerAdapter extends RecyclerView.Adapter {
    private LayoutInflater inflater;
    private List<ResponseBBSComments.DataBean> data;
    private final int TYPE_CONTENT = 0;
    private final int TYPE_FOOTER = 1;
    private Context context;

    public BBSCommentsRecyclerAdapter(Context context) {
        this.inflater = LayoutInflater.from(context);
        data = new ArrayList<>();
        this.context = context;
    }

    public void addData(List<ResponseBBSComments.DataBean> data) {
        this.data.addAll(data);
        notifyDataSetChanged();
    }

    @Override
    public int getItemViewType(int position) {
        if(position == getItemCount()-1){
            return TYPE_FOOTER;
        }else
            return TYPE_CONTENT;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == TYPE_CONTENT) {
            View view = inflater.inflate(R.layout.item_bbs_comment_recycler, parent, false);
            return new ContentViewHolder(view);
        }
        View view = inflater.inflate(R.layout.item_bbs_footer_recycler, parent, false);
        return new FooterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if(getItemViewType(position)==TYPE_CONTENT){
            ContentViewHolder contentHolder = (ContentViewHolder) holder;
            contentHolder.imageUserFace.setImageURI(Uri.parse(getItem(position).getAvtUrl()));
            contentHolder.textNickName.setText(getItem(position).getAuthor());
            contentHolder.textPublishTime.setText(getItem(position).getDateline());
            if (!TextUtils.isEmpty(getItem(position).getBlock())){
                contentHolder.textBlock.setVisibility(View.VISIBLE);
                contentHolder.textBlock.setText(getItem(position).getBlock());
            }
            List<ResponseBBSComments.DataBean.MessageBean> messages = getItem(position).getMessage();
            for (ResponseBBSComments.DataBean.MessageBean message:messages){
                if(message.getMsgType()==0){ //为文字，添加textview
                    View text = inflater.inflate(R.layout.subview_comment_text, contentHolder.layoutCommentContent, false);
                    TextView commentText = (TextView) text.findViewById(R.id.text_comment);
                    commentText.setText(message.getMsg());
                    contentHolder.layoutCommentContent.addView(text);
                }else if (message.getMsgType()==1){ //为图片
                    if (message.getImgType() == 3){ //为gif表情
                        View expression = inflater.inflate(R.layout.subview_comment_image, contentHolder.layoutCommentContent, false);
                        SimpleDraweeView commentExpression = (SimpleDraweeView) expression.findViewById(R.id.image_comment_content);
                        ViewGroup.LayoutParams params = commentExpression.getLayoutParams();
                        params.height = dip2px(message.getHeight());
                        params.width = dip2px(message.getWidth());
                        commentExpression.setLayoutParams(params);
                        //todo 配置gif的支持
                        DraweeController controller = Fresco.newDraweeControllerBuilder()
                                .setUri(message.getMsg())
                                .setAutoPlayAnimations(true)
                                .build();
                        commentExpression.setController(controller);
                        contentHolder.layoutCommentContent.addView(expression);
                    }else if (message.getImgType() == 1) { //为jpg图片
                        View photo = inflater.inflate(R.layout.subview_comment_image, contentHolder.layoutCommentContent, false);
                        SimpleDraweeView commentPhoto = (SimpleDraweeView) photo.findViewById(R.id.image_comment_content);
                        ViewGroup.LayoutParams params = commentPhoto.getLayoutParams();
                        params.height = dip2px(message.getHeight());
                        params.width = dip2px(message.getWidth());
                        commentPhoto.setLayoutParams(params);
                        commentPhoto.setImageURI(Uri.parse(message.getMsg()));
                        contentHolder.layoutCommentContent.addView(photo);
                    }
                }
            }
        }
    }
    protected int dip2px(float dpValue){
        float scale = context.getResources().getDisplayMetrics().density;
        return (int)(dpValue*scale+0.5f);
    }
    public ResponseBBSComments.DataBean getItem(int position) {
        return data.get(position - getHeaderCount());
    }

    @Override
    public int getItemCount() {
        return data.size() + getHeaderCount() + getFooterCount();
    }

    private int getHeaderCount() {
        return 0;
    }

    private int getFooterCount() {
        return 1;
    }


    static class ContentViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.image_user_face)
        SimpleDraweeView imageUserFace;
        @BindView(R.id.text_nick_name)
        TextView textNickName;
        @BindView(R.id.text_publish_time)
        TextView textPublishTime;
        @BindView(R.id.image_reply)
        ImageView imageReply;
        @BindView(R.id.layout_comment_content)
        FlowLayout layoutCommentContent;
        @BindView(R.id.text_block)
        TextView textBlock;


        ContentViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

    static class FooterViewHolder extends RecyclerView.ViewHolder {
        FooterViewHolder(View view) {
            super(view);
        }
    }
}
