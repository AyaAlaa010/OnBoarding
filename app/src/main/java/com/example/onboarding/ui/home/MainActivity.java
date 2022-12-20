package com.example.onboarding.ui.home;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.navigation.NavController;
import androidx.navigation.NavHostController;
import androidx.navigation.Navigation;

import com.example.onboarding.R;
import com.example.onboarding.databinding.ActivityMainBinding;
import com.example.onboarding.favourite.FavouriteFragment;
import com.example.onboarding.search.Flight.FlightDetailsFragment;
import com.example.onboarding.search.HouseFragment;
import com.example.onboarding.search.SearchFragment;
import com.example.onboarding.settings.SettingsFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.tabs.TabLayout;


public class MainActivity extends AppCompatActivity  implements BottomNavigationView.OnNavigationItemSelectedListener{
    private ActivityMainBinding binding;

 BottomNavigationView bottomNavigationView; // TODO : DELETE THIS
    private NavController navController;
    private MainFragment mainFragment;
    private SearchFragment searchFragment;
    private FavouriteFragment favouriteFragment;
    private SettingsFragment settingsFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        bottomNavigationView = findViewById(R.id.bottomNavigationView);
       // navController = Navigation.findNavController(this,R.id.navigation_main_graph);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
        bottomNavigationView.setSelectedItemId(R.id.home);


        //setBottomTaps();

    }

    private void setUpNavBar() {
//        bottomNavigationView.nav
//        navController.setNavigatorProvider(bottomNavigationView);
//        setupActionBarWithNavController(controller)   // TODO : DELETE THIS
    }




        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            mainFragment=new MainFragment();
            searchFragment=new SearchFragment();
            favouriteFragment=new FavouriteFragment();
            settingsFragment=new SettingsFragment();
            switch (item.getItemId()) {
                case R.id.home:
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainerView3, mainFragment).commit();
                    return true;
                case R.id.search:
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainerView3, searchFragment).commit();
                    return true;
                case R.id.favourite:
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainerView3, favouriteFragment).commit();
                    return true;
                case R.id.menu:
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainerView3, settingsFragment).commit();
                    return true;
            }
            return false;
        }


//    private void setBottomTaps() {
//
//
//        setTabsTitle();
//
//        binding.mainTabsBottom.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
//            @Override
//            public void onTabSelected(TabLayout.Tab tab) {
//                binding.mainTabsBottom.setSelectedTabIndicatorColor(getResources ().getColor (R.color.app_color_trasparency));
//                setTabSelectedActions(tab);
//            }
//
//
//            @Override
//            public void onTabUnselected(TabLayout.Tab tab) {
//                setTabUnSelectedActions(tab);
//            }
//
//            @Override
//            public void onTabReselected(TabLayout.Tab tab) {
//
//            }
//        });
//    }
//
//    private void setTabsTitle() {
//
//
//        binding.mainTabsBottom.addTab(binding.mainTabsBottom.newTab().setIcon(R.drawable.ic_baseline_home_24).setText("Home"));
//
//
//        binding.mainTabsBottom.addTab(binding.mainTabsBottom.newTab().setIcon(R.drawable.ic_baseline_search_24));
//
//
//        binding.mainTabsBottom.addTab(binding.mainTabsBottom.newTab().setIcon(R.drawable.ic_baseline_favorite_border_24));
//
//
//        binding.mainTabsBottom.addTab(binding.mainTabsBottom.newTab().setIcon(R.drawable.menu));
//
//    }
//
//    private void setTabUnSelectedActions(TabLayout.Tab tab) {
//
//
//        if (tab.getPosition() == 0) {
//
//            tab.setIcon(R.drawable.home_gray_icon);
//            tab.setText("");
//
//
//        } else if (tab.getPosition() == 1) {
//
//            tab.setIcon(R.drawable.search);
//            tab.setText("");
//
//        }
//        else if (tab.getPosition() == 2) {
//
//            tab.setIcon(R.drawable.ic_baseline_favorite_border_24);
//            tab.setText("");
//
//        } else if (tab.getPosition() == 3) {
//
//            tab.setIcon(R.drawable.menu);
//
//        }
//
//
//    }
//
//    private void setTabSelectedActions(TabLayout.Tab tab) {
//
//        if (tab.getPosition() == 0) {
//            tab.setIcon(R.drawable.ic_baseline_home_24);
//            tab.setText("Home");
//
//            getSupportFragmentManager().beginTransaction()
//                    .add(R.id.fragmentContainerView3, mainFragment).commit();
//
//
//        } else if (tab.getPosition() == 1) {
//            tab.setIcon(R.drawable.ic_baseline_search_24);
//            tab.setText("Search");
//
//            getSupportFragmentManager().beginTransaction()
//                    .add(R.id.fragmentContainerView3, searchFragment).commit();
//
//        }
//        else if (tab.getPosition() == 2) {
//
//            tab.setIcon(R.drawable.ic_baseline_favorite_border_24);
//            tab.setText("Saved");
//            getSupportFragmentManager().beginTransaction()
//                    .add(R.id.fragmentContainerView3,favouriteFragment).commit();
//
//
//        } else if (tab.getPosition() == 3) {
//
//            tab.setIcon(R.drawable.menu_change_tab);
//            getSupportFragmentManager().beginTransaction()
//                    .add(R.id.fragmentContainerView3, settingsFragment).commit();
//
//        }
//
//    }

