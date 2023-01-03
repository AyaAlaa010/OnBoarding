package com.example.onboarding.search.Flight.Ticket;

import android.os.Bundle;

import androidx.annotation.MenuRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.PopupMenu;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.onboarding.R;
import com.example.onboarding.databinding.FragmentWhoFlyingProcessBinding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WhoFlyingProcessFragment extends Fragment {
    private FragmentWhoFlyingProcessBinding binding;
    private NavController navController;
   private  String validEmail;


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
       // nawrasProplem();


        navController= Navigation.findNavController(view);

        setSelectMenuAction();
        setNextButtonAction();
        setBackButtonAction();
        checkInputEmail();

    }


    private void setSelectMenuAction() {
        binding.selectMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showMenu(view, R.menu.select_flying_menue);

            }
        });

    }
    private void checkInputEmail(){

        binding.etContactEmail.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {


            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                }


            @Override
            public void afterTextChanged(Editable s) {

                checkEmailValidation(binding.etContactEmail); // pass your EditText Obj here.


            }
        });

    }
    public void checkEmailValidation(EditText edtEmail) {
        if (edtEmail.getText().toString() == null) {
            edtEmail.setError("Invalid Email Address");
            validEmail = null;
        } else if (isEmailValid(edtEmail.getText().toString()) == false) {
            edtEmail.setError("Invalid Email Address");
            validEmail = null;
        } else {
            validEmail = edtEmail.getText().toString();
        }
    }

    boolean isEmailValid(CharSequence email) {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email)
                .matches();
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