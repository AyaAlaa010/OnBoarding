package com.example.onboarding.favourite;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.onboarding.R;
import com.example.onboarding.databinding.FragmentBookingsBinding;
import com.example.onboarding.favourite.FavouriteBookingsAndSavedAdapter;
import com.example.onboarding.favourite.FavouriteModel;

import java.util.ArrayList;
import java.util.List;


public class BookingsFragment extends Fragment {
    private FavouriteBookingsAndSavedAdapter adapter;
    private List<FavouriteModel> favouritesList;
    private FragmentBookingsBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_bookings, container, false);
        return binding.getRoot();    }

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

        adapter = new FavouriteBookingsAndSavedAdapter(favouritesList);
        binding.recyclerFavouritesBookings.setAdapter(adapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(requireContext(), RecyclerView.VERTICAL, false);
        binding.recyclerFavouritesBookings.setLayoutManager(layoutManager);

    }
}