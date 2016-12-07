package com.bwf.aiyiqi.gui.fragment.effectpicturefragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.bwf.aiyiqi.R;
import com.bwf.aiyiqi.entity.ResponseEffectPicture;
import com.bwf.aiyiqi.gui.adpter.EffectPictureAdpter;
import com.bwf.aiyiqi.mvp.presenter.EffectPicturePreseenter;
import com.bwf.aiyiqi.mvp.presenter.impl.EffectPicturePreseenterImpl;
import com.bwf.aiyiqi.mvp.view.EffectPictureView;
import com.bwf.aiyiqi.view.AutoLoadListener;
import com.bwflmw.framwork.BaseFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Zoulin on 2016/12/2.
 * 专题
 */

public class EffectPictureFirtment extends BaseFragment implements EffectPictureView {
    @BindView(R.id.effect_picture_activity_list)
    ListView effectPictureActivityList;

    private EffectPicturePreseenter preseenter;
    private EffectPictureAdpter adpter;

    @Override
    protected int getContentViewResId() {
        return R.layout.effect_picture_activity_listview;
    }

    @Override
    protected void initView() {
        adpter = new EffectPictureAdpter(getContext());
        effectPictureActivityList.setAdapter(adpter);
    }

    @Override
    protected void initData() {
        preseenter = new EffectPicturePreseenterImpl(this);
        preseenter.EffectPictureData();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void showEffectPicturelistView(ResponseEffectPicture data) {
        Log.d("EffectPictureFirtment", "adpter:" + adpter);
        Log.d("EffectPictureFirtment", "data.getData().getList():" + data.getData().getList());
        adpter.addDatas(data.getData().getList());
        //添加自动读页事件
        AutoLoadListener autoLoadListener = new AutoLoadListener(callback);
        effectPictureActivityList.setOnScrollListener(autoLoadListener);
        //添加消息处理
        effectPictureActivityList.setOnItemClickListener(new ItemClickListener());
    }

    /**
     * 回调事件
     */
    AutoLoadListener.AutoLoadCallBack callback = new AutoLoadListener.AutoLoadCallBack() {
        @Override
        public void excute() {
            Toast.makeText(getContext(), "正在加载下一页，请稍等", Toast.LENGTH_SHORT).show();
            preseenter.EffectPictureData();
            //  Toast.makeText(getContext(), "没有更多数据了", Toast.LENGTH_SHORT).show();
        }
    };

    // 当AdapterView被单击(触摸屏或者键盘)，则返回的Item单击事件
    class ItemClickListener implements android.widget.AdapterView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        }
    }

    @Override
    public void showFailed() {

    }
}
