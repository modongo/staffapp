package com.staff.staffapp.school.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.TextView;
import android.widget.Toast;

import com.staff.staffapp.R;
import com.staff.staffapp.school.adapter.SubCoursesAdapter;
import com.staff.staffapp.school.model.RetrofitInstance;
import com.staff.staffapp.school.model.SubCourse;
import com.staff.staffapp.school.service.GetSubCoursesList;

import java.io.Serializable;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DataScienceActivity extends AppCompatActivity implements SubCoursesAdapter.OnContentListener {

    private SubCoursesAdapter adapter;
    private RecyclerView recyclerView;
    private List<SubCourse> subCourses;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_science);
        ButterKnife.bind(this);
        GetSubCoursesList service = RetrofitInstance.getRetrofitInstance().create(GetSubCoursesList.class);
        Call<List<SubCourse>> call = service.getAllTitles();
        Log.wtf("URL Called", call.request().url() + "");

    call.enqueue(new Callback<List<SubCourse>>() {
        @Override
        public void onResponse(Call<List<SubCourse>> call, Response<List<SubCourse>> response) {
            Log.d("Test", response.body().toString());
            generateSubCourseList(response.body());
        }

        @Override
        public void onFailure(Call<List<SubCourse>>call, Throwable t) {
            Toast.makeText(DataScienceActivity.this, "Something went wrong......Please try again later", Toast.LENGTH_SHORT).show();
            Log.d("Test", t.toString());

        }
    });

    }

    private void generateSubCourseList(List<SubCourse> subCoursesdata){
        recyclerView = findViewById(R.id.resultsView);
        adapter = new SubCoursesAdapter(subCoursesdata);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(DataScienceActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onItemClick(int position) {
        subCourses.get(position);
        Intent intent = new Intent(DataScienceActivity.this, ViewContentActivity.class);
        intent.putExtra("uri",subCourses.size());
        startActivity(intent);

    }
}
