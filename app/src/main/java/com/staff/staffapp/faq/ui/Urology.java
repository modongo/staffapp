package com.staff.staffapp.faq.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;
import com.staff.staffapp.R;

public class Urology extends AppCompatActivity {
    PDFView urology;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_urology);

        urology = (PDFView) findViewById(R.id.pdfUrology);

        urology.fromAsset("Urologist.pdf").load();
    }
}
