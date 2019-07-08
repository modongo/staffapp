package com.staff.staffapp.faq.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;
import com.staff.staffapp.R;

public class GeneralSurgeon extends AppCompatActivity {
    PDFView general;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_general_surgeon);

        general = (PDFView) findViewById(R.id.pdfGeneral);

        general.fromAsset("General Surgeon.pdf").load();
    }
}
