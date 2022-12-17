package com.example.onboarding.favourite;

import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.onboarding.R;
import com.example.onboarding.databinding.FragmentFavouriteBinding;
import com.google.android.material.tabs.TabLayout;

import java.util.List;


public class FavouriteFragment extends Fragment {
    private FragmentFavouriteBinding binding;

    private FavouritTabsAdapter adapter;
    private List<FavouriteModel> favouritesList;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_favourite, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        adapter = new FavouritTabsAdapter(fragmentManager, getLifecycle());
        binding.favTabsPager.setAdapter(adapter);
        addTabs();
    }
    private void addTabs() {

        setTabsTitles();


        binding.favTabs.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                binding.favTabsPager.setCurrentItem(tab.getPosition());


            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        binding.favTabsPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);

                binding.favTabs.selectTab(binding.favTabs.getTabAt(position));
            }
        });

    }

    private void setTabsTitles() {
        binding.favTabs.addTab(binding.favTabs.newTab().setText(R.string.bookings));
        binding.favTabs.addTab(binding.favTabs.newTab().setText(R.string.saved));
        binding.favTabs.setSelectedTabIndicatorColor(getResources().getColor(R.color.app_color));
//        binding.favTabs.setSelectedTabIndicatorHeight((int) (5 * getResources().getDisplayMetrics().density));
//        binding.favTabs.setTabTextColors(Color.parseColor("#727272"), Color.parseColor("#ffffff"));
    }
}