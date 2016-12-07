package com.bwf.aiyiqi.gui.activity.web;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.bwf.aiyiqi.R;
import com.bwf.aiyiqi.entity.ResponseHomeFurne;
import com.bwf.aiyiqi.gui.adpter.HomeFurnitureAdpter;
import com.bwf.aiyiqi.mvp.presenter.HomeFurniturePresenter;
import com.bwf.aiyiqi.mvp.presenter.impl.HomeFurniturePresenterImpl;
import com.bwf.aiyiqi.mvp.view.HomeFurnitureView;
import com.bwf.aiyiqi.view.MyGridView;
import com.bwflmw.framwork.BaseActivity;
import com.cjj.MaterialRefreshLayout;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Zoulin on 2016/12/6.
 */

public class HomeFurnitureActivity extends BaseActivity implements HomeFurnitureView {
    @BindView(R.id.main_titile_fitment_img)
    ImageView mainTitileFitmentImg;
    @BindView(R.id.icluce_text_activity)
    TextView icluceTextActivity;
    @BindView(R.id.home_first_gridview)
    MyGridView homeFirstGridview;
    @BindView(R.id.home_send_gridview)
    MyGridView homeSendGridview;
    @BindView(R.id.home_third_gridview)
    MyGridView homeThirdGridview;
    @BindView(R.id.home_four_gridview)
    MyGridView homeFourGridview;
    @BindView(R.id.refreshlayout_activity)
    MaterialRefreshLayout refreshlayoutActivity;
    private HomeFurniturePresenter presenter;
    private HomeFurnitureAdpter adpter;
    private List<ResponseHomeFurne.DataBean.ChildrenBean> dats;

    @Override
    protected int getContentViewResId() {
        return R.layout.activity_home_furniture;
    }

    @Override
    protected void initView() {
    }

    /**
     * 初始化数据
     */
    @Override
    protected void initData() {
        presenter = new HomeFurniturePresenterImpl(this);
        presenter.homefunritureData();


    }

    @Override
    public void showMainViewPager(ResponseHomeFurne homeFurne) {
        for (int i = 0; i < homeFurne.getData().size(); i++) {
            dats = homeFurne.getData().get(i).getChildren();
            Log.d("HomeFurnitureActivity", "homeFurne.getData().get(i):" + homeFurne.getData().get(i));
            if (i == 0) {
                adpter = new HomeFurnitureAdpter(this);
                adpter.setDatas(dats);
                homeFirstGridview.setAdapter(adpter);

            } else if (i == 1) {
                adpter = new HomeFurnitureAdpter(this);
                Log.d("HomeFurnitureActivity", "dats:" + dats);
                adpter.setDatas(dats);
                homeSendGridview.setAdapter(adpter);
            } else if (i == 2) {
                adpter = new HomeFurnitureAdpter(this);
                adpter.setDatas(dats);
                homeThirdGridview.setAdapter(adpter);

            } else if (i == 3) {
                adpter = new HomeFurnitureAdpter(this);
                adpter.setDatas(dats);
                homeFourGridview.setAdapter(adpter);

            }
        }

    }

    @Override
    public void showFailed() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
