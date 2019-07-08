package com.staff.staffapp.faq.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;
import com.staff.staffapp.R;

public class Nephrology extends AppCompatActivity {
    PDFView nephrology;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nephrology);

        nephrology = (PDFView) findViewById(R.id.pdfNephrology);

        nephrology.fromAsset("Nephrologist.pdf").load();
    }
}
