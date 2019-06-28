package com.staff.staffapp.school;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;
import com.staff.staffapp.R;

public class DataScienceActivity extends AppCompatActivity {
    PDFView data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_science);

       data = (PDFView) findViewById(R.id.pdfData);

        data.fromAsset("dataScience.pdf").load();
    }
}
