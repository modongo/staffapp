package com.staff.staffapp.faq;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;
import com.staff.staffapp.R;

public class Eastern extends AppCompatActivity {
    PDFView eastern;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eastern);

        eastern = (PDFView) findViewById(R.id.pdfEastern);

        eastern.fromAsset("medical-Eastern.pdf").load();
    }
}
