package com.example.onboarding.search.Flight.Ticket;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.onboarding.R;
import com.example.onboarding.databinding.FragmentSuccessfulFlightBookingBinding;

public class SuccessfulFlightBookingFragment extends Fragment {
    private FragmentSuccessfulFlightBookingBinding binding;
    private NavController navController;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_successful_flight_booking, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        navController= Navigation.findNavController(view);
        navController.clearBackStack(R.id.flightDetailsFragment);
        navController.clearBackStack(R.id.fragmentConfirmation);
        navController.clearBackStack(R.id.ticketTypeProcessFragment);
        navController.clearBackStack(R.id.whoFlyingProcessFragment);
        navController.clearBackStack(R.id.checkAndPayProcessFragment);
        getActivity().findViewById(R.id.bottomNavigationView).setVisibility(View.GONE);
        setFinishBttonAction();
    }
    private  void setFinishBttonAction(){
        binding.btnFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                getActivity().getSupportFragmentManager().beginTransaction().remove(getActivity().getSupportFragmentManager().findFragmentByTag("check")).commit();
//                 getActivity().getSupportFragmentManager().beginTransaction().remove(getActivity().getSupportFragmentManager().findFragmentByTag("who")).commit();
//                getActivity().getSupportFragmentManager().beginTransaction().remove(getActivity().getSupportFragmentManager().findFragmentByTag("confirmation")).commit();
//                getActivity().getSupportFragmentManager().beginTransaction().remove(getActivity().getSupportFragmentManager().findFragmentByTag("ticket")).commit();
//                getActivity().getSupportFragmentManager().beginTransaction().remove(getActivity().getSupportFragmentManager().findFragmentByTag("details")).commit();
//                getActivity().getSupportFragmentManager().beginTransaction().remove(getActivity().getSupportFragmentManager().findFragmentByTag("success")).commit();
//                navController.clearBackStack(R.id.flightDetailsFragment);
//                navController.clearBackStack(R.id.fragmentConfirmation);
//                navController.clearBackStack(R.id.ticketTypeProcessFragment);
//                navController.clearBackStack(R.id.whoFlyingProcessFragment);
//                navController.clearBackStack(R.id.checkAndPayProcessFragment);
                navController.navigate(R.id.action_successfulFlightBookingFragment_to_searchFragment);

                getActivity().findViewById(R.id.bottomNavigationView).setVisibility(View.VISIBLE);

            }
        });






    }
}