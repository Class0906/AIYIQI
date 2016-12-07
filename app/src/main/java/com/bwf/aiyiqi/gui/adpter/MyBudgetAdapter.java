package com.bwf.aiyiqi.gui.adpter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.bwf.aiyiqi.gui.fragment.BudgetQuoteFragment.BudgetQuotefistFirtment;
import com.bwf.aiyiqi.gui.fragment.BudgetQuoteFragment.BudgetQuotesendFirtment;

/**
 * Created by Zoulin on 2016/12/2.
 */

public class MyBudgetAdapter extends FragmentPagerAdapter {

    int nNumOfTabs;

    public MyBudgetAdapter(FragmentManager fm, int nNumOfTabs) {
        super(fm);
        this.nNumOfTabs = nNumOfTabs;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                BudgetQuotefistFirtment quotefistFirtment = new BudgetQuotefistFirtment();
                return quotefistFirtment;
            case 1:
                BudgetQuotesendFirtment quotesedFragment = new BudgetQuotesendFirtment();
                return quotesedFragment;
        }
        return null;
    }

    @Override
    public int getCount() {
        return nNumOfTabs;
    }
}
