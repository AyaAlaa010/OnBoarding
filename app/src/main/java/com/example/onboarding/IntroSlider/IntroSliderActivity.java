package com.example.onboarding.IntroSlider;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.onboarding.R;
import com.example.onboarding.databinding.IntroActivityBinding;
import com.example.onboarding.ui.home.MainActivity;

public class IntroSliderActivity extends AppCompatActivity {
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
        addIndicator(3, 0);
        setActionListener();

        // below line is use to call on
        // page change listener method.
        viewPager.addOnPageChangeListener(viewListner);

    }
    private void setActionListener(){
        binding.imgGoToNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int current = getItem(+1);
                if (current < 3) {
                    // move to next screen
                    viewPager.setCurrentItem(current);
                } else {
                      Intent intent=   new Intent(IntroSliderActivity.this, MainActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK); // to prevent the backing to RegisterActivity
                    startActivity(intent);
                    finish();

                }

            }
        });



    }


    private void addIndicator(int size, int pos) {
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
            //dots[i].setText(Html.fromHtml("•"));
            dots[i].setBackgroundResource(R.drawable.unselected_indicator_slider);
            dots[i].setWidth(70);
            dots[i].setHeight(15);
//
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            params.setMargins(10,10,10,10);
            dots[i].setLayoutParams(params);

            dotsLL.addView(dots[i]);

        }
        if (dots.length > 0) {
            // this line is called when the dots
            // inside linear layout are selected
            dots[pos].setBackgroundResource(R.drawable.selected_indicator_slider);
            //dots[pos].setTextColor(getResources().getColor(R.color.blue));
        }


    }

    private int getItem(int i) {
        return viewPager.getCurrentItem() + i;
    }

    // creating a method for view pager for on page change listener.
    ViewPager.OnPageChangeListener viewListner = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {


        }

        @Override
        public void onPageSelected(int position) {
            addIndicator(3, position);

//
//            if(position==viewPager.getAdapter().getCount()-1){
//                Intent reg = new
//                        Intent(IntroSliderActivity.this,MainActivity.class);
//                startActivity(reg);
//            }


        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };
}