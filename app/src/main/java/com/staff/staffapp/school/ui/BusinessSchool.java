package com.staff.staffapp.school.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.staff.staffapp.R;

public class BusinessSchool extends AppCompatActivity implements View.OnClickListener {
    private ActionBar toolbar;

    private CardView dataCard, cybersecCard, devCard, agileCard, itilCard, marketingCard, managementCard, financeCard, communicationCard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_business_school);

        dataCard = (CardView) findViewById(R.id.data_card);
        cybersecCard = (CardView) findViewById(R.id.cybersec_card);
        devCard = (CardView) findViewById(R.id.dev_card);
        agileCard = (CardView) findViewById(R.id.agile_card);
        itilCard = (CardView) findViewById(R.id.itil_card);
        marketingCard = (CardView) findViewById(R.id.marketing_card);
        managementCard = (CardView) findViewById(R.id.management_card);
        financeCard = (CardView) findViewById(R.id.finance_card);
        communicationCard = (CardView) findViewById(R.id.communications_card);

        dataCard.setOnClickListener(this);
        cybersecCard.setOnClickListener(this);
        devCard.setOnClickListener(this);
        agileCard.setOnClickListener(this);
        itilCard.setOnClickListener(this);
        marketingCard.setOnClickListener(this);
        managementCard.setOnClickListener(this);
        financeCard.setOnClickListener(this);
        communicationCard.setOnClickListener(this);




        toolbar = getSupportActionBar();
        BottomNavigationView navigation = findViewById(R.id.navigation);

    }

    @Override
    public void onClick(View view) {

        Intent i ;

        switch (view.getId())
        {
            case R.id.data_card : i = new Intent(this, DataScienceActivity.class); startActivity(i); break;
            case R.id.cybersec_card : i = new Intent(this, CyberSecActivity.class); startActivity(i); break;
            case R.id.dev_card : i = new Intent(this, CyberSecActivity.class); startActivity(i); break;
            case R.id.agile_card : i = new Intent(this, AgileActivity.class); startActivity(i); break;
            case R.id.itil_card : i = new Intent(this, ItilActivity.class); startActivity(i); break;
            case R.id.marketing_card : i = new Intent(this, MarketingActivity.class); startActivity(i); break;
            case R.id.management_card : i = new Intent(this, ManagementActivity.class); startActivity(i); break;
            case R.id.finance_card : i = new Intent(this, FinanceActivity.class); startActivity(i); break;
            case R.id.communications_card : i = new Intent(this, CommunicationActivity.class); startActivity(i); break;
            default:break;
        }
    }
}