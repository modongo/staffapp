package com.staff.staffapp.faq;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.widget.ExpandableListView;

import com.staff.staffapp.adapter.ExpandableListAdapterProducts;
import com.staff.staffapp.R;
import com.staff.staffapp.model.Product;
import com.staff.staffapp.service.ProductsService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class BusinessProductsActivity extends AppCompatActivity {

    private ExpandableListAdapterProducts listAdapter;
    private List<String> listDataHeader;
    private HashMap<String,List<String>> listHash;
    private List<Product> products;
    @BindView(R.id.lvExpandable) ExpandableListView listView;
    @BindView(R.id.toolbar) Toolbar toolbar;
    private List<String> listDescription;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_business_products);
        ButterKnife.bind(this);

        getProducts();
        toolbar.setTitle(getResources().getString(R.string.toolbar_title_business));
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void getProducts(){
        final ProductsService productsService=new ProductsService();
        productsService.getBusinessProducts(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                products=new ArrayList<>();
                products = productsService.processResaults(response);
                BusinessProductsActivity.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        listDataHeader=new ArrayList<>();
                        listHash=new HashMap<>();
                        listDescription=new ArrayList<>();

                        for(Product product: products){
                            listDataHeader.add(product.getTitle());
                            listDescription.add(product.getDescription());
                            listHash.put(product.getTitle(),listDescription);
                            listDescription=new ArrayList<>();
                        }
                        listAdapter=new ExpandableListAdapterProducts(getApplicationContext(),listDataHeader,listHash);
                        listView.setAdapter(listAdapter);
                    }
                });
            }
        });
    }
}
