package com.example.onboarding.registration.notwork;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.onboarding.R;
import com.example.onboarding.databinding.ActivityLoginRegisterBinding;
import com.example.onboarding.registration.LoginFragment;
import com.example.onboarding.registration.RegisterFragment;


public class LoginRegisterFragment extends Fragment {
    private ColorStateList def;
    private TextView tvLogin;
    private TextView tvRegister;
    private TextView select;
    private ImageView ivBack;
    private RegisterFragment registerFragment;
    private LoginFragment loginFragment;
    private ActivityLoginRegisterBinding binding;
    private static int flagSpecifyFragment = 1;
    private NavController navController;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login_register, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        navController = Navigation.findNavController(view);

//        getActivity().overridePendingTransition(R.anim.slide_in_bottom, R.anim.slide_out_top);
     //   getActivity().findViewById(R.id.bottomNavigationView).setVisibility(View.GONE);

        init(view);
        setTabsAction();
        setViewsAction();
    }
    private void init(View view){
        tvLogin = view.findViewById(R.id.tv_login);
        tvRegister = view.findViewById(R.id.tv_register);
        select = view.findViewById(R.id.select);
        ivBack = view.findViewById(R.id.iv_back);
        def = tvRegister.getTextColors();
        registerFragment = new RegisterFragment();
        loginFragment = new LoginFragment();


    }


    private void setViewsAction() {
        ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //startActivity(new Intent(LoginRegisterActivity.this, MainActivity.class));

                navController.popBackStack();


            }


        });


    }

    private void setTabsAction() {
        tvLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                flagSpecifyFragment = 1;
                setLoginAnimation();
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragmentContainerView_login_register, loginFragment).commit();

            }
        });


        tvRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                flagSpecifyFragment = 2;
                setRegisterAnimation();
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragmentContainerView_login_register, registerFragment).commit();


            }
        });


    }

    private void setLoginAnimation() {

        String item_two = tvRegister.getText().toString();
        String item_One = tvLogin.getText().toString();
        tvLogin.setText("");
        tvRegister.setText("");
        select.animate().x(0).setDuration(500);
        // binding.fragmentContainerViewLoginRegister.animate().x(0).setDuration(1000);

        tvRegister.setText(item_two);
        tvLogin.setText(item_One);
        tvLogin.setTextColor(Color.WHITE);
        tvRegister.setTextColor(def);

    }

    private void setRegisterAnimation() {

        String item_one = tvLogin.getText().toString();
        String item_two = tvRegister.getText().toString();

        tvLogin.setText("");
        tvRegister.setText("");

        int size = tvRegister.getWidth();
        select.animate().x(size).setDuration(500);
        // binding.fragmentContainerViewLoginRegister.animate().x(0).setDuration(1000);

        tvLogin.setText(item_one);
        tvRegister.setText(item_two);

        tvLogin.setTextColor(def);
        tvRegister.setTextColor(Color.WHITE);

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        //getActivity().findViewById(R.id.bottomNavigationView).setVisibility(View.VISIBLE);

    }
}