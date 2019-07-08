package com.staff.staffapp.faq.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;
import com.staff.staffapp.R;

public class Nairobi extends AppCompatActivity {
    PDFView nairobi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nairobi);

        nairobi = (PDFView) findViewById(R.id.pdfNairobi);

        nairobi.fromAsset("medical-nairobi.pdf").load();
    }
}
