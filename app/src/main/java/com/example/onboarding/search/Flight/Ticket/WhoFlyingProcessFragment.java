package com.example.onboarding.search.Flight.Ticket;

import android.os.Bundle;

import androidx.annotation.MenuRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.PopupMenu;
import android.widget.RelativeLayout;
import android.widget.Spinner;

import com.example.onboarding.R;
import com.example.onboarding.databinding.FragmentWhoFlyingProcessBinding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WhoFlyingProcessFragment extends Fragment {
    private FragmentWhoFlyingProcessBinding binding;
    private NavController navController;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_who_flying_process, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        navController= Navigation.findNavController(view);

        setSelectMenuAction();
        setNextButtonAction();
        setBackButtonAction();


    }

    private void setSelectMenuAction() {
        binding.selectMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showMenu(view, R.menu.select_flying_menue);

            }
        });

    }

    private void showMenu(View view, @MenuRes int menuRes) {
        PopupMenu popup = new PopupMenu(getActivity(), view);
        popup.getMenuInflater().inflate(menuRes, popup.getMenu());
        popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {

                binding.selectMenu.setText(menuItem.getTitle());
                return false;
            }
        });

//        popup.setOnMenuItemClickListener { menuItem: MenuItem ->
//            // Respond to menu item click.
//        }
//        popup.setOnDismissListener {
//            // Respond to popup being dismissed.
//        }
//        // Show the popup menu.
        popup.show();
    }
    private void setNextButtonAction(){

        binding.tvNextTicket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              //  getActivity().getSupportFragmentManager().beginTransaction().setCustomAnimations(R.anim.horizontal_slide_in, R.anim.horizontal_slide_out).add(R.id.nav_host_fragment, new CheckAndPayProcessFragment(),"check").commit();
                navController.navigate(R.id.action_whoFlyingProcessFragment_to_checkAndPayProcessFragment);
            }
        });
    }
    private void setBackButtonAction(){

        binding.tvBackTicket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               navController.popBackStack();

            }
        });

    }

}