package com.staff.staffapp.faq.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;
import com.staff.staffapp.R;

public class Dentist extends AppCompatActivity {
    PDFView dentist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dentist);

        dentist = (PDFView) findViewById(R.id.pdfDentist);

        dentist.fromAsset("Dentists.pdf").load();
    }
}
