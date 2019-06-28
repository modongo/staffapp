package com.staff.staffapp.faq;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;
import com.staff.staffapp.R;

public class Central extends AppCompatActivity {
    PDFView central;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_central);

        central = (PDFView) findViewById(R.id.pdfCentral);

        central.fromAsset("medical-central.pdf").load();

    }
}
