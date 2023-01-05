package com.example.onboarding.ui.home;

import static android.content.Context.MODE_PRIVATE;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.example.onboarding.R;
import com.example.onboarding.databinding.FragmentMainBinding;
import com.example.onboarding.registration.LoginRegisterActivity;
import com.example.onboarding.ui.home.imageslider.SliderAdapter;
import com.example.onboarding.ui.home.imageslider.SliderItem;
import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;
import java.util.List;


public class MainFragment extends Fragment {
    private FragmentMainBinding binding;
    private SliderAdapter adapter;
    private NavController navController;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_main, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
     navController= Navigation.findNavController(view);


        setTopCitiesSlider();
        setTopHotelsSlider();
        setFeaturesSlider();
        setViewsActions();
    }

    private void setViewsActions() {


        binding.userPicture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String   token = getActivity().getSharedPreferences("token", MODE_PRIVATE).getString("accessToken", "not exist");
               // Toast.makeText(getContext(),"you are already login",Toast.LENGTH_LONG).show();
               // if(token==null){

                startActivity(new Intent(requireContext(), LoginRegisterActivity.class));}
             // navController.navigate(R.id.action_mainFragment_to_loginRegisterFragment);

          //  }
        });

        binding.btnBussiness.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              // navController.navigate(R.id.action_mainFragment_to_blankFragment);
            }
        });


    }

    private void setTopCitiesSlider() {

        adapter = new SliderAdapter(requireContext());
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

        adapter = new SliderAdapter(requireContext());


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

        adapter = new SliderAdapter(requireContext());


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


}
