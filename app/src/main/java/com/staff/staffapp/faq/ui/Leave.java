package com.staff.staffapp.faq.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.MenuItem;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.staff.staffapp.R;
import com.staff.staffapp.faq.adapter.ExpandableListAdapterLeave;
import com.staff.staffapp.faq.model.LeaveDay;
import com.staff.staffapp.faq.service.LeaveDaysServiceApi;
import com.staff.staffapp.MainActivity;

import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Leave extends AppCompatActivity {

    private ExpandableListView listView;
    private ExpandableListAdapterLeave listAdapter;
    private List<String> listDataHeader;
    private HashMap<String, List<String>> listHash;
    private List<LeaveDay> leaveDays;
    private List<String> listType;
    //    private List<String> listStaff;
    private List<Integer> listEntitled;
    private List<Integer> listCarryover;
    private List<Integer> listTaken;
    private List<Integer> listBalance;
    private ProgressBar progressBarLeave;


    private TextView textViewLeave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leave);

        init();

        progressBarLeave.setVisibility(View.VISIBLE);

        new Handler().postDelayed(new Runnable(){

            @Override
            public void run() {
                progressBarLeave.setVisibility(View.GONE);
            }
        }, 500);


        textViewLeave = findViewById(R.id.text_view_Leave);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://gentle-lake-86049.herokuapp.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        LeaveDaysServiceApi leaveDaysServiceApi = retrofit.create(LeaveDaysServiceApi.class);

        Call<List<LeaveDay>> call = leaveDaysServiceApi.getLeaveDays();

        call.enqueue(new Callback<List<LeaveDay>>() {

            @Override
            public void onResponse(Call<List<LeaveDay>> call, Response<List<LeaveDay>> response) {
                if(!response.isSuccessful()){

                    textViewLeave.setText("Code: " + response.code());
                    return;
                }

                List<LeaveDay> leaveDays = response.body();

                for(LeaveDay leaveDay : leaveDays){
                    String content = "";

                    content += "Type: " + leaveDay.getType() + "\n";
                    content += "Entitled: " + leaveDay.getEntitled() + "\n";
                    content += "Carryover: " + leaveDay.getCarryover() + "\n";
                    content += "Taken: " + leaveDay.getTaken() + "\n";
                    content += "Balance: " + leaveDay.getBalance() + "\n\n";

                    textViewLeave.append(content);
                }

            }

            @Override
            public void onFailure(Call<List<LeaveDay>> call, Throwable t) {
                textViewLeave.setText(t.getMessage());
            }
        });



        BottomNavigationView bottomNav = (BottomNavigationView) findViewById(R.id.bottomNav);
        bottomNav.setOnNavigationItemSelectedListener(navListener);
    }

    private void init() {
        this.progressBarLeave = findViewById(R.id.progressBarLeave);
    }




    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                    Intent i;

                    switch(menuItem.getItemId()){
                        case R.id.nav_home: i = new Intent(Leave.this, MainActivity.class); startActivity(i); break;
                        case R.id.back: i = new Intent(Leave.this, FAQ.class); startActivity(i); break;
                    }
                    return true;
                }
            };
}