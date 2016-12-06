package com.bwf.aiyiqi.gui.adpter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.bwf.aiyiqi.gui.fragment.designfragment.DesignRoomFirtment;
import com.bwf.aiyiqi.gui.fragment.designfragment.DesignRoomsedFirtment;

/**
 * Created by Zoulin on 2016/12/2.
 */

public class MyDesignRoomAdapter extends FragmentPagerAdapter {

    int nNumOfTabs;

    public MyDesignRoomAdapter(FragmentManager fm, int nNumOfTabs) {
        super(fm);
        this.nNumOfTabs = nNumOfTabs;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                DesignRoomFirtment fistFragemnt = new DesignRoomFirtment();
                return fistFragemnt;
            case 1:
                DesignRoomsedFirtment sedFragment = new DesignRoomsedFirtment();
                return sedFragment;
        }
        return null;
    }

    @Override
    public int getCount() {
        return nNumOfTabs;
    }
}
