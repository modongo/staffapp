package com.staff.staffapp.school.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;
import com.staff.staffapp.R;

public class CyberSecActivity extends AppCompatActivity {
    PDFView cyber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cyber_sec);

        cyber = (PDFView) findViewById(R.id.pdfCyber);

        cyber.fromAsset("cyber.pdf").load();
    }
}
