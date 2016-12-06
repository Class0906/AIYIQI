package com.bwf.aiyiqi.gui.adpter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.bwf.aiyiqi.gui.fragment.effectpicturefragment.EffectPictureFirtment;
import com.bwf.aiyiqi.gui.fragment.effectpicturefragment.EffectPicturesedFirtment;

/**
 * Created by Zoulin on 2016/12/2.
 */

public class MyEffectPictureAdapter extends FragmentPagerAdapter {

    int nNumOfTabs;

    public MyEffectPictureAdapter(FragmentManager fm, int nNumOfTabs) {
        super(fm);
        this.nNumOfTabs = nNumOfTabs;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                EffectPictureFirtment fistFragemnt = new EffectPictureFirtment();
                return fistFragemnt;
            case 1:
                EffectPicturesedFirtment sedFragment = new EffectPicturesedFirtment();
                return sedFragment;
        }
        return null;
    }

    @Override
    public int getCount() {
        return nNumOfTabs;
    }
}
