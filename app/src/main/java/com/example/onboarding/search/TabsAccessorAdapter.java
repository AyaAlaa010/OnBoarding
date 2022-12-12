package com.example.onboarding.search;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;



public class TabsAccessorAdapter extends FragmentStateAdapter {
    public TabsAccessorAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 0:
                return new FlightFragment();
            case 1:
                return  new HouseFragment();
            case 2:
                return new BedFragment();
            case 3:
                return new CarFragment();
            case 4:
                return new LocationFragment();
            default:
                return null;


        }
    }

    @Override
    public int getItemCount() {
        return 5;
    }

}
