package com.bwf.aiyiqi.mvp.presenter.impl;

import com.bwf.aiyiqi.entity.ResponseTeam;
import com.bwf.aiyiqi.mvp.model.TeamModel;
import com.bwf.aiyiqi.mvp.model.impl.TeamModelImpl;
import com.bwf.aiyiqi.mvp.presenter.TeamPresenter;
import com.bwf.aiyiqi.mvp.view.TeamView;

/**
 * Created by Zoulin on 2016/11/29.
 */

public class TeamPresenterImpl implements TeamPresenter {
    private TeamModel model;
    private TeamView view;

    public TeamPresenterImpl(TeamView view) {
        this.view = view;
        model = new TeamModelImpl();
    }

    //处理设计师数据
    @Override
    public void TeamStylistData() {
        model.TeamStylistDats(new TeamModel.TeamModelCallback() {
            @Override
            public void onLoadSuccess(ResponseTeam responseTeam) {
                view.showTeamGridview(responseTeam);
            }

            @Override
            public void onLoadFailed() {
                view.showFailed();
            }
        });
    }
    //工长
    @Override
    public void TeamMasterData() {
            model.TeamMasterData(new TeamModel.TeamModelCallback() {
                @Override
                public void onLoadSuccess(ResponseTeam responseTeam) {
                    view.showTeamMaster(responseTeam);
                }

                @Override
                public void onLoadFailed() {
                    view.showFailed();
                }
            });
    }
    //监理
    @Override
    public void TeamSupervisionData() {
        model.TeamSupervisionData(new TeamModel.TeamModelCallback() {
            @Override
            public void onLoadSuccess(ResponseTeam responseTeam) {
                view.showTeamSupervision(responseTeam);
            }

            @Override
            public void onLoadFailed() {
                view.showFailed();
            }
        });
    }
}
