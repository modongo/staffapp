package com.staff.staffapp.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

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

public class ProductsSearchActivity extends AppCompatActivity {
    public static final String TAG = ProductsSearchActivity.class.getSimpleName();
    private List<Product> products;
    private ProductsListAdapter mAdapter;
    @BindView(R.id.recyclerView) RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_products_search);
        ButterKnife.bind(this);

        Intent intent=getIntent();
        String query = intent.getStringExtra("query");

        getSearchResults(query);
    }

    private void getSearchResults(String query) {
        final ProductsService productsService=new ProductsService();
        productsService.searchPersonalProducts(query,new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                products=new ArrayList<>();
                products = productsService.processResaults(response);
                Log.d(TAG, "onResponse:" + products);

                ProductsSearchActivity.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        mAdapter = new ProductsListAdapter(getApplicationContext(), products);
                        mRecyclerView.setAdapter(mAdapter);
                        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(ProductsSearchActivity.this);
                        mRecyclerView.setLayoutManager(layoutManager);
                        mRecyclerView.setHasFixedSize(true);
                    }
                });
            }
        });
    }
}
