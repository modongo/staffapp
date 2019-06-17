package com.staff.staffapp;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class BusinessFragment extends Fragment {

    View view;

    public BusinessFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_business, container, false);
        ArrayList<String> data = new ArrayList<>();

        data.add("Plans");
        data.add("Data");
        data.add("MPESA");
        data.add("LNM");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                getContext(),
                android.R.layout.simple_list_item_1,
                data);

        ListView lvData = (ListView) view.findViewById(R.id.lvData);
        lvData.setAdapter(adapter);
        // Inflate the layout for this fragment

        return view;



    }
    }
