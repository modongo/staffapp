package com.staff.staffapp.school.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;
import com.staff.staffapp.R;

public class FinanceActivity extends AppCompatActivity {
    PDFView finance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finance);

       finance = (PDFView) findViewById(R.id.pdfFinance);

        finance.fromAsset("finance.pdf").load();
    }
}
