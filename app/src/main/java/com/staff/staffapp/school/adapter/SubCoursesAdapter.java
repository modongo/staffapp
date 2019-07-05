package com.staff.staffapp.school.adapter;

import android.content.Intent;
import android.text.method.LinkMovementMethod;
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


    public SubCoursesAdapter(List<SubCourse> dataList){
        this.dataList = dataList;

    }
    @NonNull
    @Override
    public SubCoursesAdapter.SubCoursesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.card_subcourses_item, parent,false);
        return new SubCoursesViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull SubCoursesAdapter.SubCoursesViewHolder holder, int position) {

//        holder.txtCourseId.setText(String.valueOf(dataList.get(position).getCourseId() ));
        holder.txtCourseName.setText(dataList.get(position).getCourse_name());
        holder.txtCourseTitle.setText(dataList.get(position).getCourseTitle());
        holder.txtCourseUrl.setText(dataList.get(position).getContentUrl());
    }
    @Override
    public int getItemCount() {
        return dataList.size();
    }


    public class SubCoursesViewHolder extends RecyclerView.ViewHolder{
        TextView txtCourseName, txtCourseTitle, txtCourseUrl;
        CardView cardView;

        private SubCoursesViewHolder(View itemView ){
            super(itemView);
            txtCourseName = itemView.findViewById(R.id.courseId);
            txtCourseTitle = itemView.findViewById(R.id.courseTitle);
            txtCourseUrl = itemView.findViewById(R.id.courseUrl);
            txtCourseUrl.setMovementMethod(LinkMovementMethod.getInstance());
            cardView = itemView.findViewById(R.id.cardviewContent);

        }
    }

}
