package com.staff.staffapp.pns.adapter;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.staff.staffapp.pns.ui.BusinessFragment;
import com.staff.staffapp.pns.ui.PersonalFragment;

public class PageAdapter extends FragmentStatePagerAdapter {

    private int numOfTabs;

    public PageAdapter(FragmentManager fm, int numOfTabs) {
        super(fm);
        this.numOfTabs=numOfTabs;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new PersonalFragment();
            case 1:
                return new BusinessFragment();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return numOfTabs;
    }
}
