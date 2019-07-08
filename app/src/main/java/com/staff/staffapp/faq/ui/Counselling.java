package com.staff.staffapp.faq.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;
import com.staff.staffapp.R;

public class Counselling extends AppCompatActivity {
    PDFView counselling;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_counselling);

        counselling = (PDFView) findViewById(R.id.pdfCounselling);

        counselling.fromAsset("Counselling.pdf").load();
    }
}
