package com.example.smarttravelguide.Common;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Bundle;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.smarttravelguide.R;
import com.example.smarttravelguide.User.UserDashBoard;

import java.time.Instant;

public class SplashScreen extends AppCompatActivity {

    private  static int SPLASH_TIMER =2000;
    //variable
     ImageView backgroundimage;
     TextView Slogan_name;
     //Animations
     Animation sideanim,bottomanim;
     SharedPreferences BoardingScreen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.splash_screen);

     //hooks
        backgroundimage= findViewById(R.id.background_image);
        Slogan_name = findViewById(R.id.Slogan_name);

        //Animations
        sideanim = AnimationUtils.loadAnimation(this,R.anim.side_anim);
        bottomanim = AnimationUtils.loadAnimation(this,R.anim.bottom_anim);

        //Set Animations ON ELEMENT
        backgroundimage.setAnimation(sideanim);
        backgroundimage.setAnimation(bottomanim);

     new Handler().postDelayed(new Runnable() {
         @Override
         public void run() {
             BoardingScreen =getSharedPreferences("BoardingScreen", MODE_PRIVATE);
             boolean isFirstTime = BoardingScreen.getBoolean("firstTime", true);

             if(isFirstTime){

                 SharedPreferences.Editor editor = BoardingScreen.edit();
                 editor.putBoolean("firstTime" , false );
                 editor.commit();
                 Intent intent = new Intent(getApplicationContext(),Boarding.class);
                 startActivity(intent);
                 finish();

             }
             else {
                 Intent intent = new Intent(getApplicationContext(),UserDashBoard.class);
                 startActivity(intent);
                 finish();

             }

         }
     },SPLASH_TIMER);

    }

}