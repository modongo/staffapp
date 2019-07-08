package com.staff.staffapp.chat.adapter;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.staff.staffapp.chat.ui.ChatContactFragment;
import com.staff.staffapp.chat.ui.ChatFragment;
import com.staff.staffapp.chat.ui.ChatGroupsFragment;
import com.staff.staffapp.chat.ui.ChatRequestFragment;

public class ChatTabsAccessorAdapter extends FragmentPagerAdapter {

    public ChatTabsAccessorAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {

        switch (i) {
            case 0:
                return new ChatFragment();

            case 1:
                return new ChatGroupsFragment();

            case 2:
                return new ChatContactFragment();
            case 3:
                return new ChatRequestFragment();

            default:
                return null;
        }
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "Chats";

            case 1:
                return "Groups";

            case 2:
                return "Contacts";

            case 3:
                return "Requests";


            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return 4;
    }
}