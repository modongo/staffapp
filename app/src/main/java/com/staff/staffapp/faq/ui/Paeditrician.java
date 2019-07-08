package com.staff.staffapp.faq.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;
import com.staff.staffapp.R;

public class Paeditrician extends AppCompatActivity {
    PDFView paeditrician;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paeditrician);

        paeditrician = (PDFView) findViewById(R.id.pdfPaeditrician);

        paeditrician.fromAsset("Paeditrician.pdf").load();
    }
}
