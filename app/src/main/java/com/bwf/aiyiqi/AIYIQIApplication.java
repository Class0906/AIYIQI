package com.bwf.aiyiqi;

import com.bwflmw.framwork.MyApplication;
import com.uuzuche.lib_zxing.activity.ZXingLibrary;

/**
 * Created by lmw on 2016/12/7.
 */

public class AIYIQIApplication extends MyApplication {
    @Override
    public void onCreate() {
        super.onCreate();
        ZXingLibrary.initDisplayOpinion(this);
    }
}
