package com.staff.staffapp.school;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;
import com.staff.staffapp.R;

public class ItilActivity extends AppCompatActivity {
    PDFView itil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_itil);

        itil = (PDFView) findViewById(R.id.pdfItil);

        itil.fromAsset("itil.pdf").load();
    }
}
