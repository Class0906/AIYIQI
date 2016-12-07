package com.bwf.aiyiqi.gui.activity;

import android.net.Uri;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bwf.aiyiqi.R;
import com.bwf.aiyiqi.entity.ResponseBBS;
import com.bwf.aiyiqi.entity.ResponseBBSComments;
import com.bwf.aiyiqi.entity.ResponseBBSLikedList;
import com.bwf.aiyiqi.gui.adapter.BBSCommentsRecyclerAdapter;
import com.bwf.aiyiqi.kitutils.Constant;
import com.bwf.aiyiqi.mvp.presenter.BBSPresenter;
import com.bwf.aiyiqi.mvp.presenter.impl.BBSPresenterImpl;
import com.bwf.aiyiqi.mvp.view.BBSView;
import com.bwf.aiyiqi.view.FlowLayout;
import com.bwf.aiyiqi.view.NestingRefreshLayout;
import com.bwflmw.framwork.BaseActivity;
import com.bwflmw.framwork.utils.ToastUtil;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by lmw on 2016/11/29.
 */
public class BBSActivity extends BaseActivity implements BBSView {
    @BindView(R.id.image_header_back)
    ImageView imageHeaderBack;
    @BindView(R.id.image_author_bbs_detail_face)
    SimpleDraweeView imageAuthorBbsDetailFace;
    @BindView(R.id.text_nick_name)
    TextView textNickName;
    @BindView(R.id.text_author_tag)
    TextView textAuthorTag;
    @BindView(R.id.layout_add_attention)
    LinearLayout layoutAddAttention;
    @BindView(R.id.text_bbs_title)
    TextView textBbsTitle;
    @BindView(R.id.text_linked_to_bbs)
    TextView textLinkedToBbs;
    @BindView(R.id.image_article_share)
    ImageView imageArticleShare;
    @BindView(R.id.image_article_collect)
    ImageView imageArticleCollect;
    @BindView(R.id.image_article_like)
    ImageView imageArticleLike;
    @BindView(R.id.text_bbs_reply)
    TextView textBbsReply;
    @BindView(R.id.text_publish_time)
    TextView textPublishTime;
    @BindView(R.id.layout_content_container)
    LinearLayout layoutContentContainer;
    @BindView(R.id.refreshlayout)
    NestingRefreshLayout refreshlayout;
    @BindView(R.id.layout_tag)
    FlowLayout layoutTag;
    @BindView(R.id.text_liked_count)
    TextView textLikedCount;
    @BindView(R.id.layout_liked)
    FlowLayout layoutLiked;
    @BindView(R.id.ll_share_to_wechat_friend)
    LinearLayout llShareToWechatFriend;
    @BindView(R.id.ll_share_to_wechat_moment)
    LinearLayout llShareToWechatMoment;
    @BindView(R.id.ll_share_to_QQ_friend)
    LinearLayout llShareToQQFriend;
    @BindView(R.id.image_ad_bar)
    ImageView imageAdBar;
    @BindView(R.id.recyclerview)
    RecyclerView recyclerview;
    @BindView(R.id.text_comment_count)
    TextView textCommentCount;
    @BindView(R.id.ll_no_comments_can_hide)
    LinearLayout llNoCommentsCanHide;


    private BBSPresenter presenter;
    private String bbsId;
    private LayoutInflater inflater;
    private BBSCommentsRecyclerAdapter adapter;
    private boolean isLoading;

    @Override
    protected int getContentViewResId() {
        return R.layout.activity_bbs;
    }

