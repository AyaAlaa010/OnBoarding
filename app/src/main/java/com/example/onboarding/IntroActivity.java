package com.example.onboarding;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Html;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.onboarding.databinding.IntroActivityBinding;
import com.example.onboarding.sliderFragments.MyPagerAdapter;

import java.util.ArrayList;

public class IntroActivity extends AppCompatActivity {
    // creating variables for view pager,
    // liner layout, adapter and our array list.
    private IntroActivityBinding binding;
    private ViewPager viewPager;
    private LinearLayout dotsLL;
    private TextView[] dots;
    MyPagerAdapter myAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.intro_activity);

        // initializing all our views.
        viewPager = findViewById(R.id.idViewPager);
        dotsLL = findViewById(R.id.idLLDots);


        FragmentManager fragmentManager = getSupportFragmentManager();
        myAdapter = new MyPagerAdapter(fragmentManager);
        viewPager.setAdapter(myAdapter);


        // calling method to add dots indicator
        addDots(3, 0);

        // below line is use to call on
        // page change listener method.
        viewPager.addOnPageChangeListener(viewListner);
        setActionListener();

    }
    private void setActionListener(){
        binding.imgGoToNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(IntroActivity.this,MainActivity.class));

            }
        });



    }


    private void addDots(int size, int pos) {
        // inside this method we are
        // creating a new text view.
        dots = new TextView[size];

        // below line is use to remove all
        // the views from the linear layout.
        dotsLL.removeAllViews();

        // running a for loop to add
        // number of dots to our slider.
        for (int i = 0; i < size; i++) {
            // below line is use to add the
            // dots and modify its color.
            dots[i] = new TextView(this);
            dots[i].setText(Html.fromHtml("•"));
            dots[i].setTextSize(55);

            // below line is called when the dots are not selected.
            dots[i].setTextColor(Color.WHITE);
            dotsLL.addView(dots[i]);
        }
        if (dots.length > 0) {
            // this line is called when the dots
            // inside linear layout are selected
            dots[pos].setTextColor(getResources().getColor(R.color.blue));
        }
    }

    // creating a method for view pager for on page change listener.
    ViewPager.OnPageChangeListener viewListner = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            // we are calling our dots method to
            // change the position of selected dots.
            addDots(3, position);
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };
}