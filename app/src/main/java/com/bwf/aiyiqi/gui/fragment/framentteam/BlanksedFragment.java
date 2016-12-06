package com.bwf.aiyiqi.gui.fragment.framentteam;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bwf.aiyiqi.R;
import com.bwf.aiyiqi.entity.ResponseTeam;
import com.bwf.aiyiqi.gui.adpter.MyGridViewAdpter;
import com.bwf.aiyiqi.mvp.presenter.TeamPresenter;
import com.bwf.aiyiqi.mvp.presenter.impl.TeamPresenterImpl;
import com.bwf.aiyiqi.mvp.view.TeamView;
import com.bwf.aiyiqi.view.AutoLoadListener;
import com.bwflmw.framwork.BaseFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Zoulin on 2016/11/28.
 */

public class BlanksedFragment extends BaseFragment implements TeamView {
    @BindView(R.id.sub_fragment_fitment_team_text)
    TextView subFragmentFitmentTeamText;
    @BindView(R.id.fitment_team_title_gridview)
    GridView fitmentTeamTitleGridview;
    @BindView(R.id.includ_decorate_contact)
    LinearLayout includDecorateContact;
    @BindView(R.id.includ_decorate_answer)
    LinearLayout includDecorateAnswer;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    protected int getContentViewResId() {
        return R.layout.sub_fragment_fitment_team;
    }

    @Override
    protected void initView() {
        adpter = new MyGridViewAdpter(getContext());
        fitmentTeamTitleGridview.setAdapter(adpter);
    }

    private MyGridViewAdpter adpter;
    private TeamPresenter teamPresenter;
    //页数
    private int netpager;

    @Override
    protected void initData() {
        teamPresenter = new TeamPresenterImpl(this);
        teamPresenter.TeamMasterData();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void showTeamGridview(ResponseTeam responseTeam) {
    }

    @Override
    public void showTeamMaster(ResponseTeam responseTeam) {
        adpter.addDatas(responseTeam.getData());
        //页数查找
        netpager = responseTeam.getPageInfo().getPageNo();
        //添加自动读页事件
        AutoLoadListener autoLoadListener = new AutoLoadListener(callback);
        fitmentTeamTitleGridview.setOnScrollListener(autoLoadListener);
        //添加消息处理
        fitmentTeamTitleGridview.setOnItemClickListener(new ItemClickListener());
    }

    @Override
    public void showTeamSupervision(ResponseTeam responseTeam) {

    }

    /**
     * 回调事件
     */
    AutoLoadListener.AutoLoadCallBack callback = new AutoLoadListener.AutoLoadCallBack() {
        @Override
        public void excute() {
            if (netpager >=4) {
                Toast.makeText(getContext(), "没有更多数据了", Toast.LENGTH_SHORT).show();
                return;
            } else {
                teamPresenter.TeamMasterData();
                return;
            }
        }
    };

    @Override
    public void showFailed() {
        Log.d("BlankFirstFragment", "showFailed");
    }

    // 当AdapterView被单击(触摸屏或者键盘)，则返回的Item单击事件
    class ItemClickListener implements android.widget.AdapterView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Toast.makeText(getContext(), "点击了该" + position + "人物", Toast.LENGTH_SHORT).show();
        }
    }
}