    @Override
    protected void initView() {
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
        inflater = LayoutInflater.from(this);
        //标题从上一个页面传入
        final String title = getIntent().getStringExtra(Constant.INTENT_TITLE_KEY);
        textBbsTitle.setText(title);
        final LinearLayoutManager manager = new LinearLayoutManager(this);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        manager.setSmoothScrollbarEnabled(true);
        manager.setAutoMeasureEnabled(true);
        recyclerview.setLayoutManager(manager);
        recyclerview.setHasFixedSize(true);
        recyclerview.setNestedScrollingEnabled(false);
        adapter = new BBSCommentsRecyclerAdapter(this);
        recyclerview.setAdapter(adapter);

        recyclerview.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                Log.d("BBSActivity", "y: "+dy);
                Log.d("BBSActivity", "isLoading:" + isLoading);
                Log.d("BBSActivity", "manager.findLastVisibleItemPosition():" + manager.findLastVisibleItemPosition());
                if(!isLoading&&manager.findLastVisibleItemPosition()>=adapter.getItemCount()-2){
                    Log.d("BBSActivity", "loading");
                    isLoading = true;
                    presenter.loadMoreComments(bbsId);
                }
            }
        });
    }

    @Override
    protected void initData() {
        presenter = new BBSPresenterImpl(this);
        bbsId = getIntent().getStringExtra(Constant.INTENT_ID_KEY);
        Log.d("BBSActivity", bbsId);
        isLoading = true;
        presenter.loadBBSData(bbsId);
    }

    @OnClick({R.id.image_header_back, R.id.text_linked_to_bbs, R.id.image_article_share, R.id.image_article_collect, R.id.image_article_like, R.id.text_bbs_reply, R.id.ll_share_to_wechat_friend, R.id.ll_share_to_wechat_moment, R.id.ll_share_to_QQ_friend})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.image_header_back:
                finish();
                break;
            case R.id.text_linked_to_bbs:
                break;
            case R.id.image_article_share:
                break;
            case R.id.image_article_collect:
                break;
            case R.id.image_article_like:
                break;
            case R.id.text_bbs_reply:
                break;
            case R.id.ll_share_to_wechat_friend:
                break;
            case R.id.ll_share_to_wechat_moment:
                break;
            case R.id.ll_share_to_QQ_friend:
                break;
        }
    }

    @Override
    public void showBBSDetail(ResponseBBS data) {
        imageAuthorBbsDetailFace.setImageURI(Uri.parse(data.getData().getAvtUrl()));
        textNickName.setText(data.getData().getAuthor());
        textPublishTime.setText(data.getData().getDateline());
        //构造帖子内容
        List<ResponseBBS.DataBean.MessageBean> content = data.getData().getMessage();
        for (ResponseBBS.DataBean.MessageBean paragraph : content) {
            if (paragraph.getMsgType() == 0) {//为文字
                View textParagraph = inflater.inflate(R.layout.text_paragraph, layoutContentContainer, false);
                TextView text = (TextView) textParagraph.findViewById(R.id.text_paragraph);
                text.setText(paragraph.getMsg());
                layoutContentContainer.addView(textParagraph);
            } else if (paragraph.getMsgType() == 1) {//为图片
                View imageParagraph = inflater.inflate(R.layout.image_paragraph, layoutContentContainer, false);
                SimpleDraweeView image = (SimpleDraweeView) imageParagraph.findViewById(R.id.image_paragraph);
                image.setImageURI(Uri.parse(paragraph.getMsg()));
                //动态设置图片宽高
                ViewGroup.LayoutParams layoutParams = image.getLayoutParams();
                layoutParams.width=dip2px(paragraph.getWidth());//因为系统使用的是px，服务器返回的是dp，所以需要单位转换
                layoutParams.height=dip2px(paragraph.getHeight());
                //使用通用的方法显示图片，如果不论服务器返回的宽高单位如何都可以合理显示
//                layoutParams.width = ViewGroup.LayoutParams.MATCH_PARENT;
//                layoutParams.height = this.getWindowManager().getDefaultDisplay().getWidth() * paragraph.getHeight() / paragraph.getWidth();
                image.setLayoutParams(layoutParams);
                layoutContentContainer.addView(imageParagraph);
            }
        }
        //使用流布局动态添加tag
        List<ResponseBBS.DataBean.TagsBean> tags = data.getData().getTags();
        for (ResponseBBS.DataBean.TagsBean tag : tags) {
            View tagView = inflater.inflate(R.layout.layout_item_tag, layoutTag, false);
            TextView textTag = (TextView) tagView.findViewById(R.id.text_tag);
            textTag.setText(tag.getTagname());
            layoutTag.addView(tagView);
        }

    }

    @Override
    public void showFailed() {
        isLoading = false;
        ToastUtil.toToast("加载失败");
    }

    @Override
    public void showLickedList(ResponseBBSLikedList data) {
        //使用流布局添加赞列表
        textLikedCount.setText(getString(R.string.liked_count, data.getTotalCount()));
        for (ResponseBBSLikedList.DataBean like : data.getData()) {
            View likedView = inflater.inflate(R.layout.item_liked_face, layoutLiked, false);
            SimpleDraweeView userFace = (SimpleDraweeView) likedView.findViewById(R.id.image_user_face);
            userFace.setImageURI(Uri.parse(like.getAvtUrl()));
            layoutLiked.addView(likedView);
        }

    }

    @Override
    public void showComments(ResponseBBSComments data) {
        isLoading = false;
        textCommentCount.setText(getString(R.string.reply_count, data.getTotalCount()));
        if (data.getTotalCount() == 0) {
            llNoCommentsCanHide.setVisibility(View.VISIBLE);
        }
            adapter.addData(data.getData());
    }

}
