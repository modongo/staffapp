package com.staff.staffapp.faq.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.staff.staffapp.R;
import com.staff.staffapp.faq.model.SpecialistProvider;

import java.util.List;

public class SpecialistsAdapter extends RecyclerView.Adapter<SpecialistsAdapter.SpecialistViewHolder> {

    private List<SpecialistProvider> specialistProviders;
    private Context context;
    private OnSpecialistListener onSpecialistListener;


    public SpecialistsAdapter(List<SpecialistProvider> specialistProviders, Context context, OnSpecialistListener  onSpecialistListener){
        this.specialistProviders = specialistProviders;
        this.context = context;
        this.onSpecialistListener = onSpecialistListener;
    }


    @NonNull
    @Override
    public SpecialistViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       LayoutInflater inflater = LayoutInflater.from(context);
       View view = inflater.inflate(R.layout.specialists, null);

// The below is the longer version of the return statement
//       SpecialistViewHolder holder = new SpecialistViewHolder(view);
//       return holder;

       return new SpecialistViewHolder(view, onSpecialistListener);
    }

    @Override
    public void onBindViewHolder(@NonNull SpecialistViewHolder holder, int position) {
        SpecialistProvider specialistProvider = specialistProviders.get(position);

        holder.title.setText(specialistProvider.getTitle());
        holder.specialistImage.setImageDrawable(context.getResources().getDrawable(specialistProvider.getImage(), null));
    }

    @Override
    public int getItemCount() {
        return specialistProviders.size();
    }

   class SpecialistViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView title;
        LinearLayout specialistLinearLayout;
        ImageView specialistImage;
        OnSpecialistListener  onSpecialistListener;

        public SpecialistViewHolder(View itemView, OnSpecialistListener  onSpecialistListener){

            super(itemView);

            title = itemView.findViewById(R.id.title);
            specialistLinearLayout = (LinearLayout) itemView.findViewById(R.id.specialistLinearLayout);
            specialistImage = itemView.findViewById(R.id.specialistImage);
            context = itemView.getContext();

            this.onSpecialistListener = onSpecialistListener;

            itemView.setOnClickListener(this);

        }

       @Override
       public void onClick(View view) {
           onSpecialistListener.onSpecialistClick(getAdapterPosition());
       }
   }

    public interface OnSpecialistListener{
        void onSpecialistClick(int position);
    }
}



