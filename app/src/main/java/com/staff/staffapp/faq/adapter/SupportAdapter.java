package com.staff.staffapp.faq.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.staff.staffapp.R;
import com.staff.staffapp.faq.model.SupportMedical;

import java.util.List;

public class SupportAdapter extends RecyclerView.Adapter<SupportAdapter.SupportViewHolder> {

    private List<SupportMedical> supportMedicals;
    private Context context;
    private OnSupportListener  onSupportListener;


    public SupportAdapter(List<SupportMedical> supportMedicals, Context context, OnSupportListener  onSupportListener){
        this.supportMedicals = supportMedicals;
        this.context = context;
        this.onSupportListener = onSupportListener;
    }


    @NonNull
    @Override
    public SupportViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.support_services, null);
        return new SupportViewHolder(view, onSupportListener);

    }

    @Override
    public void onBindViewHolder(@NonNull SupportViewHolder holder, int position) {
        SupportMedical supportMedical = supportMedicals.get(position);
        holder.title.setText(supportMedical.getTitle());
        holder.supportImage.setImageDrawable(context.getResources().getDrawable(supportMedical.getImage(), null));

    }

    @Override
    public int getItemCount() {

        return supportMedicals.size();
    }


    class SupportViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView title;
        ImageView supportImage;

        OnSupportListener  onSupportListener;

        public SupportViewHolder(View itemView, OnSupportListener  onSupportListener){

            super(itemView);

            title = itemView.findViewById(R.id.title);
            supportImage = itemView.findViewById(R.id.supportImage);

            context = itemView.getContext();
            this.onSupportListener = onSupportListener;

            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View view) {
            onSupportListener.onSupportClick(getAdapterPosition());
        }
    }

    public interface OnSupportListener{
        void onSupportClick(int position);
    }
}

