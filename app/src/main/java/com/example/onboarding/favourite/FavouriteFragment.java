package com.example.onboarding.favourite;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.onboarding.R;
import com.example.onboarding.databinding.FragmentFavouriteBinding;

import java.util.ArrayList;
import java.util.List;


public class FavouriteFragment extends Fragment {
    private FragmentFavouriteBinding binding;
    private FavouriteAdapter adapter;
    private List<FavouriteModel> favouritesList;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_favourite, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        favouritesList= new ArrayList<>();


        favouritesList.add(new FavouriteModel(R.drawable.slid1,"HE Hotel Apartments","Dubai, United Arab Emirates 16.3 km from center"));
        favouritesList.add(new FavouriteModel(R.drawable.slid1,"HE Hotel Apartments","Dubai, United Arab Emirates 16.3 km from center"));
        favouritesList.add(new FavouriteModel(R.drawable.slid1,"HE Hotel Apartments","Dubai, United Arab Emirates 16.3 km from center"));
        favouritesList.add(new FavouriteModel(R.drawable.slid1,"HE Hotel Apartments","Dubai, United Arab Emirates 16.3 km from center"));
        favouritesList.add(new FavouriteModel(R.drawable.slid1,"HE Hotel Apartments","Dubai, United Arab Emirates 16.3 km from center"));
        favouritesList.add(new FavouriteModel(R.drawable.slid1,"HE Hotel Apartments","Dubai, United Arab Emirates 16.3 km from center"));
        favouritesList.add(new FavouriteModel(R.drawable.slid1,"HE Hotel Apartments","Dubai, United Arab Emirates 16.3 km from center"));
        favouritesList.add(new FavouriteModel(R.drawable.slid1,"HE Hotel Apartments","Dubai, United Arab Emirates 16.3 km from center"));
        favouritesList.add(new FavouriteModel(R.drawable.slid1,"HE Hotel Apartments","Dubai, United Arab Emirates 16.3 km from center"));
        favouritesList.add(new FavouriteModel(R.drawable.slid1,"HE Hotel Apartments","Dubai, United Arab Emirates 16.3 km from center"));

        adapter = new FavouriteAdapter(favouritesList);
        GridLayoutManager layoutManager=new GridLayoutManager(getContext(),2);
        // at last set adapter to recycler view.
        binding.recyclerFavourites.setLayoutManager(layoutManager);
        binding.recyclerFavourites.setAdapter(adapter);





    }
}