package com.infogator.pk.AllTourAttractions;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.infogator.pk.MainActivity;
import com.infogator.pk.R;
import com.infogator.pk.option;
import com.infogator.pk.sign;

import java.util.ArrayList;

public class TourAttractionsList extends AppCompatActivity {

    RecyclerView recycler;
    LinearLayoutManager manager;
    TourAttractionsList_Adapter adapter;
    ArrayList<TourAttractionsList_Model> array;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tour_attractions_list);

        array = new ArrayList<>();
        array.add(new TourAttractionsList_Model("Hunza", "Gilgit-Baltistan", R.drawable.hunza));
        array.add(new TourAttractionsList_Model("Attabad", "Gilgit-Baltistan", R.drawable.attabad));
        array.add(new TourAttractionsList_Model("Sawat", "Malakand", R.drawable.swat));
        array.add(new TourAttractionsList_Model("Naran", "Mansehra", R.drawable.narran));
        array.add(new TourAttractionsList_Model("Badshai", "Lahore", R.drawable.badshahi));
        array.add(new TourAttractionsList_Model("Mohenjo Daro", "Larkana", R.drawable.mohen));
        array.add(new TourAttractionsList_Model("Hunza", "Gilgit-Baltistan", R.drawable.hunza));
        array.add(new TourAttractionsList_Model("Attabad", "Gilgit-Baltistan", R.drawable.attabad));
        array.add(new TourAttractionsList_Model("Sawat", "Malakand", R.drawable.swat));
        array.add(new TourAttractionsList_Model("Naran", "Mansehra", R.drawable.narran));
        array.add(new TourAttractionsList_Model("Badshai", "Lahore", R.drawable.badshahi));
        array.add(new TourAttractionsList_Model("Mohenjo Daro", "Larkana", R.drawable.mohen));
        array.add(new TourAttractionsList_Model("Hunza", "Gilgit-Baltistan", R.drawable.hunza));
        array.add(new TourAttractionsList_Model("Attabad", "Gilgit-Baltistan", R.drawable.attabad));
        array.add(new TourAttractionsList_Model("Sawat", "Malakand", R.drawable.swat));
        array.add(new TourAttractionsList_Model("Naran", "Mansehra", R.drawable.narran));
        array.add(new TourAttractionsList_Model("Badshai", "Lahore", R.drawable.badshahi));
        array.add(new TourAttractionsList_Model("Mohenjo Daro", "Larkana", R.drawable.mohen));
        array.add(new TourAttractionsList_Model("sidnh", "Larkana", R.drawable.mohen));



        adapter = new TourAttractionsList_Adapter(this, array);

        manager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);

        recycler = findViewById(R.id.tourattr_recycler);
        recycler.setAdapter(adapter);
        recycler.setLayoutManager(manager);

        View button = findViewById(R.id.back);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(TourAttractionsList.this, MainActivity.class);
                startActivity(i);


            }
        });

    }


}