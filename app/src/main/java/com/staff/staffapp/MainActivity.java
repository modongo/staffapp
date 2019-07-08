package com.staff.staffapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;

import com.staff.staffapp.faq.ui.FAQ;


public class MainActivity extends AppCompatActivity  {
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


        mFAQButton = (Button) findViewById(R.id.faq_button);

        mFAQButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, FAQ.class);
                startActivity(intent);
            }
        });


    }

}