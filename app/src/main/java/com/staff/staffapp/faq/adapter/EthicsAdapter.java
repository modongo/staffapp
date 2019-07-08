package com.staff.staffapp.faq.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.staff.staffapp.R;

import java.util.ArrayList;

public class EthicsAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<Integer> imageIds;
    private ArrayList<String> descriptionList;

    public EthicsAdapter(Context context, ArrayList<Integer> imageIds, ArrayList<String> descriptionList) {
        this.context = context;
        this.imageIds = imageIds;
        this.descriptionList = descriptionList;
    }

    @Override
    public int getCount() {
        return descriptionList.size();
    }

    @Override
    public Object getItem(int i) {
        return descriptionList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        if(view == null){

            view = View.inflate(context, R.layout.ethics_list, null);
        }

        ImageView images = (ImageView) view.findViewById(R.id.imageView);
        TextView text = (TextView) view.findViewById(R.id.textView);

        images.setImageResource(imageIds.get(i));
        text.setText(descriptionList.get(i));


        return view;
    }
}
