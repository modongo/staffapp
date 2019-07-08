package com.staff.staffapp.faq.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;
import com.staff.staffapp.R;

public class ENT extends AppCompatActivity {
    PDFView ent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ent);

        ent = (PDFView) findViewById(R.id.pdfENT);

        ent.fromAsset("ENT.pdf").load();
    }
}
