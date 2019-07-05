package com.staff.staffapp.faq;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;
import com.staff.staffapp.R;

public class Nursing extends AppCompatActivity {
    PDFView nursing;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nursing);

        nursing = (PDFView) findViewById(R.id.pdfNursing);

        nursing.fromAsset("medical-Nursing.pdf").load();

    }
}
