package com.staff.staffapp.faq.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;
import com.staff.staffapp.R;

public class Radiology extends AppCompatActivity {
    PDFView radiology;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radiology);

        radiology = (PDFView) findViewById(R.id.pdfRadiology);

        radiology.fromAsset("medical-Radiology.pdf").load();
    }
}
