package com.staff.staffapp.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;
import com.staff.staffapp.R;
import com.staff.staffapp.adapter.CategoriesPageAdapter;
import com.staff.staffapp.adapter.PageAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ProductCategoriesActivity extends AppCompatActivity {
    @BindView(R.id.tabLayout) TabLayout tabLayout;
    @BindView(R.id.viewPager) ViewPager viewPager;
    CategoriesPageAdapter pageAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_categories);
        ButterKnife.bind(this);

        tabLayout.addTab(tabLayout.newTab().setText("M-PESA"));
        tabLayout.addTab(tabLayout.newTab().setText("PLANS"));
        tabLayout.addTab(tabLayout.newTab().setText("SERVICES"));
        tabLayout.addTab(tabLayout.newTab().setText("INTERNET"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        pageAdapter=new CategoriesPageAdapter(getSupportFragmentManager(),tabLayout.getTabCount());
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
    }
}
