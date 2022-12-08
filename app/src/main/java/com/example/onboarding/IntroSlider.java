package com.example.onboarding;

import android.os.Bundle;

import androidx.core.content.ContextCompat;

import com.github.appintro.AppIntro;
import com.github.appintro.AppIntroFragment;

public class IntroSlider extends AppIntro {

    // we are calling on create method
    // to generate the view for our java file.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // below line is for adding the new slide to our app.
        // we are creating a new instance and inside that
        // we are adding the title, description, image and
        // background color for our slide.
        // below line is use for creating first slide
        addSlide(AppIntroFragment.newInstance("Skip", "just seconds away from",   R.drawable.first1));

        // below line is for creating second slide.
        addSlide(AppIntroFragment.newInstance("Skip", "Data Structures and Algorithms", R.drawable.second,
                ContextCompat.getColor(getApplicationContext(), R.color.purple_200)));

        // below line is use to create third slide.
        addSlide(AppIntroFragment.newInstance("Skip", "Java Self Paced Course", R.drawable.third3,
                ContextCompat.getColor(getApplicationContext(), R.color.purple_200)));
    }
}