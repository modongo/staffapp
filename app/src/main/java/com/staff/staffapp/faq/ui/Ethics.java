package com.staff.staffapp.faq.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ListView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.staff.staffapp.R;
import com.staff.staffapp.faq.adapter.EthicsAdapter;
import com.staff.staffapp.MainActivity;

import java.util.ArrayList;

public class Ethics extends AppCompatActivity {

    ListView listViewEthics;
    ArrayList<Integer> imageIds;
    ArrayList<String> descriptionList;
    EthicsAdapter ethicsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ethics);
        listViewEthics = (ListView) findViewById(R.id.listViewEthics);
        imageIds = new ArrayList<>();
        descriptionList = new ArrayList<>();
        imageIds = getImageIds();
        descriptionList = getDescriptionList();
        ethicsAdapter = new EthicsAdapter(Ethics.this, imageIds, descriptionList);
        listViewEthics.setAdapter(ethicsAdapter);
//        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                Intent intent = new Intent(Intent.ACTION_DIAL);
//                intent.setData(Uri.parse("tel:" + listHash.get(listDataHeader.get(i)).get(i1)));
//                startActivity(intent);
//
//                return false;
//            }
//        });

        BottomNavigationView bottomNav = (BottomNavigationView) findViewById(R.id.bottomNav);
        bottomNav.setOnNavigationItemSelectedListener(navListener);
    }

    public ArrayList<Integer> getImageIds(){
        imageIds = new ArrayList<>();
        imageIds.add(R.drawable.ic_customer_service);
        imageIds.add(R.drawable.ic_email);
        imageIds.add(R.drawable.ic_letter);
        imageIds.add(R.drawable.ic_stopwatch);

      return imageIds;
    }

    public ArrayList<String> getDescriptionList(){
        descriptionList = new ArrayList<>();
        descriptionList.add("0800 720 009");
        descriptionList.add("safaricom@ethics-line.com");
        descriptionList.add("KZN 138, Umhlanga Rocks, 4320");
        descriptionList.add("24 hours a day, 7 days per week, 365 days per year");

        return descriptionList;

    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                    Intent i;

                    switch(menuItem.getItemId()){
                        case R.id.nav_home: i = new Intent(Ethics.this, MainActivity.class); startActivity(i); break;
                        case R.id.back: i = new Intent(Ethics.this, FAQ.class); startActivity(i); break;
                    }
                    return true;
                }
            };
}
