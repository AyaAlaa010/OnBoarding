package com.example.onboarding.search.Flight.Ticket;

import android.content.Intent;
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
import android.widget.Toast;

import com.example.onboarding.R;
import com.example.onboarding.databinding.FragmentCheckAndPayProcessBinding;
import com.example.onboarding.search.SearchFragment;

public class CheckAndPayProcessFragment extends Fragment {

    private FragmentCheckAndPayProcessBinding binding;
    private NavController navController;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_check_and_pay_process, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        navController= Navigation.findNavController(view);

        setNextViewAction();
        setBackViewAction();

    }

    private void  setNextViewAction(){
        binding.tvNextTicket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            //  getActivity().getSupportFragmentManager().beginTransaction().add(R.id.nav_host_fragment, new SuccessfulFlightBookingFragment(),"success").commit();
                navController.clearBackStack(R.id.flightDetailsFragment);
                navController.clearBackStack(R.id.fragmentConfirmation);
                navController.clearBackStack(R.id.ticketTypeProcessFragment);
                navController.clearBackStack(R.id.whoFlyingProcessFragment);
                navController.clearBackStack(R.id.checkAndPayProcessFragment);

                navController.navigate(R.id.action_checkAndPayProcessFragment_to_successfulFlightBookingFragment);

                //remove all fragment of ticket process after finish the booking
//                getActivity().getSupportFragmentManager().beginTransaction().remove(getActivity().getSupportFragmentManager().findFragmentByTag("check")).commit();
//                getActivity().getSupportFragmentManager().beginTransaction().remove(getActivity().getSupportFragmentManager().findFragmentByTag("who")).commit();
//                getActivity().getSupportFragmentManager().beginTransaction().remove(getActivity().getSupportFragmentManager().findFragmentByTag("confirmation")).commit();
//                getActivity().getSupportFragmentManager().beginTransaction().remove(getActivity().getSupportFragmentManager().findFragmentByTag("ticket")).commit();
//                getActivity().getSupportFragmentManager().beginTransaction().remove(getActivity().getSupportFragmentManager().findFragmentByTag("details")).commit();
//
//





            }
        });

    }
    private void  setBackViewAction(){
        binding.tvBackTicket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navController.popBackStack();

            }
        });



    }
}