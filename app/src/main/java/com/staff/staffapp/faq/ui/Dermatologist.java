package com.staff.staffapp.faq.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;
import com.staff.staffapp.R;

public class Dermatologist extends AppCompatActivity {
    PDFView dermatologist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dermatologist);

        dermatologist = (PDFView) findViewById(R.id.pdfDermatologist);

        dermatologist.fromAsset("Dermatologist.pdf").load();
    }
}
