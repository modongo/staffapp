package com.staff.staffapp.faq.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;
import com.staff.staffapp.R;

public class Chest extends AppCompatActivity {
    PDFView chest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chest);

        chest = (PDFView) findViewById(R.id.pdfChest);

        chest.fromAsset("Chest.pdf").load();
    }
}
