package com.bwf.aiyiqi.gui.activity.web;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.bwf.aiyiqi.R;
import com.bwf.aiyiqi.entity.ResponseTheSame;
import com.bwf.aiyiqi.gui.activity.MainActivity;
import com.bwf.aiyiqi.gui.adpter.TheSameAdpter;
import com.bwf.aiyiqi.mvp.presenter.TheSamePresenter;
import com.bwf.aiyiqi.mvp.presenter.impl.TheSamePresenterImpl;
import com.bwf.aiyiqi.mvp.view.TheSameView;
import com.bwf.aiyiqi.view.AutoLoadListener;
import com.bwflmw.framwork.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Zoulin on 2016/11/30.
 * 同城活动
 */

public class TheSameActivity extends BaseActivity implements TheSameView {
    private TheSameAdpter adpter;
    private TheSamePresenter presenter;
    private String url;

    @BindView(R.id.main_titile_fitment_img)
    ImageView mainTitileFitmentImg;
    @BindView(R.id.icluce_text_activity)
    TextView icluceTextActivity;
    @BindView(R.id.activity_the_same_listview)
    ListView activityTheSameListview;
    @Override
    protected int getContentViewResId() {
        return R.layout.activity_the_same;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {
        presenter = new TheSamePresenterImpl(this);
        presenter.thesameData();
    }
    @Override
    public void thasameView(ResponseTheSame responseTheSame) {
        adpter = new TheSameAdpter(this, responseTheSame.getData().getForumlist());
        activityTheSameListview.setAdapter(adpter);
        //添加自动读页事件
        AutoLoadListener autoLoadListener = new AutoLoadListener(callback);
        activityTheSameListview.setOnScrollListener(autoLoadListener);
        //添加item点击事件
        activityTheSameListview.setOnItemClickListener(new ItemClickListener());
    }

    /**
     * 回调事件
     */
    AutoLoadListener.AutoLoadCallBack callback = new AutoLoadListener.AutoLoadCallBack() {
        @Override
        public void excute() {
            Toast.makeText(TheSameActivity.this, "没有更多活动了，敬请期待", Toast.LENGTH_SHORT).show();
        }
    };
    @Override
    public void showFailed() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
        icluceTextActivity.setText("同城活动");
    }

    @OnClick({R.id.main_titile_fitment_img})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.main_titile_fitment_img:
                gotoMian();
                break;
        }
    }
    public void gotoMian() {
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }
    // 当AdapterView被单击(触摸屏或者键盘)，则返回的Item单击事件
    class ItemClickListener implements android.widget.AdapterView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            //获取我们在界面点击时的item，强转我们所需要的对象.可以获取里面的对象
            ResponseTheSame.DataBean.ForumlistBean s = (ResponseTheSame.DataBean.ForumlistBean) parent.getItemAtPosition(position);
            //Toast.makeText(TheSameActivity.this, "点击了第"+position+"个"+s.getUrls(), Toast.LENGTH_SHORT).show();
            if (s.getUrls().equals("")){
                startActivity(new Intent(getApplicationContext(),TheSameHtmlActivityFirst.class));
            }else{
                Intent intent=new Intent();
                intent.putExtra("getUrls",s.getUrls());
                Log.d("ItemClickListener", "传递的网址："+s.getUrls());
                intent.setClass(getApplicationContext(),ThrSameHtmlSendActiity.class);
                startActivity(intent);
            }
        }
    }
}
