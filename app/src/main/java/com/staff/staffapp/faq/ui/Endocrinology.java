package com.staff.staffapp.faq.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;
import com.staff.staffapp.R;

public class Endocrinology extends AppCompatActivity {
    PDFView endocrinology;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_endocrinology);

        endocrinology = (PDFView) findViewById(R.id.pdfEndocrinology);

        endocrinology.fromAsset("Endocrinologist.pdf").load();
    }
}
