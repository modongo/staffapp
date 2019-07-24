package com.staff.staffapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

import com.staff.staffapp.chat.ui.ChatJoinActivity;
import com.staff.staffapp.faq.ui.Emergency;
import com.staff.staffapp.faq.ui.FAQ;
import com.staff.staffapp.school.ui.BusinessSchoolActivity;
import com.staff.staffapp.chat.ui.ListActivity;
import com.staff.staffapp.news.ui.NewsActivity;
import com.staff.staffapp.pns.ui.ProductLandingActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @BindView(R.id.profile_image)
    ImageView imageView;
    @BindView(R.id.staff_name)
    TextView staffName;
    @BindView(R.id.jobDescription)
    TextView jobdescription;
    @BindView(R.id.eClassBtn)
    CardView eClass;
    @BindView(R.id.newsActivityButton)
    CardView mNewsActivityButton;
    @BindView(R.id.support_card)
    CardView supportButton;
    private CardView mChatButton;
    private CardView mFAQButton;
    CardView mViewProductsButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        imageView = findViewById(R.id.profile_image);
        staffName.setText(getIntent().getStringExtra("Given Name"));
        jobdescription.setText(getIntent().getStringExtra("expiry"));
        eClass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, BusinessSchoolActivity.class));
            }
        });

        supportButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Emergency.class));
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
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, NewsActivity.class);
                startActivity(intent);
            }
        });

        mChatButton = (CardView) findViewById(R.id.chatButton);
        mChatButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ChatJoinActivity.class);
                startActivity(intent);
            }

        });

        mViewProductsButton = (CardView) findViewById(R.id.viewProductsButton);
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
