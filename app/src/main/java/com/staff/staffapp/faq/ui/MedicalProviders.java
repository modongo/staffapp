package com.staff.staffapp.faq.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.staff.staffapp.R;
import com.staff.staffapp.faq.adapter.HospitalsAdapter;
import com.staff.staffapp.faq.adapter.SpecialistsAdapter;
import com.staff.staffapp.faq.adapter.SupportAdapter;
import com.staff.staffapp.faq.model.HospitalProvider;
import com.staff.staffapp.faq.model.SpecialistProvider;
import com.staff.staffapp.faq.model.SupportMedical;
import com.staff.staffapp.MainActivity;
import com.takusemba.multisnaprecyclerview.MultiSnapRecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MedicalProviders extends AppCompatActivity implements
        HospitalsAdapter.OnItemListener,
        SupportAdapter.OnSupportListener,
        SpecialistsAdapter.OnSpecialistListener


{

    MultiSnapRecyclerView specialistRecyclerView;
    MultiSnapRecyclerView hospitalRecyclerView;
    MultiSnapRecyclerView supportRecyclerView;

    RecyclerView recyclerView;


    SpecialistsAdapter specialistsAdapter;
    HospitalsAdapter hospitalsAdapter;
    SupportAdapter supportAdapter;

    List<SpecialistProvider> specialistProviders;
    List<HospitalProvider> hospitalProviders;
    List<SupportMedical> supportMedicals;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medical_providers);

        initItemViews();
        
        hospitalProviders = new ArrayList<>();
        specialistProviders = new ArrayList<>();
        supportMedicals = new ArrayList<>();

        specialistRecyclerView = (MultiSnapRecyclerView) findViewById(R.id.specialists_recycler_view);
        specialistRecyclerView.setHasFixedSize(true);

        hospitalRecyclerView = (MultiSnapRecyclerView) findViewById(R.id.hospitals_recycler_view);
        hospitalRecyclerView.setHasFixedSize(true);

        supportRecyclerView = (MultiSnapRecyclerView) findViewById(R.id.support_recycler_view);
        supportRecyclerView.setHasFixedSize(true);




        hospitalProviders.add(new HospitalProvider("Coast"));
        hospitalProviders.add(new HospitalProvider("Eastern"));
        hospitalProviders.add(new HospitalProvider("Mt.Kenya"));
        hospitalProviders.add(new HospitalProvider("Nairobi"));
        hospitalProviders.add(new HospitalProvider("North Eastern"));
        hospitalProviders.add(new HospitalProvider("Nyanza / Rift"));
        hospitalProviders.add(new HospitalProvider("Overseas"));


        specialistProviders = new ArrayList<>();
        specialistProviders.add(new SpecialistProvider("Cardiologists", R.drawable.ic_heart));
        specialistProviders.add(new SpecialistProvider("Chest Specialist", R.drawable.ic_men_chest));
        specialistProviders.add(new SpecialistProvider("Counselling", R.drawable.ic_advice));
        specialistProviders.add(new SpecialistProvider("Dentists", R.drawable.ic_tooth));
        specialistProviders.add(new SpecialistProvider("Dermatologist", R.drawable.ic_dermatology));
        specialistProviders.add(new SpecialistProvider("Endocrinologists", R.drawable.ic_thyroids));
        specialistProviders.add(new SpecialistProvider("ENT Specialist", R.drawable.ic_listen));
        specialistProviders.add(new SpecialistProvider("Facial Surgeon", R.drawable.ic_anatomy));
        specialistProviders.add(new SpecialistProvider("Gaenacologists", R.drawable.ic_uterus));
        specialistProviders.add(new SpecialistProvider("GastroEnterologist", R.drawable.ic_digestive_system));
        specialistProviders.add(new SpecialistProvider("General Surgeon", R.drawable.ic_surgery_room));
        specialistProviders.add(new SpecialistProvider("GP Direct", R.drawable.ic_stethoscope));
        specialistProviders.add(new SpecialistProvider("Haematologist", R.drawable.ic_three_test_tubes));
        specialistProviders.add(new SpecialistProvider("Neurologists", R.drawable.ic_intelligence));
        specialistProviders.add(new SpecialistProvider("Nephrologist", R.drawable.ic_kidneys));
        specialistProviders.add(new SpecialistProvider("Oncologist", R.drawable.ic_chemotherapy));
        specialistProviders.add(new SpecialistProvider("Ophthalmologists", R.drawable.ic_visibility));
        specialistProviders.add(new SpecialistProvider("Orthopedic Surgeons", R.drawable.ic_orthopedics));
        specialistProviders.add(new SpecialistProvider("Paeditricians", R.drawable.ic_baby));
        specialistProviders.add(new SpecialistProvider("Psychiatrist", R.drawable.ic_brain));
        specialistProviders.add(new SpecialistProvider("Urologist", R.drawable.ic_urology));
        specialistProviders.add(new SpecialistProvider("Radiotherapists", R.drawable.radiologist));
        specialistProviders.add(new SpecialistProvider("Rhematologists", R.drawable.ic_bones_joint));


        supportMedicals = new ArrayList<>();
        supportMedicals.add(new SupportMedical("Ambulance", R.drawable.ambulance));
        supportMedicals.add(new SupportMedical("Home Nursing", R.drawable.nurse));
        supportMedicals.add(new SupportMedical("Laboratory", R.drawable.lab));
        supportMedicals.add(new SupportMedical("Pharmacies", R.drawable.pharmacy));
        supportMedicals.add(new SupportMedical("Physiotherapy", R.drawable.physiotherapist));
        supportMedicals.add(new SupportMedical("Radiology", R.drawable.radiology));


        specialistsAdapter = new SpecialistsAdapter(specialistProviders, this, this);
        specialistRecyclerView.setAdapter(specialistsAdapter);
        LinearLayoutManager specialistManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        specialistRecyclerView.setLayoutManager(specialistManager);


        hospitalsAdapter = new HospitalsAdapter(hospitalProviders, this, this);
        hospitalRecyclerView.setAdapter(hospitalsAdapter);
        LinearLayoutManager hospitalManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        hospitalRecyclerView.setLayoutManager(hospitalManager);


        supportAdapter = new SupportAdapter(supportMedicals, this, this);
        supportRecyclerView.setAdapter(supportAdapter);
        LinearLayoutManager supportManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        supportRecyclerView.setLayoutManager(supportManager);

        BottomNavigationView bottomNav = (BottomNavigationView) findViewById(R.id.bottomNav);
        bottomNav.setOnNavigationItemSelectedListener(navListener);
    }

    private void initItemViews() {
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                    Intent i;

                    switch(menuItem.getItemId()){
                        case R.id.nav_home: i = new Intent(MedicalProviders.this, MainActivity.class); startActivity(i); break;
                        case R.id.back: i = new Intent(MedicalProviders.this, FAQ.class); startActivity(i); break;
                    }
                    return true;
                }
            };

    @Override
    public void onItemClick(int position) {
       hospitalProviders.get(position);
       final Intent intent;

       switch (position){
           case 0:
               intent = new Intent(this, Coast.class); startActivity(intent); break;

           case 1:
               intent = new Intent(this, Eastern.class); startActivity(intent); break;

           case 2:
               intent = new Intent(this, Central.class); startActivity(intent); break;

           case 3:
               intent = new Intent(this, Nairobi.class); startActivity(intent); break;

           case 4:
               intent = new Intent(this, North.class); startActivity(intent); break;

           case 5:
               intent = new Intent(this, Nyanza.class); startActivity(intent); break;

           case 6:
               intent = new Intent(this, Overseas.class); startActivity(intent); break;

       }


     }


    @Override
    public void onSpecialistClick(int position) {
        specialistProviders.get(position);
        final Intent intent;

        switch (position){
            case 0:
                intent = new Intent(this, Cardiologist.class); startActivity(intent); break;

            case 1:
                intent = new Intent(this, Chest.class); startActivity(intent); break;

            case 2:
                intent = new Intent(this, Counselling.class); startActivity(intent); break;

            case 3:
                intent = new Intent(this, Dentist.class); startActivity(intent); break;

            case 4:
                intent = new Intent(this, Dermatologist.class); startActivity(intent); break;

            case 5:
                intent = new Intent(this, Endocrinology.class); startActivity(intent); break;

            case 6:
                intent = new Intent(this, ENT.class); startActivity(intent); break;

            case 7:
                intent = new Intent(this, Facial.class); startActivity(intent); break;

            case 8:
                intent = new Intent(this, Gaenacologist.class); startActivity(intent); break;

            case 9:
                intent = new Intent(this, Gastro.class); startActivity(intent); break;

            case 10:
                intent = new Intent(this, GeneralSurgeon.class); startActivity(intent); break;

            case 11:
                intent = new Intent(this, GP.class); startActivity(intent); break;

            case 12:
                intent = new Intent(this, Haematologist.class); startActivity(intent); break;

            case 13:
                intent = new Intent(this, Neurologist.class); startActivity(intent); break;

            case 14:
                intent = new Intent(this, Nephrology.class); startActivity(intent); break;

            case 15:
                intent = new Intent(this, Oncology.class); startActivity(intent); break;

            case 16:
                intent = new Intent(this, Opthalmologist.class); startActivity(intent); break;

            case 17:
                intent = new Intent(this, Orthopedic.class); startActivity(intent); break;

            case 18:
                intent = new Intent(this, Paeditrician.class); startActivity(intent); break;

            case 19:
                intent = new Intent(this,   Psychiatrist.class); startActivity(intent); break;

            case 20:
                intent = new Intent(this, Urology.class); startActivity(intent); break;

            case 21:
                intent = new Intent(this, Radiotherapist.class); startActivity(intent); break;

            case 22:
                intent = new Intent(this, Rhematology.class); startActivity(intent); break;
        }


    }

    @Override
    public void onSupportClick(int position) {
        supportMedicals.get(position);
        final Intent intent;

        switch (position){
            case 0:
                intent = new Intent(this, Ambulance.class); startActivity(intent); break;

            case 1:
                intent = new Intent(this, Nursing.class); startActivity(intent); break;

            case 2:
                intent = new Intent(this, Labs.class); startActivity(intent); break;

            case 3:
                intent = new Intent(this, Pharmacies.class); startActivity(intent); break;

            case 4:
                intent = new Intent(this, Physiotherapy.class); startActivity(intent); break;

            case 5:
                intent = new Intent(this, Radiology.class); startActivity(intent); break;

        }

    }
}
