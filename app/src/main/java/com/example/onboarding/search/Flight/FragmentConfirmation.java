package com.example.onboarding.search.Flight;

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
import android.widget.LinearLayout;

import com.example.onboarding.R;
import com.example.onboarding.databinding.FragmentConfirmationBinding;
import com.example.onboarding.search.Flight.Ticket.TicketTypeProcessFragment;
import com.google.android.material.bottomsheet.BottomSheetBehavior;

public class FragmentConfirmation extends Fragment {
    private NavController navController;

    private FragmentConfirmationBinding binding;
    private LinearLayout bottomSheet;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_confirmation, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        navController= Navigation.findNavController(view);
        bottomSheet = view.findViewById(R.id.vBSBehavior);
        setBottomSheet();
        setViewsAction();
    }
    private void setBottomSheet(){

        BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.from(bottomSheet);
        bottomSheetBehavior.setHideable(false);
        bottomSheetBehavior.setPeekHeight(1500);

// setting the bottom sheet callback for interacting with state changes and sliding
        bottomSheetBehavior.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(View view, int i) {
                // do something when state changes

            }

            @Override
            public void onSlide(View view, float v) {

            }
        });

    }

    private void setViewsAction() {
        binding.btnSelect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // getActivity().getSupportFragmentManager().beginTransaction().setCustomAnimations(R.anim.slide_in_bottom, R.anim.slide_out_top).add(R.id.nav_host_fragment, new TicketTypeProcessFragment(), "ticket").addToBackStack(null).commit();
                navController.navigate(R.id.action_fragmentConfirmation_to_ticketTypeProcessFragment);

            }
        });

            //exite button
        binding.tvExitIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //getFragmentManager().popBackStack();
                navController.popBackStack();


            }
        });


    }
}