package com.example.clibby.placesofinterest;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public class StreetViewAdapter extends RecyclerView.Adapter<StreetViewViewHolder> {

    private Context context;

    public List<StreetView> listStreetView;


    public StreetViewAdapter(Context context, List<StreetView> listStreetView) {
        this.context = context;
        this.listStreetView = listStreetView;
    }

    @Override
    public StreetViewViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.grid_cell, parent, false);
        return new StreetViewViewHolder(view);
    }
    @Override
    public void onBindViewHolder(final StreetViewViewHolder holder, final int position) {
        // Gets a single item in the list from its position
        final StreetView streetView = listStreetView.get(position);
        // The holder argument is used to reference the views inside the viewHolder
        // Populate the views with the data from the list
        holder.geoImage.setImageResource(streetView.getmGeoImageName());
    }
    public int getItemCount(){
        return listStreetView.size();
    }
}
