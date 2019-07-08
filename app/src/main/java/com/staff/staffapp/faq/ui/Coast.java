package com.staff.staffapp.faq.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;
import com.staff.staffapp.R;

public class Coast extends AppCompatActivity {

    PDFView coast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coast);

        coast = (PDFView) findViewById(R.id.pdfCoast);

        coast.fromAsset("medical-coast.pdf").load();
    }
}
