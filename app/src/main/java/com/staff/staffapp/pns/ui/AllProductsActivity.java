package com.staff.staffapp.pns.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;
import com.staff.staffapp.pns.adapter.PageAdapter;
import com.staff.staffapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AllProductsActivity extends AppCompatActivity {

//    @BindView(R.id.toolbar) Toolbar toolbar;
    @BindView(R.id.tabLayout) TabLayout tabLayout;
    @BindView(R.id.viewPager) ViewPager viewPager;
    @BindView(R.id.toolbar) Toolbar toolbar;
    PageAdapter pageAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_products);

        ButterKnife.bind(this);

        tabLayout.addTab(tabLayout.newTab().setText("Consumer"));
        tabLayout.addTab(tabLayout.newTab().setText("Enterprise"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        toolbar.setTitle("All Products and Services");

        pageAdapter=new PageAdapter(getSupportFragmentManager(),tabLayout.getTabCount());
        viewPager.setAdapter(pageAdapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }
            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }
            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
//        toolbar.setTitle(getResources().getString(R.string.toolbar_title));
//        setSupportActionBar(toolbar);
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu){
//        MenuInflater inflater=getMenuInflater();
//        inflater.inflate(R.menu.menu_search_knowledgebase, menu);
//        ButterKnife.bind(this);
//
//        MenuItem menuItem=menu.findItem(R.id.knowledge_search);
//        SearchView searchView=(SearchView) MenuItemCompat.getActionView(menuItem);
//        searchView.setQueryHint("Search prosucts");
//        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
//            @Override
//            public boolean onQueryTextSubmit(String query) {
//                if (query.equals("")){
//                    Toast.makeText(AllProductsActivity.this,"You must enter a value to search",Toast.LENGTH_LONG).show();
//                }else{
//                    Intent intent=new Intent(AllProductsActivity.this, ProductsSearchActivity.class);
//                    intent.putExtra("query",query);
//                    startActivity(intent);
//                }
//                return false;
//            }
//
//            @Override
//            public boolean onQueryTextChange(String newText) {
//                return false;
//            }
//        });
//
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        return super.onOptionsItemSelected(item);
//    }
}
