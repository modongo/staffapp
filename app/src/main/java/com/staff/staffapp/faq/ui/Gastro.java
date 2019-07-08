package com.staff.staffapp.faq.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;
import com.staff.staffapp.R;

public class Gastro extends AppCompatActivity {
    PDFView gastro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gastro);

        gastro = (PDFView) findViewById(R.id.pdfGastro);

        gastro.fromAsset("Gastro.pdf").load();

    }
}
