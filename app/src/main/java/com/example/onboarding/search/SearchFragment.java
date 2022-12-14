package com.example.onboarding.search;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.onboarding.R;
import com.example.onboarding.databinding.FragmentSearchBinding;
import com.google.android.material.tabs.TabLayout;


public class SearchFragment extends Fragment {
    private FragmentSearchBinding binding;


    private TabsAccessorAdapter tabsAccessorAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_search, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        tabsAccessorAdapter = new TabsAccessorAdapter(fragmentManager, getLifecycle());
        binding.mainTabsPager.setAdapter(tabsAccessorAdapter);
        addTabs();

    }


    private void addTabs() {

        setTabsTitles();


        binding.mainTabs.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

                binding.mainTabsPager.setCurrentItem(tab.getPosition());
                setTabSelectedActions(tab);

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

                setTabUnSelectedActions(tab);
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        binding.mainTabsPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);

                binding.mainTabs.selectTab(binding.mainTabs.getTabAt(position));
            }
        });

    }

    private void setTabsTitles() {
        binding.mainTabs.addTab(binding.mainTabs.newTab().setIcon(R.drawable.plane_up_solid_1));
        binding.mainTabs.addTab(binding.mainTabs.newTab().setIcon(R.drawable.hotel_solid_1));
        binding.mainTabs.addTab(binding.mainTabs.newTab().setIcon(R.drawable.bed_solid));
        binding.mainTabs.addTab(binding.mainTabs.newTab().setIcon(R.drawable.car_solid_1));
        binding.mainTabs.addTab(binding.mainTabs.newTab().setIcon(R.drawable.award_solid_1));


    }

    private void setTabSelectedActions(TabLayout.Tab tab) {


        if (tab.getPosition() == 0) {
           tab.setIcon(R.drawable.plane_up_solid_1);

            tab.getIcon().setColorFilter(ContextCompat.getColor(this.getContext(), android.R.color.white),
                    PorterDuff.Mode.MULTIPLY);

            binding.imgBackground.setImageDrawable(getResources().getDrawable(R.drawable.background));


        } else if (tab.getPosition() == 1) {

            tab.setIcon(R.drawable.hotel_solid_1);

            tab.getIcon().setColorFilter(ContextCompat.getColor(this.getContext(), android.R.color.white),
                    PorterDuff.Mode.MULTIPLY);
            binding.imgBackground.setImageDrawable(getResources().getDrawable(R.drawable.slide2));


        } else if (tab.getPosition() == 2) {
            tab.setIcon(R.drawable.bed_solid);

            tab.getIcon().setColorFilter(ContextCompat.getColor(this.getContext(), android.R.color.white),
                    PorterDuff.Mode.MULTIPLY);
            binding.imgBackground.setImageDrawable(getResources().getDrawable(R.drawable.slid3));


        } else if (tab.getPosition() == 3) {
            tab.setIcon(R.drawable.car_solid_1);

            tab.getIcon().setColorFilter(ContextCompat.getColor(this.getContext(), android.R.color.white),
                    PorterDuff.Mode.MULTIPLY);

            binding.imgBackground.setImageDrawable(getResources().getDrawable(R.drawable.slid1));


        } else if (tab.getPosition() == 4) {
            tab.setIcon(R.drawable.award_solid_1);

            tab.getIcon().setColorFilter(ContextCompat.getColor(this.getContext(), android.R.color.white),
                    PorterDuff.Mode.MULTIPLY);

            binding.btnFind.setBackground(getResources().getDrawable(R.drawable.brown_btn));
            binding.btnFind.setTextColor(Color.parseColor("#E5C063"));
            binding.imgBackground.setImageDrawable(getResources().getDrawable(R.drawable.slide2));

        }


    }
    private void setTabUnSelectedActions(TabLayout.Tab tab) {


        if (tab.getPosition() == 0) {
           tab.setIcon(R.drawable.plane_up_solid_1);


        } else if (tab.getPosition() == 1) {
            tab.setIcon(R.drawable.hotel_solid_1);




        } else if (tab.getPosition() == 2) {
            tab.setIcon(R.drawable.bed_solid);


        } else if (tab.getPosition() == 3) {


            tab.setIcon(R.drawable.car_solid_icon_white);


        } else if (tab.getPosition() == 4) {
            tab.setIcon(R.drawable.award_solid_1);
            binding.btnFind.setTextColor(Color.parseColor("#FFFFFF"));

            binding.btnFind.setBackground(getResources().getDrawable(R.drawable.btn_green_layout));


        }


    }



}
