package com.staff.staffapp.faq.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;
import com.staff.staffapp.R;

public class Orthopedic extends AppCompatActivity {
    PDFView orthopedic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orthopedic);

        orthopedic = (PDFView) findViewById(R.id.pdfOrthopedic);

        orthopedic.fromAsset("Orthopedic.pdf").load();
    }
}
