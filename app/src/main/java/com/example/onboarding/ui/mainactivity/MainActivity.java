package com.example.onboarding.ui.mainactivity;

import android.graphics.Color;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.example.onboarding.R;
import com.example.onboarding.databinding.ActivityMainBinding;
import com.example.onboarding.ui.mainactivity.imageslider.SliderAdapter;
import com.example.onboarding.ui.mainactivity.imageslider.SliderItem;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private SliderAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        setBottomTaps();

        setTopCitiesSlider();
        setTopHotelsSlider();
        setFeaturesSlider();

    }

    private void setTopCitiesSlider() {

        adapter = new SliderAdapter(this);
        List<SliderItem> sliderItemList = new ArrayList<>();
        //dummy data
        sliderItemList.add(new SliderItem("Dubai", "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley ...", R.drawable.slid1));
        sliderItemList.add(new SliderItem("Alex", "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley ...", R.drawable.slide2));
        sliderItemList.add(new SliderItem("Cairo", "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley ...", R.drawable.slid3));

        adapter.renewItems(sliderItemList);
        binding.imageSlider.setSliderAdapter(adapter);
        binding.imageSlider.setIndicatorAnimation(IndicatorAnimationType.WORM); //set indicator animation by using SliderLayout.IndicatorAnimations. :WORM or THIN_WORM or COLOR or DROP or FILL or NONE or SCALE or SCALE_DOWN or SLIDE and SWAP!!
        binding.imageSlider.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION);
        binding.imageSlider.setAutoCycleDirection(SliderView.AUTO_CYCLE_DIRECTION_BACK_AND_FORTH);
        binding.imageSlider.setIndicatorSelectedColor(Color.WHITE);
        binding.imageSlider.setIndicatorUnselectedColor(Color.GRAY);
        binding.imageSlider.setScrollTimeInSec(3);
        binding.imageSlider.setAutoCycle(true);
        binding.imageSlider.startAutoCycle();


    }


    private void setTopHotelsSlider() {

        adapter = new SliderAdapter(this);


        List<SliderItem> sliderItemList = new ArrayList<>();
        //dummy data
        sliderItemList.add(new SliderItem("Plaza", "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley ...", R.drawable.slid1));
        sliderItemList.add(new SliderItem("Armada", "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley ...", R.drawable.slide2));
        sliderItemList.add(new SliderItem("Azizi", "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley ...", R.drawable.slid3));

        adapter.renewItems(sliderItemList);
        binding.imageSliderHotels.setSliderAdapter(adapter);
        binding.imageSliderHotels.setIndicatorAnimation(IndicatorAnimationType.WORM); //set indicator animation by using SliderLayout.IndicatorAnimations. :WORM or THIN_WORM or COLOR or DROP or FILL or NONE or SCALE or SCALE_DOWN or SLIDE and SWAP!!
        binding.imageSliderHotels.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION);
        binding.imageSliderHotels.setAutoCycleDirection(SliderView.AUTO_CYCLE_DIRECTION_BACK_AND_FORTH);
        binding.imageSliderHotels.setIndicatorSelectedColor(Color.WHITE);
        binding.imageSliderHotels.setIndicatorUnselectedColor(Color.GRAY);
        binding.imageSliderHotels.setScrollTimeInSec(3);
        binding.imageSliderHotels.setAutoCycle(true);
        binding.imageSliderHotels.startAutoCycle();


    }

    private void setFeaturesSlider() {

        adapter = new SliderAdapter(this);


        List<SliderItem> sliderItemList = new ArrayList<>();
        //dummy data
        sliderItemList.add(new SliderItem("Feature1", "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley ...", R.drawable.slid1));
        sliderItemList.add(new SliderItem("Feature2", "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley ...", R.drawable.slide2));
        sliderItemList.add(new SliderItem("Feature3", "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley ...", R.drawable.slid3));

        adapter.renewItems(sliderItemList);
        binding.imageSliderFeatured.setSliderAdapter(adapter);
        binding.imageSliderFeatured.setIndicatorAnimation(IndicatorAnimationType.WORM); //set indicator animation by using SliderLayout.IndicatorAnimations. :WORM or THIN_WORM or COLOR or DROP or FILL or NONE or SCALE or SCALE_DOWN or SLIDE and SWAP!!
        binding.imageSliderFeatured.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION);
        binding.imageSliderFeatured.setAutoCycleDirection(SliderView.AUTO_CYCLE_DIRECTION_BACK_AND_FORTH);
        binding.imageSliderFeatured.setIndicatorSelectedColor(Color.WHITE);
        binding.imageSliderFeatured.setIndicatorUnselectedColor(Color.GRAY);
        binding.imageSliderFeatured.setScrollTimeInSec(3);
        binding.imageSliderFeatured.setAutoCycle(true);
        binding.imageSliderFeatured.startAutoCycle();


    }


    private void setBottomTaps() {


        binding.mainTabsBottom.addTab(binding.mainTabsBottom.newTab().setIcon(R.drawable.ic_baseline_home_24));
        binding.mainTabsBottom.addTab(binding.mainTabsBottom.newTab().setIcon(R.drawable.ic_baseline_search_24));
        binding.mainTabsBottom.addTab(binding.mainTabsBottom.newTab().setIcon(R.drawable.ic_baseline_favorite_border_24));
        binding.mainTabsBottom.addTab(binding.mainTabsBottom.newTab().setIcon(R.drawable.menu));


        binding.mainTabsBottom.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
              // binding.mainTabsBottom.setSelectedTabIndicatorColor(Color.parseColor("#88449CE1"));
                //  viewPager.setCurrentItem(tab.getPosition());
                if (tab.getPosition() == 0) {

                    tab.setIcon(R.drawable.ic_baseline_home_24);
                    tab.setText("Home");


                }
                else if (tab.getPosition() == 1) {

                    tab.setIcon(R.drawable.ic_baseline_search_24);
                    tab.setText("Search");

                }
                //  startActivity(new Intent(MainActivity.this, RegisterActivity.class));
               else if (tab.getPosition() == 2) {

                    tab.setIcon(R.drawable.ic_baseline_favorite_border_24);
                    tab.setText("Saved");

                }

            }


            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                if (tab.getPosition() == 0) {

                    tab.setIcon(R.drawable.ic_baseline_home_24);
                    tab.setText("Home");


                }
                else if (tab.getPosition() == 1) {

                    tab.setIcon(R.drawable.ic_baseline_search_24);
                    tab.setText("Search");

                }
                //  startActivity(new Intent(MainActivity.this, RegisterActivity.class));
                else if (tab.getPosition() == 2) {

                    tab.setIcon(R.drawable.ic_baseline_favorite_border_24);
                    tab.setText("Saved");

                }

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }


}