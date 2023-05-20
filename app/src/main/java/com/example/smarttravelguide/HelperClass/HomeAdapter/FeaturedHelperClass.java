package com.example.smarttravelguide.HelperClass.HomeAdapter;

public class FeaturedHelperClass {

    int images;
    String titles, description;

    public FeaturedHelperClass(int images, String titles, String description) {

        this.images = images;
        this.titles = titles;
        this.description = description;
    }

    public int getImages() {
        return images;
    }

    public String getTitles() {
        return titles;
    }

    public String getDescription() {
        return description;
    }
}
