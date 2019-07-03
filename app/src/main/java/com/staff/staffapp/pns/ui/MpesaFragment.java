package com.staff.staffapp.pns.ui;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.staff.staffapp.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class MpesaFragment extends Fragment {


    public MpesaFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_mpesa, container, false);
    }

}
