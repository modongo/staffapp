package com.staff.staffapp.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.staff.staffapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;

import com.staff.staffapp.school.BusinessSchool;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button mFAQButton;
    Button mViewProductsButton;
    Button btn;
    @BindView(R.id.newsActivityButton)
    Button mNewsActivityButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn;
        ButterKnife.bind(this);
        btn = findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, BusinessSchool.class));
            }
        });

        mFAQButton = (Button) findViewById(R.id.faq_button);

        mFAQButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, FAQ.class);
                startActivity(intent);
            }
        });

        mNewsActivityButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, NewsActivity.class);
                startActivity(intent);
            }
        });

        mViewProductsButton = (Button) findViewById(R.id.viewProductsButton);
        mViewProductsButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view == mViewProductsButton) {
            Intent intent = new Intent(MainActivity.this, ProductLandingActivity.class);
            startActivity(intent);
        }
    }
}