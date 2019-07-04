package com.staff.staffapp.school.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.staff.staffapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ViewContentActivity extends AppCompatActivity {

    @BindView(R.id.webview)WebView contentWebview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ButterKnife.bind(this);

        String url = getIntent().getStringExtra("uri");
        if(url == null || url.isEmpty()) finish();;
        contentWebview.getSettings().setJavaScriptEnabled(true);
        contentWebview.setWebViewClient(new WebViewClient());
        contentWebview.loadUrl(url);

    }
}
