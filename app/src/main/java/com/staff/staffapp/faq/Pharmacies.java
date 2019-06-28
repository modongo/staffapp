package com.staff.staffapp.faq;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;
import com.staff.staffapp.R;

public class Pharmacies extends AppCompatActivity {
    PDFView pharmacies;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pharmacies);

        pharmacies = (PDFView) findViewById(R.id.pdfPharmacies);

        pharmacies.fromAsset("medical-Pharmacies.pdf").load();

    }
}
