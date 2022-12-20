package com.example.onboarding.search.Flight;

import android.app.Dialog;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.onboarding.R;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import java.util.ArrayList;
import java.util.List;

public class SearchDetailsBottomSheet extends BottomSheetDialogFragment {
    private List<FlightModel> flightList;
    private FlightsAdapter adapter;
    private  RecyclerView recyclerView;
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable
            ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        View v = inflater.inflate(R.layout.flight_details_bottom_sheet,
                container, false);
        recyclerView= v.findViewById(R.id.rec_flights);


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
        recyclerView.setAdapter(adapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(requireContext(), RecyclerView.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);

        return v;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        return new BottomSheetDialog(getContext(),R.style.MyBottomSheetDialogTheme);
    }
}