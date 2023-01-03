package com.example.onboarding.search.Flight;

import android.graphics.PorterDuff;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.onboarding.R;
import com.example.onboarding.databinding.FragmentFlightDetailsBinding;
import com.example.onboarding.search.SearchFragment;
import com.google.android.material.tabs.TabLayout;
import java.util.ArrayList;
import java.util.List;

//flights list
public class FlightDetailsFragment extends Fragment {

private FragmentFlightDetailsBinding binding;
    private List<FlightModel> flightList;
    private FlightsAdapter adapter;
   private NavController navController;
    ItemFlightImp itemFlightImp;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_flight_details, container, false);
        return binding.getRoot();    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        navController= Navigation.findNavController(view);
        addTabs(binding.mainTabsFlightDetails);
        setFlightListData();
        callItemFlightIMP();
        setAdapterToRecycler();
        setViewsAction();


    }

    private void setViewsAction() {


        binding.btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                navController.popBackStack();
               // getActivity().getSupportFragmentManager().beginTransaction().setCustomAnimations( R.anim.slide_out_top,R.anim.slide_in_bottom).remove(getActivity().getSupportFragmentManager().findFragmentByTag("details")).commit();


            }
        });
        binding.ivFilter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navController.navigate(R.id.action_flightDetailsFragment_to_flightsFilterFragment);

            }
        });

    }

    private void callItemFlightIMP(){

        itemFlightImp=new ItemFlightImp() {
            @Override
            public void navigateToConfirmFragment() {
                navController.navigate(R.id.action_flightDetailsFragment_to_fragmentConfirmation);

                //  getActivity().getSupportFragmentManager().beginTransaction().setCustomAnimations(R.anim.slide_in_bottom, R.anim.slide_out_top).add(R.id.nav_host_fragment, new FragmentConfirmation(),"confirmation").addToBackStack(null).commit();


            }
        };


    }


    private void setFlightListData(){

        flightList= new ArrayList<>();

        flightList.add(new FlightModel("6797","Dubai, United Arab Emirates 16.3 km from center"));
        flightList.add(new FlightModel("6797","Dubai, United Arab Emirates 16.3 km from center"));
        flightList.add(new FlightModel("6797","Dubai, United Arab Emirates 16.3 km from center"));
        flightList.add(new FlightModel("6797","Dubai, United Arab Emirates 16.3 km from center"));
        flightList.add(new FlightModel("6797","Dubai, United Arab Emirates 16.3 km from center"));
        flightList.add(new FlightModel("6797","Dubai, United Arab Emirates 16.3 km from center"));
        flightList.add(new FlightModel("6797","Dubai, United Arab Emirates 16.3 km from center"));
        flightList.add(new FlightModel("6797","Dubai, United Arab Emirates 16.3 km from center"));
        flightList.add(new FlightModel("6797","Dubai, United Arab Emirates 16.3 km from center"));
        flightList.add(new FlightModel("6797","Dubai, United Arab Emirates 16.3 km from center"));
        flightList.add(new FlightModel("6797","Dubai, United Arab Emirates 16.3 km from center"));
        flightList.add(new FlightModel("6797","Dubai, United Arab Emirates 16.3 km from center"));
        flightList.add(new FlightModel("6797","Dubai, United Arab Emirates 16.3 km from center"));
        flightList.add(new FlightModel("6797","Dubai, United Arab Emirates 16.3 km from center"));
        flightList.add(new FlightModel("6797","Dubai, United Arab Emirates 16.3 km from center"));
        flightList.add(new FlightModel("6797","Dubai, United Arab Emirates 16.3 km from center"));
        flightList.add(new FlightModel("6797","Dubai, United Arab Emirates 16.3 km from center"));



    }

    private void setAdapterToRecycler(){

        adapter = new FlightsAdapter(flightList,itemFlightImp);
        binding.recFlights.setAdapter(adapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(requireContext(), RecyclerView.VERTICAL, false);
        binding.recFlights.setLayoutManager(layoutManager);



    }


    private void addTabs(TabLayout tabLayout ) {

        setTabsTitles(tabLayout);


        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

                //binding.mainTabsPager.setCurrentItem(tab.getPosition());  // TODO : DELETE THIS

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

      //  binding.mainTabsPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
//            @Override
//            public void onPageSelected(int position) {  // TODO : DELETE THIS
//                super.onPageSelected(position);
//
//                tabLayout.selectTab(tabLayout.getTabAt(position));
//            }
//        });

    }

    private void setTabsTitles(TabLayout tabLayout) {
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.plane_up_solid_1));
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.hotel_solid_1));
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.bed_solid));
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.car_solid_1));
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.award_solid_1));


    }

    private void setTabSelectedActions(TabLayout.Tab tab) {

        if (tab.getPosition() == 0) {
           // fragmentCounter=0;

            tab.setIcon(R.drawable.plane_up_solid_1);
            tab.getIcon().setColorFilter(ContextCompat.getColor(this.getContext(), android.R.color.white), PorterDuff.Mode.MULTIPLY);
            joinFlightsTabWithSearchTabs("0");

        }
        else if (tab.getPosition() == 1) {

           // fragmentCounter=1;
            joinFlightsTabWithSearchTabs("1");
            tab.setIcon(R.drawable.hotel_solid_1);
            tab.getIcon().setColorFilter(ContextCompat.getColor(this.getContext(), android.R.color.white), PorterDuff.Mode.MULTIPLY);
            binding.imgBackground.setImageDrawable(getResources().getDrawable(R.drawable.slide2));
        }
        else if (tab.getPosition() == 2) {

            //fragmentCounter=2;
            tab.setIcon(R.drawable.bed_solid);
            tab.getIcon().setColorFilter(ContextCompat.getColor(this.getContext(), android.R.color.white), PorterDuff.Mode.MULTIPLY);
            joinFlightsTabWithSearchTabs("2");

        } else if (tab.getPosition() == 3) {
            //fragmentCounter=3;
            tab.setIcon(R.drawable.car_solid_1);
            tab.getIcon().setColorFilter(ContextCompat.getColor(this.getContext(), android.R.color.white), PorterDuff.Mode.MULTIPLY);
            joinFlightsTabWithSearchTabs("3");

        } else if (tab.getPosition() == 4) {
           // fragmentCounter=4;
            tab.setIcon(R.drawable.award_solid_1);
            tab.getIcon().setColorFilter(ContextCompat.getColor(this.getContext(), android.R.color.white), PorterDuff.Mode.MULTIPLY);
           joinFlightsTabWithSearchTabs("4");

        }


    }
    private void joinFlightsTabWithSearchTabs(String position){

//        SearchFragment searchFragment = new SearchFragment ();
//        Bundle args = new Bundle();
//        args.putString("position", position);
//        searchFragment.setArguments(args);
//        getFragmentManager().beginTransaction().replace(R.id.nav_host_fragment, searchFragment).commit();
        navController.popBackStack();

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


        }


    }

}