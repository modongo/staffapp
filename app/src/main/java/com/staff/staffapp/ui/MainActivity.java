package com.staff.staffapp.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.staff.staffapp.Constants;
import com.staff.staffapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;

import com.staff.staffapp.login.LoginActivity;
import com.staff.staffapp.school.ui.BusinessSchool;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private CardView mFAQButton;
    CardView mViewProductsButton;
    CardView btn;
    @BindView(R.id.newsActivityButton)CardView mNewsActivityButton;
    private CardView mChatButton;
    @BindView(R.id.profile_image)ImageView profile_image;
    @BindView(R.id.staff_name)TextView staffName;
    @BindView(R.id.jobDescription)TextView jobdescription;
//    @BindView(R.id.emailAddress)TextView dateOfpasswordExpiry;
    @BindView(R.id.clearCache)Button signout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
        btn = findViewById(R.id.button);

        staffName.setText(getIntent().getStringExtra("Given Name"));
        jobdescription.setText(getIntent().getStringExtra("Family Name"));
        signout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, BusinessSchool.class));
            }
        });

        mFAQButton = (CardView) findViewById(R.id.faq_button);

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

        mChatButton = (CardView) findViewById(R.id.chatButton);
        mChatButton.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ListActivity.class);
                startActivity(intent);
            }

        });
        mViewProductsButton = (CardView) findViewById(R.id.viewProductsButton);
        mViewProductsButton.setOnClickListener(this);

        Picasso.get().load(Constants.IMAGE_URL).into(profile_image);
    }

    @Override
    public void onClick(View view) {
        if (view == mViewProductsButton) {
            Intent intent = new Intent(MainActivity.this, ProductLandingActivity.class);
            startActivity(intent);
        }
    }

    
}
