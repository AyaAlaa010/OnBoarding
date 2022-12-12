package com.example.onboarding.ui.home;

import android.graphics.Color;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.example.onboarding.R;
import com.example.onboarding.databinding.ActivityMainBinding;
import com.example.onboarding.search.SearchFragment;
import com.google.android.material.tabs.TabLayout;


public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
  //  private NavController navController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
      //  navController= Navigation.findNavController(view);

        setBottomTaps();
    }
    private void setBottomTaps() {


        binding.mainTabsBottom.addTab(binding.mainTabsBottom.newTab().setIcon(R.drawable.ic_baseline_home_24));
        binding.mainTabsBottom.addTab(binding.mainTabsBottom.newTab().setIcon(R.drawable.ic_baseline_search_24));
        binding.mainTabsBottom.addTab(binding.mainTabsBottom.newTab().setIcon(R.drawable.ic_baseline_favorite_border_24));
        binding.mainTabsBottom.addTab(binding.mainTabsBottom.newTab().setIcon(R.drawable.menu));


        binding.mainTabsBottom.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                binding.mainTabsBottom.setSelectedTabIndicatorColor(Color.parseColor("#88449CE1"));
                //  viewPager.setCurrentItem(tab.getPosition());
                if (tab.getPosition() == 0) {

                    tab.setIcon(R.drawable.ic_baseline_home_24);
                    tab.setText("Home");
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.fragmentContainerView3, new HomeFragment()).commit();


                }
                else if (tab.getPosition() == 1) {

                    tab.setIcon(R.drawable.ic_baseline_search_24);
                    tab.setText("Search");
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.fragmentContainerView3, new SearchFragment ()).commit();
                  //  navController.navigate(R.id.action_mainFragment_to_searchFragment);


                }
                //  startActivity(new Intent(MainActivity.this, RegisterActivity.class));
                else if (tab.getPosition() == 2) {

                    tab.setIcon(R.drawable.ic_baseline_favorite_border_24);
                    tab.setText("Saved");

                }
                else if (tab.getPosition() == 3) {

                    tab.setIcon(R.drawable.menu_change_tab);

                }

            }


            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                if (tab.getPosition() == 0) {

                    tab.setIcon(R.drawable.ic_baseline_home_24);
                    tab.setText("");


                }
                else if (tab.getPosition() == 1) {

                    tab.setIcon(R.drawable.ic_baseline_search_24);
                    tab.setText("");

                }
                //  startActivity(new Intent(MainActivity.this, RegisterActivity.class));
                else if (tab.getPosition() == 2) {

                    tab.setIcon(R.drawable.ic_baseline_favorite_border_24);
                    tab.setText("");

                }
                else if (tab.getPosition() == 3) {

                    tab.setIcon(R.drawable.menu);

                }

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

}