package com.example.onboarding.search.Flight;

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
import com.example.onboarding.databinding.FragmentFlightDetailsBinding;
import com.example.onboarding.favourite.FavouritTabsAdapter;
import com.example.onboarding.favourite.FavouriteBookingsAndSavedAdapter;
import com.example.onboarding.favourite.FavouriteModel;

import java.util.ArrayList;
import java.util.List;

public class FlightDetailsFragment extends Fragment {

private FragmentFlightDetailsBinding binding;
    private List<FlightModel> flightList;
    private FlightsAdapter adapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_flight_details, container, false);
        return binding.getRoot();    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
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







            adapter = new FlightsAdapter(flightList);
        binding.recFlights.setAdapter(adapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(requireContext(), RecyclerView.VERTICAL, false);
        binding.recFlights.setLayoutManager(layoutManager);



    }
}