package com.bwf.aiyiqi.mvp.view;

import com.bwf.aiyiqi.entity.ResponseTeam;

/**
 * Created by Zoulin on 2016/11/29.
 * 一起团队
 */
public interface  TeamView {
    //设计师数据
    void showTeamGridview(ResponseTeam responseTeam);
    //工长数据
    void showTeamMaster(ResponseTeam responseTeam);
    //监理数据
    void showTeamSupervision(ResponseTeam responseTeam);
    void showFailed();
}
