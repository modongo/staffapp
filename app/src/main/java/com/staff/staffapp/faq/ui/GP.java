package com.staff.staffapp.faq.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;
import com.staff.staffapp.R;

public class GP extends AppCompatActivity {
    PDFView gp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gp);

        gp = (PDFView) findViewById(R.id.pdfGP);

        gp.fromAsset("GP.pdf").load();
    }
}
