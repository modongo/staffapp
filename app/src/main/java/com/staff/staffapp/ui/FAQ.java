package com.staff.staffapp.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.staff.staffapp.MainActivity;
import com.staff.staffapp.R;
import com.staff.staffapp.faq.Contacts;
import com.staff.staffapp.faq.Emergency;
import com.staff.staffapp.faq.Ethics;
import com.staff.staffapp.faq.Jobs;
import com.staff.staffapp.faq.Leave;
import com.staff.staffapp.faq.Medical;

public class FAQ extends AppCompatActivity implements View.OnClickListener {


    private CardView leaveCard,jobsCard,contactsCard,ethicsCard, emergencyCard, medicalCard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faq);

        leaveCard = (CardView) findViewById(R.id.leave_card);
        jobsCard = (CardView) findViewById(R.id.jobs_card);
        contactsCard = (CardView) findViewById(R.id.contacts_card);
        ethicsCard = (CardView) findViewById(R.id.ethics_card);
        emergencyCard = (CardView) findViewById(R.id.emergency_card);
        medicalCard = (CardView) findViewById(R.id.medical_card);
        //Add Click Listener to the cards
        leaveCard.setOnClickListener(this);
        jobsCard.setOnClickListener(this);
        contactsCard.setOnClickListener(this);
        ethicsCard.setOnClickListener(this);
        emergencyCard.setOnClickListener(this);
        medicalCard.setOnClickListener(this);

        BottomNavigationView bottomNav = (BottomNavigationView) findViewById(R.id.bottomNav);
        bottomNav.setOnNavigationItemSelectedListener(navListener);

    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                    Intent i;

                    switch(menuItem.getItemId()){
                        case R.id.nav_home: i = new Intent(FAQ.this, MainActivity.class); startActivity(i); break;

                        case R.id.back: i = new Intent(FAQ.this, MainActivity.class); startActivity(i); break;

                        }
                    return true;
                }
            };

    @Override
    public void onClick(View v) {

        Intent i ;

        switch (v.getId()){
            case R.id.leave_card : i = new Intent(this, Leave.class); startActivity(i); break;
            case R.id.jobs_card : i = new Intent(this, Jobs.class); startActivity(i);  break;
            case R.id.contacts_card : i = new Intent(this, Contacts.class); startActivity(i);  break;
            case R.id.ethics_card : i = new Intent(this, Ethics.class); startActivity(i); break;
            case R.id.emergency_card : i = new Intent(this, Emergency.class); startActivity(i); break;
            case R.id.medical_card : i = new Intent(this, Medical.class); startActivity(i); break;
            default:break;

        }

    }
}
