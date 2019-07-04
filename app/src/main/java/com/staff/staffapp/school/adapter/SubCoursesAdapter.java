package com.staff.staffapp.school.adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.staff.staffapp.R;
import com.staff.staffapp.school.model.SubCourse;

import java.util.List;

public class SubCoursesAdapter extends RecyclerView.Adapter<SubCoursesAdapter.SubCoursesViewHolder> {

    private List<SubCourse> dataList;
    private OnContentListener mOnItemClickListener;

    public SubCoursesAdapter(List<SubCourse> dataList, OnContentListener mOnItemClickListener){
        this.dataList = dataList;
        this.mOnItemClickListener= mOnItemClickListener;
    }
    @NonNull
    @Override
    public SubCoursesAdapter.SubCoursesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.card_subcourses_item, parent,false);
        return new SubCoursesViewHolder(view, mOnItemClickListener);
    }
    @Override
    public void onBindViewHolder(@NonNull SubCoursesAdapter.SubCoursesViewHolder holder, int position) {

        holder.txtCourseId.setText(String.valueOf(dataList.get(position).getCourseId() ));
        holder.txtCourseTitle.setText(dataList.get(position).getCourseTitle());
        holder.txtCourseUrl.setText(dataList.get(position).getContentUrl());
    }
    @Override
    public int getItemCount() {
        return dataList.size();
    }


    public class SubCoursesViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView txtCourseId, txtCourseTitle, txtCourseUrl;
        CardView cardView; OnContentListener onContentListener;

        private SubCoursesViewHolder(View itemView, OnContentListener onContentListener ){
            super(itemView);
            txtCourseId = itemView.findViewById(R.id.courseId);
            txtCourseTitle = itemView.findViewById(R.id.courseTitle);
            txtCourseUrl = itemView.findViewById(R.id.courseUrl);
            cardView = itemView.findViewById(R.id.cardviewContent);
            this.onContentListener = onContentListener;
            itemView.setOnClickListener(this);
        }
        @Override
        public void onClick(View view) {
            onContentListener.onItemClick(getAdapterPosition());
        }
    }
    public interface OnContentListener{
        void onItemClick(int position);
    }

}
