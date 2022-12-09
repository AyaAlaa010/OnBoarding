package com.example.onboarding;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import com.example.onboarding.databinding.ActivityMainBinding;
import com.google.android.material.tabs.TabLayout;

//not used
public class MainActivity extends AppCompatActivity {
private ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil. setContentView(this,R.layout.activity_main);
        setBottomTaps();
    }

    private void setBottomTaps(){


        binding.mainTabsBottom.addTab( binding.mainTabsBottom.newTab().setIcon(R.drawable.ic_baseline_home_24));
        binding.mainTabsBottom.addTab( binding.mainTabsBottom.newTab().setIcon(R.drawable.ic_baseline_search_24));
        binding.mainTabsBottom.addTab( binding.mainTabsBottom.newTab().setIcon(R.drawable.ic_baseline_favorite_border_24));
        binding.mainTabsBottom.addTab( binding.mainTabsBottom.newTab().setIcon(R.drawable.menu));


        binding.mainTabsBottom.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                binding.mainTabsBottom.setSelectedTabIndicatorColor(Color.parseColor("#88449CE1"));
                //  viewPager.setCurrentItem(tab.getPosition());
                if(tab.getPosition()==2){}
                  //  startActivity(new Intent(MainActivity.this, RegisterActivity.class));


            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {


            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });


    }
}