package com.example.smarttravelguide.User;


import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.smarttravelguide.HelperClass.HomeAdapter.CategoriesAdapter;
import com.example.smarttravelguide.HelperClass.HomeAdapter.CategoriesHelperClass;
import com.example.smarttravelguide.HelperClass.HomeAdapter.FeaturedAdapter;
import com.example.smarttravelguide.HelperClass.HomeAdapter.FeaturedHelperClass;
import com.example.smarttravelguide.HelperClass.HomeAdapter.MostViewAdapter;
import com.example.smarttravelguide.HelperClass.HomeAdapter.MostViewHelperClass;
import com.example.smarttravelguide.R;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

public class UserDashBoard extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    static final float END_SCALE = 0.7f;
    RecyclerView featuredRecycler , mostViewRecyler , categoriesRecycles;
    private GradientDrawable gradient1 , gradient2 , gradient3 ,gradient4;
    RecyclerView.Adapter adapter;
    //drawer
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    ImageView menuIcon;
    LinearLayout contentView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_user_dash_board);
        //hooks
        featuredRecycler = findViewById(R.id.featured_recycler);
        mostViewRecyler = findViewById(R.id.most_viewed_recycler);
        categoriesRecycles = findViewById(R.id.categories_recycle);
        menuIcon = findViewById(R.id.menu_icon);
        contentView = findViewById(R.id.content);
        
        //function will be executed automatically when this activity will be created
        featuredRecycler();
        mostViewRecyler();
        categoriesRecycles();
        
        //menu hooks
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.navigation_view);

    }


    private void categoriesRecycles() {
    }

    private void mostViewRecyler() {
        mostViewRecyler.setHasFixedSize(true);
        mostViewRecyler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        ArrayList<MostViewHelperClass> mostViewedLocations = new ArrayList<>();
        mostViewedLocations.add(new MostViewHelperClass(R.drawable.lahorefort, "lahorefort"));
        mostViewedLocations.add(new MostViewHelperClass(R.drawable.badshahimosque, "badshahimosque"));
        mostViewedLocations.add(new MostViewHelperClass(R.drawable.bhurbanhillmurree, "bhurbanhillmurree"));
        mostViewedLocations.add(new MostViewHelperClass(R.drawable.pakistan_monument, "pakistan_monument"));
        adapter = new MostViewAdapter(mostViewedLocations);
        mostViewRecyler.setAdapter(adapter);
    }


    private void categoriesRecycles(ArrayList<CategoriesHelperClass> CategoriesHelperClass) {
            //All Gradients
            gradient2 = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{0xffd4cbe5, 0xffd4cbe5});
            gradient1 = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{0xff7adccf, 0xff7adccf});
            gradient3 = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{0xfff7c59f, 0xFFf7c59f});
            gradient4 = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{0xffb8d7f5, 0xffb8d7f5});


        ArrayList<CategoriesHelperClass> categoriesHelperClasses = new ArrayList<>();
        categoriesHelperClasses.add(new CategoriesHelperClass( gradient1, R.drawable.school_images, "Education"));
        categoriesHelperClasses.add(new CategoriesHelperClass(gradient2, R.drawable.hospital_imagess, "HOSPITAL"));
        categoriesHelperClasses.add(new CategoriesHelperClass(gradient3, R.drawable.restaurant, "Restaurant"));
        categoriesHelperClasses.add(new CategoriesHelperClass(gradient4, R.drawable.shopping_images, "Shopping"));
        categoriesHelperClasses.add(new CategoriesHelperClass(gradient1, R.drawable.transport_images, "Transport"));

        categoriesRecycles.setHasFixedSize(true);
        adapter = new CategoriesAdapter(CategoriesHelperClass);
        categoriesRecycles.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        categoriesRecycles.setAdapter(adapter);
    }

    private void navigationDrawer() {

        navigationView.bringToFront();
        navigationView.setNavigationItemSelectedListener( this);
        navigationView.setCheckedItem(R.id.nav_home);


        menuIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(drawerLayout.isDrawerVisible(GravityCompat.START))
                    drawerLayout.closeDrawer(GravityCompat.START);
            else drawerLayout.openDrawer(GravityCompat.START);
            }
        });

        animateNavigationDrawer();
    }

    private void animateNavigationDrawer() {

        drawerLayout.setScrimColor(getResources().getColor(R.color.colorPrimary));
            drawerLayout.addDrawerListener(new DrawerLayout.SimpleDrawerListener() {
                @Override
                public void onDrawerSlide(View drawerView, float slideOffset) {
                    // Scale the View based on current slide offset
                    final float diffScaledOffset = slideOffset * (1 - END_SCALE);
                    final float offsetScale = 1 - diffScaledOffset;
                    contentView.setScaleX(offsetScale);
                    contentView.setScaleY(offsetScale);
                    // Translate the View, accounting for the scaled width
                    final float xOffset = drawerView.getWidth() * slideOffset;
                    final float xOffsetDiff = contentView.getWidth() * diffScaledOffset / 2;
                    final float xTranslation = xOffset - xOffsetDiff;
                    contentView.setTranslationX(xTranslation);
                }
            });
        }

    @Override
    public void onBackPressed() {

        if(drawerLayout.isDrawerVisible(GravityCompat.START));
        {
            drawerLayout.closeDrawer(GravityCompat.START);
        }
        super.onBackPressed();
    }

    private void featuredRecycler() {

        featuredRecycler.setHasFixedSize(true);
        featuredRecycler.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));

        ArrayList<FeaturedHelperClass> FeaturedLocation = new ArrayList<>();

        FeaturedLocation.add(new FeaturedHelperClass(R.drawable.lahorefort,"lahoreFort"," Has A Great Place" ));
        //damie 
        FeaturedLocation.add(new FeaturedHelperClass(R.drawable.kababjees,"kababjees"," has A Great Taste" ));
        FeaturedLocation.add(new FeaturedHelperClass(R.drawable.unitedking,"unitedking"," has A Great Taste" ));

        adapter = new FeaturedAdapter(FeaturedLocation);
        featuredRecycler.setAdapter(adapter);

        GradientDrawable gradient1 = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT,new int[]{0xffeff400, 0xffaff600});


    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        return true;
    }
}