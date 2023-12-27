package com.infogator.pk;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.infogator.pk.AllTourAttractions.TourAttractionsList;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView touristdestinations, touristattractions;
    ArrayList<TouristDestinations_MODEL> touristDestinations_models;
    ArrayList<TouristAttractions_MODEL> touristAttractions_models;
    TouristDestinations_ADAPTER touristDestinations_adapter;
    TouristAttractions_ADAPTER touristAttractions_adapter;
    LinearLayoutManager manager;
    TextView seetouristdestinations;
    Button explore,explore2;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        touristdestinations = findViewById(R.id.touristdestinations_recyclerview);

        touristDestinations_models = new ArrayList<>();
        touristDestinations_models.add(new TouristDestinations_MODEL(R.drawable.badshahi, "Badshahi Mosque", "Lahore"));
        touristDestinations_models.add(new TouristDestinations_MODEL(R.drawable.swat, "Sawat", "Malakand"));
        touristDestinations_models.add(new TouristDestinations_MODEL(R.drawable.nelum, "Neelam Valley", "Azad Kashmir"));
        touristDestinations_models.add(new TouristDestinations_MODEL(R.drawable.hunza, "Hunza Valley", "Gilgit"));

        touristDestinations_adapter = new TouristDestinations_ADAPTER(this, touristDestinations_models);
        manager = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);

        touristdestinations.setAdapter(touristDestinations_adapter);
        touristdestinations.setLayoutManager(manager);

        touristattractions = findViewById(R.id.touristattractions_recyclerview);

        touristAttractions_models = new ArrayList<>();
        touristAttractions_models.add(new TouristAttractions_MODEL(R.drawable.sindh, "Sindh", "Southeastern , Pakistan"));
        touristAttractions_models.add(new TouristAttractions_MODEL(R.drawable.punjab, "Punjab", "Eastern , Pakistan"));
        touristAttractions_models.add(new TouristAttractions_MODEL(R.drawable.blouchistan, "Blouchistan", "southwest , Pakistan"));
        touristAttractions_models.add(new TouristAttractions_MODEL(R.drawable.kpk, "Kpk", "Northwestern , Pakisatn"));

        touristAttractions_adapter = new TouristAttractions_ADAPTER(this, touristAttractions_models);
        manager = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);

        touristattractions.setAdapter(touristAttractions_adapter);
        touristattractions.setLayoutManager(manager);

        explore = findViewById(R.id.exploretouristdestinations_button);
        explore2 = findViewById(R.id.exploretouristdestinations_button2);



        seetouristdestinations = findViewById(R.id.seetouristdestinations_link);

        explore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, TourAttractionsList.class));
            }
        });

        seetouristdestinations.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, TourAttractionsList.class));
            }
        });

        explore2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, qrcode.class));
            }
        });



    }
}