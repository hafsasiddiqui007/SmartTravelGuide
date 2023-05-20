package com.example.smarttravelguide.HelperClass.HomeAdapter;

import android.graphics.drawable.GradientDrawable;

public class CategoriesHelperClass {


    int images;
    String titles, Gradien;

    public CategoriesHelperClass(int images, String titles, String gradien) {
        this.images = images;
        this.titles = titles;
        Gradien = gradien;
    }

    public CategoriesHelperClass(GradientDrawable gradient1, int school_images, String education) {

    }

    public int getImages() {
        return images;
    }

    public String getTitles() {
        return titles;
    }

    public String getGradien() {
        return Gradien;
    }
}