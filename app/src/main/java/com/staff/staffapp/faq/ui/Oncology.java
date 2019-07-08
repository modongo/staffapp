package com.staff.staffapp.faq.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;
import com.staff.staffapp.R;

public class Oncology extends AppCompatActivity {
    PDFView oncology;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oncology);

        oncology = (PDFView) findViewById(R.id.pdfOncology);

        oncology.fromAsset("Oncologist.pdf").load();
    }
}
