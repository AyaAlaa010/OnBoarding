package com.example.onboarding.search.Flight.Ticket;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.onboarding.R;
import com.example.onboarding.databinding.TicketTypeProcessFragmentBinding;

public class TicketTypeProcessFragment extends Fragment {
    private TicketTypeProcessFragmentBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.ticket_type_process_fragment, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        handelRadioButtonCheck();
        setBackButtonAction();
        setSeeMoreTicketDetailsAction();

    }

    private void handelRadioButtonCheck() {


        binding.radioFlexibleTicket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.radioStandardTicket.setChecked(false);
               hideTicketDetails();
                binding.tvNextTicket.setClickable(true);
                // next button clickable only when i choose one ticket
                setNextButtonAction();

            }
        });

        binding.radioStandardTicket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.radioFlexibleTicket.setChecked(false);
                hideTicketDetails();
                binding.tvNextTicket.setClickable(true);
                // next button clickable only when i choose one ticket

                setNextButtonAction();
            }
        });

        binding.cardFlexibleTicket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.radioStandardTicket.setChecked(false);
                binding.radioFlexibleTicket.setChecked(true);
                hideTicketDetails();
                setNextButtonAction();

            }



        });

        binding.cardStandardTicket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.radioStandardTicket.setChecked(true);
                binding.radioFlexibleTicket.setChecked(false);
                hideTicketDetails();
                setNextButtonAction();

            }



        });
    }
    private void hideTicketDetails(){

        //hide standard ticket details
        binding.linearStandardHide.setVisibility(View.GONE);
        // hid flexible ticket details
        binding.linearFlexibleHide.setVisibility(View.GONE);
        //appear see more
        binding.imageSeeMoreFlexible.setVisibility(View.VISIBLE);
        binding.imageSeeMoreStandard.setVisibility(View.VISIBLE);
        // make view rounded
        binding.cardFlexibleTicket.setRadius(100);
        binding.cardStandardTicket.setRadius(100);


    }



    private void setNextButtonAction() {
        binding.tvNextTicket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().getSupportFragmentManager().beginTransaction().setCustomAnimations(R.anim.horizontal_slide_in, R.anim.horizontal_slide_out).add(R.id.fragmentContainerView3, new WhoFlyingProcessFragment(),"who").addToBackStack(null).commit();

            }
        });
    }

    private void setBackButtonAction(){


        binding.tvBackTicket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getParentFragmentManager().popBackStack();

            }
        });

    }

    private  void setSeeMoreTicketDetailsAction(){
        binding.imageSeeMoreStandard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //show standard ticket details
                binding.linearStandardHide.setVisibility(View.VISIBLE);
                // hide see more icone
                binding.imageSeeMoreStandard.setVisibility(View.GONE);
                //set card view
                binding.cardStandardTicket.setRadius(60);

            }
        });
        binding.imageSeeMoreFlexible.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //show flexible ticket details
                binding.linearFlexibleHide.setVisibility(View.VISIBLE);
                // hide see more icone
                binding.imageSeeMoreFlexible.setVisibility(View.GONE);
                //set card view
                binding.cardFlexibleTicket.setRadius(60);

            }
        });


    }




}