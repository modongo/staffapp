package com.staff.staffapp.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.staff.staffapp.R;
import com.staff.staffapp.model.Product;
import com.staff.staffapp.service.ProductsService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class ProductsSearchActivity extends AppCompatActivity {
    private List<Product> products;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_products_search);


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

                ProductsSearchActivity.this.runOnUiThread(new Runnable() {

                    @Override
                    public void run() {
                        mAdapter = new RestaurantListAdapter(getApplicationContext(), mRestaurants);
                        mRecyclerView.setAdapter(mAdapter);
                        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(RestaurantListActivity.this);
                        mRecyclerView.setLayoutManager(layoutManager);
                        mRecyclerView.setHasFixedSize(true);
                    }
                });
            }
        });
    }
}
