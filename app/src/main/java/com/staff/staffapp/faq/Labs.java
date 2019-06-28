package com.staff.staffapp.faq;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;
import com.staff.staffapp.R;

public class Labs extends AppCompatActivity {
    PDFView labs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_labs);

        labs = (PDFView) findViewById(R.id.pdfLabs);

        labs.fromAsset("medical-Labs.pdf").load();

    }
}
