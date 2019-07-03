package com.staff.staffapp.faq;

import androidx.appcompat.app.AppCompatActivity;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.animation.ArgbEvaluator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;

import com.staff.staffapp.R;
import com.staff.staffapp.adapter.HospitalsAdapter;
import com.staff.staffapp.adapter.SpecialistsAdapter;
import com.staff.staffapp.adapter.SupportAdapter;
import com.staff.staffapp.model.HospitalProvider;
import com.staff.staffapp.model.SpecialistProvider;
import com.staff.staffapp.model.SupportMedical;
import com.takusemba.multisnaprecyclerview.MultiSnapRecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MedicalProviders extends AppCompatActivity {

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
        specialistProviders.add(new SpecialistProvider("Endocrinologists", R.drawable.ic_thyroid));
        specialistProviders.add(new SpecialistProvider("ENT Specialist", R.drawable.ic_listen));
        specialistProviders.add(new SpecialistProvider("Facial Surgeon", R.drawable.ic_anatomy));
        specialistProviders.add(new SpecialistProvider("Gaenacologists", R.drawable.ic_uterus));
        specialistProviders.add(new SpecialistProvider("General Surgeon", R.drawable.ic_surgery_room));
        specialistProviders.add(new SpecialistProvider("GP Direct", R.drawable.ic_stethoscope));
        specialistProviders.add(new SpecialistProvider("Haematologist", R.drawable.ic_three_test_tubes));
        specialistProviders.add(new SpecialistProvider("Neurologists", R.drawable.ic_intelligence));
        specialistProviders.add(new SpecialistProvider("Nephrologist", R.drawable.ic_kidneys));
        specialistProviders.add(new SpecialistProvider("Oncologist Gynacologist", R.drawable.ic_chemotherapy));
        specialistProviders.add(new SpecialistProvider("Ophthalmologists", R.drawable.ic_visibility));
        specialistProviders.add(new SpecialistProvider("Orthopedic Surgeons", R.drawable.ic_orthopedics));
        specialistProviders.add(new SpecialistProvider("Paeditricians", R.drawable.ic_baby));
        specialistProviders.add(new SpecialistProvider("Psychiatrist", R.drawable.ic_brain));
        specialistProviders.add(new SpecialistProvider("Urologist", R.drawable.ic_urology));
        specialistProviders.add(new SpecialistProvider("Radiotherapists", R.drawable.radiologist));
        specialistProviders.add(new SpecialistProvider("Rhematologists", R.drawable.ic_bones_joint));


        supportMedicals = new ArrayList<>();
        supportMedicals.add(new SupportMedical("Ambulance"));
        supportMedicals.add(new SupportMedical("Home Nursing"));
        supportMedicals.add(new SupportMedical("Laboratory"));
        supportMedicals.add(new SupportMedical("Pharmacies"));
        supportMedicals.add(new SupportMedical("Physiotherapy"));
        supportMedicals.add(new SupportMedical("Radiology"));


        specialistsAdapter = new SpecialistsAdapter(specialistProviders, this);
        specialistRecyclerView.setAdapter(specialistsAdapter);
        LinearLayoutManager specialistManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        specialistRecyclerView.setLayoutManager(specialistManager);


        hospitalsAdapter = new HospitalsAdapter(hospitalProviders, this);
        hospitalRecyclerView.setAdapter(hospitalsAdapter);
        LinearLayoutManager hospitalManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        hospitalRecyclerView.setLayoutManager(hospitalManager);


        supportAdapter = new SupportAdapter(supportMedicals, this);
        supportRecyclerView.setAdapter(supportAdapter);
        LinearLayoutManager supportManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        supportRecyclerView.setLayoutManager(supportManager);


    }
}
