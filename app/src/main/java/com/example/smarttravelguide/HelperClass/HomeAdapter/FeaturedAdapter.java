package com.example.smarttravelguide.HelperClass.HomeAdapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.smarttravelguide.R;

import java.util.ArrayList;

public class FeaturedAdapter extends RecyclerView.Adapter<FeaturedAdapter.FeaturedViewHolder> {

    ArrayList<FeaturedHelperClass> featuredLocation;

    public FeaturedAdapter(ArrayList<FeaturedHelperClass> featuredHelperClasses) {
        this.featuredLocation = featuredHelperClasses;
    }

    @NonNull
    @Override
    public FeaturedViewHolder onCreateViewHolder(@androidx.annotation.NonNull ViewGroup parent, int i) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.featured_card_design, parent, false);
        FeaturedViewHolder FeaturedViewHolder = new FeaturedViewHolder(view);
        return FeaturedViewHolder;
    }

    @Override
    public void onBindViewHolder(@androidx.annotation.NonNull FeaturedViewHolder holder, int position) {

        FeaturedHelperClass FeaturedHelperClass = featuredLocation.get(position);

        holder.image.setImageResource(FeaturedHelperClass.getImages());
        holder.title.setText(FeaturedHelperClass.getTitles());
        holder.desc.setText(FeaturedHelperClass.getImages());
    }

    @Override
    public int getItemCount() {

        return featuredLocation.size();
    }

    public static class FeaturedViewHolder extends RecyclerView.ViewHolder {

        //HOOKS
        ImageView image;
        TextView title, desc;

        public FeaturedViewHolder(@NonNull View itemView) {
            super(itemView);

            //HOOKS
            image = itemView.findViewById(R.id.k_image);
            title = itemView.findViewById(R.id.k_title);
            desc = itemView.findViewById(R.id.k_desc);


        }
    }


}




