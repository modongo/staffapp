package com.staff.staffapp.faq.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;
import com.staff.staffapp.R;

public class Psychiatrist extends AppCompatActivity {
    PDFView psychiatrist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_psychiatrist);

        psychiatrist = (PDFView) findViewById(R.id.pdfPsychiatrist);

        psychiatrist.fromAsset("Psychiatrist.pdf").load();
    }
}
