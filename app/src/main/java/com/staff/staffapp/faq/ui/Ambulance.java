package com.staff.staffapp.faq.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;
import com.staff.staffapp.R;

public class Ambulance extends AppCompatActivity {
    PDFView ambulance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ambulance);

        ambulance = (PDFView) findViewById(R.id.pdfAmbulance);

        ambulance.fromAsset("medical-Ambulance.pdf").load();
    }
}
