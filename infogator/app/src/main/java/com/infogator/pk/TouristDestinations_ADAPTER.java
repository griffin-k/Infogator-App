package com.infogator.pk;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.infogator.pk.AllTourAttractions.TourAttractionsList;
import com.infogator.pk.R;
import com.infogator.pk.TouristDestinations_MODEL;

import java.util.ArrayList;

public class TouristDestinations_ADAPTER extends RecyclerView.Adapter<TouristDestinations_ADAPTER.ViewHolder> {

    Context mycontext;
    ArrayList<TouristDestinations_MODEL> model;

    public TouristDestinations_ADAPTER(Context mycontext, ArrayList<TouristDestinations_MODEL> model) {
        this.mycontext = mycontext;
        this.model = model;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View myview = LayoutInflater.from(mycontext).inflate(R.layout.home_recyclerview_layout, parent, false);
        return new ViewHolder(myview);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        TouristDestinations_MODEL model2 = model.get(position);
        holder.image.setImageResource(model2.image);
        holder.name.setText(model2.name);
        holder.state.setText(model2.state);
    }

    @Override
    public int getItemCount() {
        return model.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        ImageView image;
        TextView name, state;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);

            image = itemView.findViewById(R.id.city_image);
            name = itemView.findViewById(R.id.city_name);
            state = itemView.findViewById(R.id.state_name);
        }

        @Override
        public void onClick(View view) {
            int position = getAdapterPosition();
            if (position != RecyclerView.NO_POSITION) {
                TouristDestinations_MODEL clickedItem = model.get(position);
                // Handle the click event for the item at the clicked position

                // Example: Start a new activity based on the clicked item
                Intent intent = new Intent(mycontext, TourAttractionsList.class);
                intent.putExtra("putextra_city", clickedItem.name);
                mycontext.startActivity(intent);
            }
        }
    }
}
