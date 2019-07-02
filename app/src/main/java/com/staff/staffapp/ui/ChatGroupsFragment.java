package com.staff.staffapp.ui;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.staff.staffapp.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ChatGroupsFragment extends Fragment {


    public ChatGroupsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_chat_groups, container, false);
    }

}
