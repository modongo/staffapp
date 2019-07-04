package com.staff.staffapp.school.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;
import com.staff.staffapp.R;

public class ManagementActivity extends AppCompatActivity {
    PDFView management;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_management);

        management = (PDFView) findViewById(R.id.pdfManagement);

        management.fromAsset("management.pdf").load();
    }
}
