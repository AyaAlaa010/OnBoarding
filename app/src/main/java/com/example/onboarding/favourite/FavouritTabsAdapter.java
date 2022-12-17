package com.example.onboarding.favourite;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class FavouritTabsAdapter extends FragmentStateAdapter {
    public FavouritTabsAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 0:
                return new BookingsFragment();
            case 1:
                return  new SavedFragment();
            default:
                return new BookingsFragment();


        }
    }

    @Override
    public int getItemCount() {
        return 2;
    }

}
