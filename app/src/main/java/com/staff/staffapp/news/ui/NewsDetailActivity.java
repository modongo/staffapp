package com.staff.staffapp.news.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.bumptech.glide.request.RequestOptions;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.staff.staffapp.R;
import com.staff.staffapp.news.utils.Utils;

public class NewsDetailActivity extends AppCompatActivity implements AppBarLayout.OnOffsetChangedListener{

    private ImageView imageView_NewsDetail;
    private TextView appbar_title_NewsDetail, appbar_subtitle_NewsDetail, date_NewsDetail, time_NewsDetail, title_NewsDetail;
    private boolean isHideToolbarView = false;
    private FrameLayout date_behavior;
    private LinearLayout titleAppbar_NewsDetail;
    private AppBarLayout appBarLayout_NewsDetail;
    private Toolbar toolbar_NewsDetail;
    private String mUrl_NewsDetail, mImg_NewsDetail, mTitle_NewsDetail, mDate_NewsDetail, mSource_NewsDetail, mAuthor_NewsDetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_detail);

        toolbar_NewsDetail = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar_NewsDetail);
        getSupportActionBar().setTitle("");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        final CollapsingToolbarLayout collapsingToolbarLayout_NewsDetail = findViewById(R.id.collapsing_toolbar);
        collapsingToolbarLayout_NewsDetail.setTitle("");

        appBarLayout_NewsDetail = findViewById(R.id.appbar);
        appBarLayout_NewsDetail.addOnOffsetChangedListener(this);
        date_behavior = findViewById(R.id.date_behavior);
        titleAppbar_NewsDetail = findViewById(R.id.title_appbar);
        imageView_NewsDetail = findViewById(R.id.backdrop);
        appbar_title_NewsDetail = findViewById(R.id.title_on_appbar);
        appbar_subtitle_NewsDetail = findViewById(R.id.subtitle_on_appbar);
        date_NewsDetail = findViewById(R.id.date);
        time_NewsDetail = findViewById(R.id.time);
        title_NewsDetail = findViewById(R.id.title);

        Intent intent = getIntent();
        mUrl_NewsDetail = intent.getStringExtra("url");
        mTitle_NewsDetail = intent.getStringExtra("title");
        mImg_NewsDetail = intent.getStringExtra("img");
        mDate_NewsDetail = intent.getStringExtra("date");
        mSource_NewsDetail = intent.getStringExtra("source");
        mAuthor_NewsDetail = intent.getStringExtra("author");

        RequestOptions requestOptions = new RequestOptions();
        requestOptions.error(Utils.getRandomDrawbleColor());

        Glide.with(this)
                .load(mImg_NewsDetail)
                .apply(requestOptions)
                .transition(DrawableTransitionOptions.withCrossFade())
                .into(imageView_NewsDetail);

        appbar_title_NewsDetail.setText(mSource_NewsDetail);
        appbar_subtitle_NewsDetail.setText(mUrl_NewsDetail);
        date_NewsDetail.setText(Utils.DateFormat(mDate_NewsDetail));
        title_NewsDetail.setText(mTitle_NewsDetail);

        String author = null;
        if (mAuthor_NewsDetail != null || mAuthor_NewsDetail != "") {
            mAuthor_NewsDetail = " \u2022 " + mAuthor_NewsDetail;
        } else {
            author = "";
        }

        time_NewsDetail.setText(mSource_NewsDetail + author + " \u2022 " + Utils.DateToTimeFormat(mDate_NewsDetail));

        initWebView(mUrl_NewsDetail);


    }

    private  void initWebView(String url){
        WebView webView_NewsDetail = findViewById(R.id.webView);
        webView_NewsDetail.getSettings().setLoadsImagesAutomatically(true);
        webView_NewsDetail.getSettings().setJavaScriptEnabled(true);
        webView_NewsDetail.getSettings().setDomStorageEnabled(true);
        webView_NewsDetail.getSettings().setSupportZoom(true);
        webView_NewsDetail.getSettings().setBuiltInZoomControls(true);
        webView_NewsDetail.getSettings().setDisplayZoomControls(false);
        webView_NewsDetail.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        webView_NewsDetail.setWebViewClient(new WebViewClient());
        webView_NewsDetail.loadUrl(url);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        supportFinishAfterTransition();
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    @Override
    public void onOffsetChanged(AppBarLayout appBarLayout_NewsDetail, int verticalOffset) {

        int maxScroll = appBarLayout_NewsDetail.getTotalScrollRange();
        float percentage = (float) Math.abs(verticalOffset) / (float) maxScroll;

        if (percentage == 1f && isHideToolbarView) {
            date_behavior.setVisibility(View.GONE);
            titleAppbar_NewsDetail.setVisibility(View.VISIBLE);
            isHideToolbarView = !isHideToolbarView;
        }

        else if (percentage < 1f && isHideToolbarView) {
            date_behavior.setVisibility(View.VISIBLE);
            titleAppbar_NewsDetail.setVisibility(View.GONE);
            isHideToolbarView = !isHideToolbarView;
        }

    }
}