package com.bwf.aiyiqi.gui.adpter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.bwf.aiyiqi.gui.fragment.framentteam.BlankFirstFragment;
import com.bwf.aiyiqi.gui.fragment.framentteam.BlankThriFragment;
import com.bwf.aiyiqi.gui.fragment.framentteam.BlanksedFragment;

/**
 * Created by Zoulin on 2016/11/28.
 */

public class MyAdapter extends FragmentPagerAdapter {
    int nNumOfTabs;

    public MyAdapter(FragmentManager fm, int nNumOfTabs) {
        super(fm);
        this.nNumOfTabs = nNumOfTabs;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                BlankFirstFragment fistFragemnt = new BlankFirstFragment();
                return fistFragemnt;
            case 1:
                BlanksedFragment sedFragment = new BlanksedFragment();
                return sedFragment;
            case 2:
                BlankThriFragment thriFragment = new BlankThriFragment();
                return thriFragment;
        }
        return null;
    }

    @Override
    public int getCount() {
        return nNumOfTabs;
    }
}
