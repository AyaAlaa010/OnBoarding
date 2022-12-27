package com.example.onboarding.search.Flight.Ticket;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.onboarding.R;
import com.example.onboarding.databinding.FragmentCheckAndPayProcessBinding;

public class CheckAndPayProcessFragment extends Fragment {

    private FragmentCheckAndPayProcessBinding binding;


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

        setNextViewAction();
        setBackViewAction();

    }

    private void  setNextViewAction(){
        binding.tvNextTicket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              //  getActivity().getSupportFragmentManager().beginTransaction().add(R.id.fragmentContainerView3, new SuccessfulFlightBookingFragment()).commit();
                startActivity(new Intent(getContext(),SuccessfullFightBookingActivity.class));
                getActivity().finish();

            }
        });

    }
    private void  setBackViewAction(){
        binding.tvBackTicket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getParentFragmentManager().popBackStack();

            }
        });



    }
}