package com.example.onboarding.ui.home;

import static android.content.ContentValues.TAG;

import android.app.FragmentManager;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.example.onboarding.R;
import com.example.onboarding.databinding.ActivityMainBinding;
import com.example.onboarding.favourite.FavouriteFragment;
import com.example.onboarding.search.Flight.Ticket.SuccessfulFlightBookingFragment;
import com.example.onboarding.search.SearchFragment;
import com.example.onboarding.settings.SettingsFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import net.yslibrary.android.keyboardvisibilityevent.KeyboardVisibilityEvent;
import net.yslibrary.android.keyboardvisibilityevent.KeyboardVisibilityEventListener;


public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {
    private ActivityMainBinding binding;

    BottomNavigationView bottomNavigationView;
    private MainFragment mainFragment;
    private SearchFragment searchFragment;
    private FavouriteFragment favouriteFragment;
    private SettingsFragment settingsFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
        bottomNavigationView.setSelectedItemId(R.id.home);

        setNavigationVisibilityForKeyboard();


    }


private void setNavigationVisibilityForKeyboard(){


    KeyboardVisibilityEvent.setEventListener(
            this,
            new KeyboardVisibilityEventListener() {
                @Override
                public void onVisibilityChanged(boolean isOpen) {
                    Log.d(TAG,"onVisibilityChanged: Keyboard visibility changed");
                    if(isOpen){
                        Log.d(TAG, "onVisibilityChanged: Keyboard is open");
                        bottomNavigationView.setVisibility(View.GONE);
                        Log.d(TAG, "onVisibilityChanged: NavBar got Invisible");
                    }else{
                        Log.d(TAG, "onVisibilityChanged: Keyboard is closed");
                        bottomNavigationView.setVisibility(View.VISIBLE);
                        Log.d(TAG, "onVisibilityChanged: NavBar got Visible");
                    }
                }
            });


}

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        mainFragment = new MainFragment();
        searchFragment = new SearchFragment();
        favouriteFragment = new FavouriteFragment();
        settingsFragment = new SettingsFragment();
        switch (item.getItemId()) {
            case R.id.home:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainerView3, mainFragment).commit();
                return true;
            case R.id.search:
                getSupportFragmentManager().beginTransaction().add(R.id.fragmentContainerView3, searchFragment).addToBackStack(null).commit();
                return true;
            case R.id.favourite:
                getSupportFragmentManager().beginTransaction().add(R.id.fragmentContainerView3, favouriteFragment).addToBackStack(null).commit();
                return true;
            case R.id.menu:
                getSupportFragmentManager().beginTransaction().add(R.id.fragmentContainerView3, settingsFragment).addToBackStack(null).commit();
                return true;
        }
        return false;
    }

    @Override
    public void onBackPressed() {

        FragmentManager fm = getFragmentManager();
        if (fm.getBackStackEntryCount() > 0) {
            Log.i("MainActivity", "popping backstack");
            fm.popBackStack();

        } else {
            super.onBackPressed();


        }
    }


    // TODO : DELETE THIS
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
//            @Override  // TODO : DELETE THIS
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
//  // TODO : DELETE THIS
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
    // TODO : DELETE THIS
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
//  // TODO : DELETE THIS

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