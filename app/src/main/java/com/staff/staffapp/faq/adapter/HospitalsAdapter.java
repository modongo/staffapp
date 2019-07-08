package com.staff.staffapp.faq.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.staff.staffapp.R;

import com.staff.staffapp.faq.model.HospitalProvider;

import java.util.List;

public class HospitalsAdapter extends RecyclerView.Adapter<HospitalsAdapter.HospitalViewHolder> {

    private List<HospitalProvider> hospitalProviders;
    private Context context;
    private OnItemListener  onItemListener;

    public HospitalsAdapter(List<HospitalProvider> hospitalProviders, Context context, OnItemListener onItemListener) {
        this.hospitalProviders = hospitalProviders;
        this.context = context;
        this.onItemListener = onItemListener;
    }



    @NonNull
    @Override
    public HospitalViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.hospitals, null);
        return new HospitalViewHolder(view, onItemListener);
    }

    @Override
    public void onBindViewHolder(@NonNull HospitalViewHolder holder, int position) {
        HospitalProvider hospitalProvider = hospitalProviders.get(position);

        holder.title.setText(hospitalProvider.getTitle());

    }

    @Override
    public int getItemCount() {
        return hospitalProviders.size();
    }


    public class HospitalViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView title;
        OnItemListener onItemListener;

        public HospitalViewHolder(View itemView, OnItemListener onItemListener){

            super(itemView);
            context = itemView.getContext();
            title = itemView.findViewById(R.id.title);
            this.onItemListener = onItemListener;

            itemView.setOnClickListener(this);

        }


        @Override
        public void onClick(View view) {
            onItemListener.onItemClick(getAdapterPosition());

        }
    }

    public interface OnItemListener{
        void onItemClick(int position);
    }
}

