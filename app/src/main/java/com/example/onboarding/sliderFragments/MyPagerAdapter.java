package com.example.onboarding.sliderFragments;
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

            case 0: return new FirstFragment();
            case 1: return new SecondFragment();
            case 2: return new ThirdFragment();

            default: return   new FirstFragment();
        }
    }

    @Override
    public int getCount() {
        return 3;
    }
}