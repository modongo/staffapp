package com.staff.staffapp.pns.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.core.view.MenuItemCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.GridLayout;
import android.widget.Toast;

import com.staff.staffapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ProductLandingActivity extends AppCompatActivity {
    @BindView(R.id.mainGrid) GridLayout gridLayout;
    @BindView(R.id.toolbar) Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_landing);
        ButterKnife.bind(this);

        toolbar.setTitle(getResources().getString(R.string.toolbar_title));
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        setSingleEvent(gridLayout);
    }

    private void setSingleEvent(GridLayout gridLayout) {
        for(int i = 0; i<gridLayout.getChildCount();i++){
            CardView cardView=(CardView)gridLayout.getChildAt(i);
            final int finalI= i;
            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(finalI==0){
                        Intent intent=new Intent(ProductLandingActivity.this, AllProductsActivity.class);
                        startActivity(intent);
                    }
                    if(finalI==1){
                        Intent intent=new Intent(ProductLandingActivity.this, MpesaActivity.class);
                        startActivity(intent);
                    }
                    if(finalI==2){
                        Intent intent=new Intent(ProductLandingActivity.this, PlansActivity.class);
                        startActivity(intent);
                    }
                    if(finalI==3){
                        Intent intent=new Intent(ProductLandingActivity.this, ServicesActivity.class);
                        startActivity(intent);
                    }
                    if(finalI==4){
                        Intent intent=new Intent(ProductLandingActivity.this, InternetActivity.class);
                        startActivity(intent);
                    }
                    if(finalI==5){

                    }
                }
            });
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.menu_search_knowledgebase, menu);
        ButterKnife.bind(this);

        MenuItem menuItem=menu.findItem(R.id.knowledge_search);
        SearchView searchView=(SearchView) MenuItemCompat.getActionView(menuItem);
        searchView.setQueryHint("Search prosucts");
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                if (query.equals("")){
                    Toast.makeText(ProductLandingActivity.this,"You must enter a value to search",Toast.LENGTH_LONG).show();
                }else{
                    Intent intent=new Intent(ProductLandingActivity.this, ProductsSearchActivity.class);
                    intent.putExtra("query",query);
                    startActivity(intent);
                }
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }
}
