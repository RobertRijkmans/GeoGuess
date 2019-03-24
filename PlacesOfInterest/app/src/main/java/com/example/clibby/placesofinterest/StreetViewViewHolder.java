package com.example.clibby.placesofinterest;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class StreetViewViewHolder extends RecyclerView.ViewHolder {


    public TextView geoName;

    public ImageView geoImage;

    public View view;


    public StreetViewViewHolder(View itemView) {

        super(itemView);

        geoImage = itemView.findViewById(R.id.geoImageView);

        view = itemView;

    }

}

