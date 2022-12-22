package com.example.onboarding.search;

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
import android.view.animation.TranslateAnimation;
import android.widget.Toast;
import com.example.onboarding.R;
import com.example.onboarding.databinding.FragmentSearchBinding;
import com.example.onboarding.search.Flight.FlightDetailsFragment;
import com.example.onboarding.search.Flight.SearchDetailsBottomSheet;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.tabs.TabLayout;


public class SearchFragment extends Fragment {
    private FragmentSearchBinding binding;
    private  static int fragmentCounter=0;
    //View bottomSheet;
   // BottomSheetBehavior mBottomSheetBehavior1;
    private SearchTabsAccessorAdapter tabsAccessorAdapter;
  //  private NavController navController;

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
      //  navController= Navigation.findNavController(view);
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        tabsAccessorAdapter = new SearchTabsAccessorAdapter(fragmentManager, getLifecycle());
        binding.mainTabsPager.setAdapter(tabsAccessorAdapter);
//         bottomSheet = view.findViewById(R.id.bottom_sheet_view);

        addTabs(binding.mainTabs);
       // addTabs(binding.mainTabsFlightDetails);

        setViewsAction();
        //addTabs(binding.mainTabs,valuePostion);

    }

    private void setViewsAction() {
        binding.btnFind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                switch (fragmentCounter){

                    case 0:  {
                        getActivity().getSupportFragmentManager().beginTransaction().add(R.id.fragmentContainerView3, new FlightDetailsFragment()).commit();


                        //setFlightsBottomSheet();


                        break;
                    }
                    case 1:  {
                        Toast.makeText(getContext(),"1",Toast.LENGTH_LONG).show();

                        break;
                    } case 2:  {
                        Toast.makeText(getContext(),"2",Toast.LENGTH_LONG).show();

                        break;
                    } case 3:  {
                        Toast.makeText(getContext(),"3",Toast.LENGTH_LONG).show();

                        break;
                    }
                    case 4:  {
                        Toast.makeText(getContext(),"4",Toast.LENGTH_LONG).show();

                        break;
                    }




                }



            }
        });







    }

    private void setFlightsBottomSheet() {
        SearchDetailsBottomSheet bottomSheet = new SearchDetailsBottomSheet();
        bottomSheet.show(getActivity().getSupportFragmentManager(),
                "ModalBottomSheet");
//        mBottomSheetBehavior1 = BottomSheetBehavior.from(bottomSheet);
//        mBottomSheetBehavior1.setState(BottomSheetBehavior.STATE_EXPANDED);
//
//        slideToTop(bottomSheet);

    }
    public static void slideToBottom(View view){
        TranslateAnimation animate = new TranslateAnimation(0,0,0,view.getHeight());
        animate.setDuration(500);
        animate.setFillAfter(true);
        view.startAnimation(animate);
        view.setVisibility(View.GONE);
    }

    public static void slideToTop(View view){
        TranslateAnimation animate = new TranslateAnimation(0,0,view.getHeight(),0);
        animate.setDuration(500);
        animate.setFillAfter(true);
        view.startAnimation(animate);
        view.setVisibility(View.VISIBLE);
    }

    private void addTabs(TabLayout tabLayout ) {

        setTabsTitles(tabLayout);


        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
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

              tabLayout.selectTab(tabLayout.getTabAt(position));
            }
        });

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
            fragmentCounter=0;
           // setSearchTabsView();

            tab.setIcon(R.drawable.plane_up_solid_1);

            tab.getIcon().setColorFilter(ContextCompat.getColor(this.getContext(), android.R.color.white),
                    PorterDuff.Mode.MULTIPLY);

            binding.imgBackground.setImageDrawable(getResources().getDrawable(R.drawable.background));


        } else if (tab.getPosition() == 1) {

            fragmentCounter=1;
           // setSearchTabsView();

            tab.setIcon(R.drawable.hotel_solid_1);
            tab.getIcon().setColorFilter(ContextCompat.getColor(this.getContext(), android.R.color.white),
                    PorterDuff.Mode.MULTIPLY);
            binding.imgBackground.setImageDrawable(getResources().getDrawable(R.drawable.slide2));


        } else if (tab.getPosition() == 2) {

            fragmentCounter=2;
           // setSearchTabsView();

            tab.setIcon(R.drawable.bed_solid);

            tab.getIcon().setColorFilter(ContextCompat.getColor(this.getContext(), android.R.color.white),
                    PorterDuff.Mode.MULTIPLY);
            binding.imgBackground.setImageDrawable(getResources().getDrawable(R.drawable.slid3));


        } else if (tab.getPosition() == 3) {
            fragmentCounter=3;
          //  setSearchTabsView();

            tab.setIcon(R.drawable.car_solid_1);

            tab.getIcon().setColorFilter(ContextCompat.getColor(this.getContext(), android.R.color.white),
                    PorterDuff.Mode.MULTIPLY);

            binding.imgBackground.setImageDrawable(getResources().getDrawable(R.drawable.slid1));


        } else if (tab.getPosition() == 4) {
            fragmentCounter=4;
           // setSearchTabsView();

            tab.setIcon(R.drawable.award_solid_1);

            tab.getIcon().setColorFilter(ContextCompat.getColor(this.getContext(), android.R.color.white),
                    PorterDuff.Mode.MULTIPLY);

            binding.btnFind.setBackground(getResources().getDrawable(R.drawable.second_color_btn));
            binding.btnFind.setTextColor(getResources().getColor(R.color.award_color));
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
            binding.btnFind.setTextColor(getResources().getColor(R.color.white));

            binding.btnFind.setBackground(getResources().getDrawable(R.drawable.btn_third_color_layout));


        }


    }
//    private void setTabsDetailsView(){
//
//        binding.linearFragmentSearch.setVisibility(View.INVISIBLE);
//        binding.linearFragmentSearchDetails.setVisibility(View.VISIBLE);
//       // binding.linearFragmentSearch.setBackground(getResources().getDrawable(R.drawable.tab_layout_gray));
////        ConstraintLayout.LayoutParams lp = (ConstraintLayout.LayoutParams)  binding.linearFragmentSearch.getLayoutParams();
////        binding.linearSearchTotal.setBackgroundColor(getResources().getColor(R.color.gray));
//        binding.imgBackground.setImageDrawable(getResources().getDrawable(R.drawable.app_color_image));
//        binding.mainTabs.setVisibility(View.INVISIBLE);
//        binding.mainTabsFlightDetails.setVisibility(View.VISIBLE);
//
//    }
//    private void setSearchTabsView(){
//        binding.linearFragmentSearch.setVisibility(View.VISIBLE);
//        binding.linearFragmentSearchDetails.setVisibility(View.INVISIBLE);
//        binding.mainTabs.setVisibility(View.VISIBLE);
//        binding.mainTabsFlightDetails.setVisibility(View.INVISIBLE);
//
//    }



}
