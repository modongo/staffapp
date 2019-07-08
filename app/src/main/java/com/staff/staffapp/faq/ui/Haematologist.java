package com.staff.staffapp.faq.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;
import com.staff.staffapp.R;

public class Haematologist extends AppCompatActivity {
    PDFView haematology;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_haematologist);

        haematology = (PDFView) findViewById(R.id.pdfHaematology);

        haematology.fromAsset("Haematologist.pdf").load();
    }
}
