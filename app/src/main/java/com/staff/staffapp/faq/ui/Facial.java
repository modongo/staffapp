package com.staff.staffapp.faq.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;
import com.staff.staffapp.R;

public class Facial extends AppCompatActivity {
    PDFView facial;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_facial);


        facial = (PDFView) findViewById(R.id.pdfFacial);

        facial.fromAsset("Facial.pdf").load();
    }
}
