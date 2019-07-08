package com.staff.staffapp.faq.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;
import com.staff.staffapp.R;

public class Cardiologist extends AppCompatActivity {
    PDFView cardiologist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cardiologist);

        cardiologist = (PDFView) findViewById(R.id.pdfCardiologist);

        cardiologist.fromAsset("Cardiology.pdf").load();
    }
}
