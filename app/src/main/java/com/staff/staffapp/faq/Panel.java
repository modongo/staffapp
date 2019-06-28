package com.staff.staffapp.faq;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;
import com.staff.staffapp.R;

public class Panel extends AppCompatActivity {
    PDFView attachment1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_panel);

        attachment1 = (PDFView) findViewById(R.id.pdfAttachment1);

        attachment1.fromAsset("medical-nairobi.pdf").load();
    }
}
