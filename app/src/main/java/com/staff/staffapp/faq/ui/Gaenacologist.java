package com.staff.staffapp.faq.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;
import com.staff.staffapp.R;

public class Gaenacologist extends AppCompatActivity {
    PDFView gaenacology;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gaenacologist);

        gaenacology = (PDFView) findViewById(R.id.pdfGaenacology);

        gaenacology.fromAsset("Gynae.pdf").load();
    }
}
