package com.example.onboarding.search;

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
        binding.mainTabs.addTab(binding.mainTabs.newTab().setIcon(R.drawable.flight));
        binding.mainTabs.addTab(binding.mainTabs.newTab().setIcon(R.drawable.home_icone));
        binding.mainTabs.addTab(binding.mainTabs.newTab().setIcon(R.drawable.bed));
        binding.mainTabs.addTab(binding.mainTabs.newTab().setIcon(R.drawable.car));
        binding.mainTabs.addTab(binding.mainTabs.newTab().setIcon(R.drawable.location));


    }

    private void setTabSelectedActions(TabLayout.Tab tab) {


        if (tab.getPosition() == 0) {

            binding.imgBackground.setImageDrawable(getResources().getDrawable(R.drawable.background));


        } else if (tab.getPosition() == 1) {

            binding.imgBackground.setImageDrawable(getResources().getDrawable(R.drawable.slide2));


        } else if (tab.getPosition() == 2) {

            binding.imgBackground.setImageDrawable(getResources().getDrawable(R.drawable.slid3));


        } else if (tab.getPosition() == 3) {


            binding.imgBackground.setImageDrawable(getResources().getDrawable(R.drawable.slid1));


        } else if (tab.getPosition() == 4) {

            binding.btnFind.setBackground(getResources().getDrawable(R.drawable.brown_btn));

            binding.imgBackground.setImageDrawable(getResources().getDrawable(R.drawable.slide2));

        }


    }


}
