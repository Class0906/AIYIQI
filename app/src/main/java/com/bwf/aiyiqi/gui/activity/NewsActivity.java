package com.bwf.aiyiqi.gui.activity;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.bwf.aiyiqi.R;
import com.bwf.aiyiqi.entity.ResponseNews;
import com.bwf.aiyiqi.entity.ResponseNewsComments;
import com.bwf.aiyiqi.gui.adapter.NewsRecyclerAdapter;
import com.bwf.aiyiqi.kitutils.Constant;
import com.bwf.aiyiqi.mvp.presenter.NewsPresenter;
import com.bwf.aiyiqi.mvp.presenter.impl.NewsPresenterImpl;
import com.bwf.aiyiqi.mvp.view.NewsView;
import com.bwflmw.framwork.BaseActivity;
import com.bwflmw.framwork.utils.ToastUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by lmw on 2016/11/29.
 */
public class NewsActivity extends BaseActivity implements NewsView {
    @BindView(R.id.image_header_back)
    ImageView imageHeaderBack;
    @BindView(R.id.text_header_title)
    TextView textHeaderTitle;
    @BindView(R.id.recyclerview)
    RecyclerView recyclerview;
    @BindView(R.id.image_article_share)
    ImageView imageArticleShare;
    @BindView(R.id.image_article_collect)
    ImageView imageArticleCollect;
    @BindView(R.id.text_bbs_reply)
    EditText textBbsReply;

    private NewsRecyclerAdapter adapter;
    private NewsPresenter presenter;

    @Override
    protected int getContentViewResId() {
        return R.layout.activity_news;
    }

    @Override
    protected void initView() {
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
        textHeaderTitle.setText("文章详情");
        LinearLayoutManager manager = new LinearLayoutManager(this);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerview.setLayoutManager(manager);
        adapter = new NewsRecyclerAdapter(this);
        recyclerview.setAdapter(adapter);
    }

    @Override
    protected void initData() {
        presenter = new NewsPresenterImpl(this);
        String id = getIntent().getStringExtra(Constant.INTENT_ID_KEY);
        presenter.loadData(id);
        Log.d("NewsActivity", id);
    }


    @OnClick({R.id.image_header_back, R.id.image_article_share, R.id.image_article_collect})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.image_header_back:
                finish();
                break;
            case R.id.image_article_share:
                break;
            case R.id.image_article_collect:
                break;
        }
    }

    @Override
    public void showNewsContent(ResponseNews data) {
        adapter.setContentData(data);
    }

    @Override
    public void showNewsComments(ResponseNewsComments data) {
        adapter.addCommentsData(data.getData().getData());
    }

    @Override
    public void showContentFailed() {
        ToastUtil.toToast("文章加载失败");
    }

    @Override
    public void showCommentsFailed() {
        ToastUtil.toToast("评论加载失败");
    }
}
