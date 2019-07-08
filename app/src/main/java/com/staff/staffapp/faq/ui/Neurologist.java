package com.staff.staffapp.faq.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;
import com.staff.staffapp.R;

public class Neurologist extends AppCompatActivity {
    PDFView neurology;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_neurologist);

        neurology = (PDFView) findViewById(R.id.pdfNeurology);

        neurology.fromAsset("Neurology.pdf").load();
    }
}
