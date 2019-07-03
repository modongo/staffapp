package com.staff.staffapp.pns.adapter;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.staff.staffapp.pns.ui.InternetFragment;
import com.staff.staffapp.pns.ui.MpesaFragment;
import com.staff.staffapp.pns.ui.PlansFragment;
import com.staff.staffapp.pns.ui.ServicesFragment;

public class CategoriesPageAdapter extends FragmentStatePagerAdapter {

    private int numOfTabs;

    public CategoriesPageAdapter(FragmentManager fm, int numOfTabs) {
        super(fm);
        this.numOfTabs=numOfTabs;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new MpesaFragment();
            case 1:
                return new PlansFragment();
            case 2:
                return new ServicesFragment();
            case 3:
                return new InternetFragment();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return numOfTabs;
    }
}
