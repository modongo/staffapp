package com.staff.staffapp.news.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.ProgressBar;

import com.staff.staffapp.R;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NewsDetailsActivity extends AppCompatActivity {
    WebView webView_newsdetails;
    ProgressBar loader_newsdetails;
    String url = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_details);


    Intent intent = getIntent();
    url = intent.getStringExtra("url");
    loader_newsdetails = (ProgressBar) findViewById(R.id.loader_newsdetails);
    webView_newsdetails = (WebView) findViewById(R.id.webView_newsdetails);
    webView_newsdetails.getSettings().setBuiltInZoomControls(true);
    webView_newsdetails.getSettings().setDisplayZoomControls(false);
    webView_newsdetails.loadUrl(url);

    webView_newsdetails.setWebChromeClient(new WebChromeClient() {
       public void onProgressChanged(WebView view, int progress) {
           if (progress == 100) {
               loader_newsdetails.setVisibility(View.GONE);

           } else {
               loader_newsdetails.setVisibility(View.VISIBLE);
           }
        }
    });



    }

}
