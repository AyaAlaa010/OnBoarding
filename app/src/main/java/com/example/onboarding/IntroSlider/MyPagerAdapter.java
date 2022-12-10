package com.example.onboarding.IntroSlider;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;


public class MyPagerAdapter extends FragmentPagerAdapter {

    public MyPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int pos) {
        switch(pos) {

            case 0: return new FirstIntroSlideFragment();
            case 1: return new SecondIntroSlideFragment();
            case 2: return new ThirdIntroSlideFragment();
            default: return new FirstIntroSlideFragment();
        }
    }

    @Override
    public int getCount() {
        return 3;
    }

}