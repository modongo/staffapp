package com.staff.staffapp.faq.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;
import com.staff.staffapp.R;

public class Opthalmologist extends AppCompatActivity {
    PDFView opthalmologist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opthalmologist);

        opthalmologist = (PDFView) findViewById(R.id.pdfOpthalmologist);

        opthalmologist.fromAsset("Opthamologist.pdf").load();
    }
}
