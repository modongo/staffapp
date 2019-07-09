package com.staff.staffapp.school.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.staff.staffapp.LoginActivity;
import com.staff.staffapp.R;
import com.staff.staffapp.school.adapter.SubCoursesAdapter;
import com.staff.staffapp.school.model.RetrofitInstance;
import com.staff.staffapp.school.model.SubCourse;
import com.staff.staffapp.school.service.GetSubCoursesList;
import java.util.List;
import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BusinessSchoolActivity extends AppCompatActivity {

    private List<SubCourse> subCourses;
    @BindView(R.id.contentToolbar)
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_school);
        ButterKnife.bind(this);

        GetSubCoursesList service = RetrofitInstance.getRetrofitInstance().create(GetSubCoursesList.class);
        Call<List<SubCourse>> call = service.getAllTitles();
        final ProgressDialog progressDialog;
        progressDialog = new ProgressDialog(BusinessSchoolActivity.this);
        progressDialog.setMessage("Loading.Please Wait.......");
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);

        // show it
        progressDialog.show();

        Log.d("URL Called", call.request().url() + "");
        toolbar.setTitle("Safaricom eLearning");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        call.enqueue(new Callback<List<SubCourse>>() {

            @Override
            public void onResponse(Call<List<SubCourse>> call, Response<List<SubCourse>> response) {

                Log.d("Test", response.body().toString());
                generateSubCourseList(response.body());
                progressDialog.dismiss();
            }

            @Override
            public void onFailure(Call<List<SubCourse>> call, Throwable t) {
                Toast.makeText(BusinessSchoolActivity.this, "Something went wrong......Please try again later",
                        Toast.LENGTH_SHORT).show();
                Log.d("Test", t.toString());
                progressDialog.dismiss();

            }

        });

    }

    private void generateSubCourseList(List<SubCourse> subCoursesdata) {
        RecyclerView recyclerView = findViewById(R.id.resultsView);
        SubCoursesAdapter adapter = new SubCoursesAdapter(subCoursesdata);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(BusinessSchoolActivity.this, 2);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }
}