//    @Override
//    public void onBackPressed() {

//        FragmentManager fm =  getSupportFragmentManager();
//        Fragment fragInstance = fm.findFragmentById(R.id.fragmentContainerView3);
//        if (2 + 2000 > System.currentTimeMillis()) {
//            super.onBackPressed();
//            finish();
//        } else {
//
//        if (fragInstance instanceof FlightDetailsFragment){
//
//            getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainerView3,searchFragment).commit();
//            fm.popBackStack();
//
//        }
//
//
//        }
        /////////
//            getSupportFragmentManager().beginTransaction()
//                    .replace(R.id.fragmentContainerView3, mainFragment).commit();
//            Toast.makeText(
//                    MainActivity.this,
//                    "FirstFragment found",
//                    Toast.LENGTH_SHORT
//            ).show();
//            Toast.makeText(getBaseContext(), "Press back again to exit", Toast.LENGTH_SHORT).show();


        //  super.onBackPressed();
//        moveTaskToBack(true);
//        FragmentManager fm =  getSupportFragmentManager();
//        Fragment fragInstance = fm.findFragmentById(R.id.fragmentContainerView3);
//        if (fragInstance instanceof FlightDetailsFragment){
//
//            Toast.makeText(
//                    MainActivity.this,
//                    "FirstFragment found",
//                    Toast.LENGTH_SHORT
//            ).show();
//            getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainerView3, houseFragment).commit();
//            fm.popBackStack();
//            getSupportFragmentManager().beginTransaction()
//                    .replace(R.id.fragmentContainerView3, new MainFragment()).commit();
//            Toast.makeText(
//                    MainActivity.this,
//                    "FirstFragment found",
//                    Toast.LENGTH_SHORT
//            ).show();
        // }
        //super.onBackPressed();
//
//        NavController navController = Navigation.findNavController(this, R.id.navigation_main_graph);
//        navController.addOnDestinationChangedListener((navController1, navDestination, bundle) ->
//
//    {
//
//        Log.i("TAGgg", "onBackPressed: nav" + navDestination);
//
//        if (navDestination.getId() == R.id.flightDetailsFragment) {
//            Toast.makeText(
//                    MainActivity.this,
//                    "FirstFragment found",
//                    Toast.LENGTH_SHORT
//            ).show();
//            Log.i("TAGgg", "onBackPressed: nav" + navDestination);
//           navController.navigateUp();
////
//        }
//
//
//    }
//
//    );}}

//            else if (navDestination.getId() == R.id.flightFragment) {
//                Log.i("TAGgg", "onBackPressed: nav" + navDestination);
//                navController.navigateUp();
//
//
//            }
//            else if (navDestination.getId() == R.id.searchFragment) {
//                Log.i("TAGgg", "onBackPressed: nav" + navDestination);
//                navController.navigateUp();
//
//
//                NavController navControllerFlight = Navigation.findNavController(this, R.id.flight_nav);
//
//                navControllerFlight.addOnDestinationChangedListener((navController3, navDestination3, bundle3) -> {
//                    if (navDestination.equals(R.id.flightDetailsFragment3)) {
//
//                        Fragment fragment = getSupportFragmentManager().findFragmentByTag("TAG_FRAGMENT");
//                        if (fragment != null)
//                            getSupportFragmentManager().beginTransaction().remove(fragment).commit();
//
//                    }
//
//
//                });
//
//
//            }


        //   });

        // }
  //  }
}