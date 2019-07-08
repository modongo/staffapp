package com.staff.staffapp.faq.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;
import com.staff.staffapp.R;

public class North extends AppCompatActivity {
    PDFView north;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_north);

        north = (PDFView) findViewById(R.id.pdfNorth);

        north.fromAsset("medical-NorthEastern.pdf").load();
    }
}
