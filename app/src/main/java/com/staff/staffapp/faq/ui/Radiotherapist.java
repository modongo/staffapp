package com.staff.staffapp.faq.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;
import com.staff.staffapp.R;

public class Radiotherapist extends AppCompatActivity {

    PDFView radio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radiotherapist);

        radio = (PDFView) findViewById(R.id.pdfRadiotherapist);

        radio.fromAsset("Radiotherapist.pdf").load();
    }
}
