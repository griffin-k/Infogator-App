package com.infogator.pk.AllTourAttractions;


import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.imageview.ShapeableImageView;
import com.infogator.pk.CityDetails;
import com.infogator.pk.R;

import java.util.ArrayList;

public class TourAttractionsList_Adapter extends RecyclerView.Adapter<TourAttractionsList_Adapter.ViewHolder> {

    private Context context;
    private ArrayList<TourAttractionsList_Model> arrayList;

    public TourAttractionsList_Adapter(Context context, ArrayList<TourAttractionsList_Model> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View showview = LayoutInflater.from(context).inflate(R.layout.tour_attractions_list_layout, parent, false);
        return new ViewHolder(showview);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        TourAttractionsList_Model model = arrayList.get(position);

        holder.city.setText(model.city);
        holder.state.setText(model.state);
        holder.picture.setImageResource(model.image);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, CityDetails.class);
                intent.putExtra("putextra_city", model.city);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    @Override
    public void onViewAttachedToWindow(@NonNull ViewHolder holder) {
        super.onViewAttachedToWindow(holder);
        animateItem(holder.itemView);
    }

    private void animateItem(View view) {
        view.setTranslationX(-view.getWidth());
        view.animate()
                .translationX(0)
                .setDuration(300)
                .start();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView city, state;
        ShapeableImageView picture;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            city = itemView.findViewById(R.id.tourattr_name);
            state = itemView.findViewById(R.id.tourattr_state);
            picture = itemView.findViewById(R.id.tourattr_image);
        }
    }
}
