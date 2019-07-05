package com.staff.staffapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;

import com.staff.staffapp.school.ui.BusinessSchoolActivity;

public class MainActivity extends AppCompatActivity{

    @BindView(R.id.profile_image)ImageView imageView;
    @BindView(R.id.staff_name)TextView staffName;
    @BindView(R.id.jobDescription)TextView jobdescription;
    @BindView(R.id.clearCache)Button signout;
    @BindView(R.id.eClassBtn)CardView eClass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        imageView = findViewById(R.id.profile_image);
        staffName.setText(getIntent().getStringExtra("Given Name"));
        jobdescription.setText(getIntent().getStringExtra("Family Name"));
        signout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);

            }
        });
        eClass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, BusinessSchoolActivity.class);
                startActivity(intent);

            }
        });

    }

}
