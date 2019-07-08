package com.staff.staffapp.faq.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;
import com.staff.staffapp.R;

public class Nyanza extends AppCompatActivity {
    PDFView nyanza;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nyanza);

        nyanza = (PDFView) findViewById(R.id.pdfNyanza);

        nyanza.fromAsset("medical-nyanza.pdf").load();
    }
}
