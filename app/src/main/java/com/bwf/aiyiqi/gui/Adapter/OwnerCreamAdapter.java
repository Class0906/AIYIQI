package com.bwf.aiyiqi.gui.Adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.bwf.aiyiqi.gui.fragment.FragmentOwnerCream;

/**
 * Created by Administrator on 2016/11/25.
 */

public class OwnerCreamAdapter extends FragmentPagerAdapter{

    final int PAGE_COUNT = 3;
    private String tabTitles[] = new String[]{"精选","最新","版块"};
    private Context context;

    public OwnerCreamAdapter(FragmentManager fm,Context context) {
        super( fm );
        this.context = context;

    }

    @Override
    public Fragment getItem(int position) {
        return FragmentOwnerCream.newInstance( position+1 );
    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabTitles[position];
    }
}
