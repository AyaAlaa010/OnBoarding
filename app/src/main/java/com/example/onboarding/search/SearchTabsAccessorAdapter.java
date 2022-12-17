package com.example.onboarding.search;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.onboarding.search.Flight.FlightFragment;


public class SearchTabsAccessorAdapter extends FragmentStateAdapter {
    public SearchTabsAccessorAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
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
                return new AwardFragment();
            default:
                return null;


        }
    }

    @Override
    public int getItemCount() {
        return 5;
    }

}
