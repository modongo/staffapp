package com.staff.staffapp.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.staff.staffapp.R;
import com.staff.staffapp.adapter.ProductsListAdapter;
import com.staff.staffapp.model.Product;
import com.staff.staffapp.service.ProductsService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

import static android.view.View.GONE;
import static android.view.View.VISIBLE;

public class ServicesActivity extends AppCompatActivity {
    public static final String TAG = ServicesActivity.class.getSimpleName();
    private List<Product> products;
    private ProductsListAdapter mAdapter;
    @BindView(R.id.recyclerView) RecyclerView mRecyclerView;
    @BindView(R.id.toolbar) Toolbar toolbar;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_services);
        ButterKnife.bind(this);

        Intent intent=getIntent();
        String query = intent.getStringExtra("query");
        progressBar=findViewById(R.id.pBar);

        toolbar.setTitle("Services");

        getServices();
    }

    private void getServices() {
        final ProductsService productsService=new ProductsService();
        productsService.getServiceProducts(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                progressBar.setVisibility(VISIBLE);
                products=new ArrayList<>();
                products = productsService.processResaults(response);

                if(products.isEmpty()){
                    ServicesActivity.this.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            mRecyclerView.setVisibility(GONE);
                            progressBar.setVisibility(GONE);
                        }
                    });
                }else{
                    ServicesActivity.this.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            mAdapter = new ProductsListAdapter(getApplicationContext(), products);
                            mRecyclerView.setAdapter(mAdapter);
                            RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(ServicesActivity.this);
                            mRecyclerView.setLayoutManager(layoutManager);
                            mRecyclerView.setHasFixedSize(true);
                            progressBar.setVisibility(GONE);
                        }
                    });
                }
            }
        });
    }
}
