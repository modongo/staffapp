package com.staff.staffapp.faq.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;
import com.staff.staffapp.R;

public class Overseas extends AppCompatActivity {
    PDFView overseas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_overseas);

        overseas = (PDFView) findViewById(R.id.pdfOverseas);

        overseas.fromAsset("medical-Overseas.pdf").load();

    }
}
