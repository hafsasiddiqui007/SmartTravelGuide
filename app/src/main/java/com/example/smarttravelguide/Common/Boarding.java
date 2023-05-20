package com.example.smarttravelguide.Common;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.example.smarttravelguide.HelperClass.SliderAdapter;
import com.example.smarttravelguide.R;
import com.example.smarttravelguide.User.UserDashBoard;

public class Boarding extends AppCompatActivity {

      ViewPager viewPager;
      LinearLayout dotsLayout;
      SliderAdapter sliderAdapter;
      TextView[] dots;
      Button letsgetstarted;
      Animation animation;
      int currentPos ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_on_boarding);
        //HOOKS
         viewPager = findViewById(R.id.slider);
         dotsLayout = findViewById(R.id.dots);
        letsgetstarted = findViewById(R.id.get_started_btn);

            //CALLS ADAPTER
        sliderAdapter = new SliderAdapter(this);
        viewPager.setAdapter(sliderAdapter);

        addDots(0);
        viewPager.addOnPageChangeListener(changeListener);
    }
    public  void  skip(View view){
         startActivity(new Intent(this, UserDashBoard.class));
    }
     public  void next(View view){

         viewPager.setCurrentItem(currentPos + 1);
     }


        private void addDots(int position){

            dots = new TextView[4];
            dotsLayout.removeAllViews();

            for(int i=0; i<dots.length; i++){
                dots[i] = new TextView(this);
                dots[i].setText(Html.fromHtml("&#8226"));
                dots[i].setTextSize(35);

                dotsLayout.addView(dots[i]);
            }

            if (dots.length > 0);
            dots[position].setTextColor(getResources().getColor(R.color.colorPrimaryDark));
        }

        ViewPager.OnPageChangeListener changeListener = new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {

                addDots(i);
                currentPos = i;

                if(i == 0) {
                     letsgetstarted.setVisibility(View.INVISIBLE);
                }
                else if (i == 1) {
                    letsgetstarted.setVisibility(View.INVISIBLE);
                }
                else if (i == 2) {
                    letsgetstarted.setVisibility(View.INVISIBLE);
                }
                else {
                    animation = AnimationUtils.loadAnimation(Boarding.this,R.anim.bottom_anim);
                    letsgetstarted.setAnimation(animation);
                    letsgetstarted.setVisibility(View.INVISIBLE);
                }
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        };
}