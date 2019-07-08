package com.staff.staffapp.faq.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;
import com.staff.staffapp.R;

public class Physiotherapy extends AppCompatActivity {
    PDFView physiotherapy;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_physiotherapy);

        physiotherapy = (PDFView) findViewById(R.id.pdfPhysiotherapy);

        physiotherapy.fromAsset("medical-Physiotherapy.pdf").load();
    }
}
