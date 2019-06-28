package com.staff.staffapp.faq;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.appbar.AppBarLayout;
import com.staff.staffapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ProductsActivity extends AppCompatActivity implements View.OnClickListener {

    @BindView(R.id.appbarId) AppBarLayout mProductsAppbar;
    @BindView(R.id.cardviewBusiness) CardView mBusinessCv;
    @BindView(R.id.cardviewPersonal) CardView mPersonalCv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_products);
        ButterKnife.bind(this);

        mBusinessCv.setOnClickListener(this);
        mPersonalCv.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view==mBusinessCv){
            Intent intent=new Intent(ProductsActivity.this, BusinessProductsActivity.class);
            startActivity(intent);
        }
        if(view==mPersonalCv){
            Intent intent=new Intent(ProductsActivity.this,PersonalProductsActivity.class);
            startActivity(intent);
        }
    }
}
