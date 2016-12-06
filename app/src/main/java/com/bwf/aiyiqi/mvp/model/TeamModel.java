package com.bwf.aiyiqi.mvp.model;

import com.bwf.aiyiqi.entity.ResponseTeam;

/**
 * Created by Zoulin on 2016/11/29.
 */

public interface TeamModel {
    void TeamStylistDats(TeamModelCallback callback);

    void TeamMasterData(TeamModelCallback callback);

    void TeamSupervisionData(TeamModelCallback callback);

    interface TeamModelCallback {
        void onLoadSuccess(ResponseTeam responseTeam);
        void onLoadFailed();
    }

}
