package com.example.smarttravelguide.HelperClass.HomeAdapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.smarttravelguide.R;

import java.text.BreakIterator;
import java.util.ArrayList;

public class MostViewAdapter extends RecyclerView.Adapter<MostViewAdapter.MostViewedViewHolder> {
    ArrayList<MostViewHelperClass> mostViewedLocations;

    public MostViewAdapter(ArrayList<MostViewHelperClass> mostViewedLocations) {
        this.mostViewedLocations = mostViewedLocations;
    }

    @NonNull
    @Override
    public MostViewedViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.most_viewed_card_design, parent, false);
        MostViewedViewHolder mostViewedViewHolder = new MostViewedViewHolder(view);
        return mostViewedViewHolder;
    }
    @Override
    public void onBindViewHolder(@NonNull MostViewedViewHolder holder, int position) {

        MostViewHelperClass MostViewHelperClass = mostViewedLocations.get(position);

        holder.image.setImageResource(MostViewHelperClass.getImages());
        holder.title.setText(MostViewHelperClass.getTitles());
        holder.desc.setText(MostViewHelperClass.getDescroption());

    }
    @Override
    public int getItemCount() {
        return mostViewedLocations.size();
    }

    public static class MostViewedViewHolder extends RecyclerView.ViewHolder {
        ImageView image;
        TextView title,desc;

        public MostViewedViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.lf_image);
            title = itemView.findViewById(R.id.lf_title);
            desc = itemView.findViewById(R.id.lf_desc);
        }
    }


    public static class AdapterAllCategoriesViewHolder extends RecyclerView.ViewHolder {
        RelativeLayout relativeLayout;
        ImageView imageView;
        TextView textView ;

        public AdapterAllCategoriesViewHolder(@NonNull View itemView) {
            super(itemView);
            relativeLayout = itemView.findViewById(R.id.background_gradient);
            imageView = itemView.findViewById(R.id.categories_image);
            textView = itemView.findViewById(R.id.categories_title);

        }
    }
}