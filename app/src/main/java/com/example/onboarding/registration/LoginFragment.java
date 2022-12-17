package com.example.onboarding.registration;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.onboarding.R;
import com.example.onboarding.databinding.FragmentLoginBinding;


public class LoginFragment extends Fragment {
    private FragmentLoginBinding binding;

    //  private NavController navController;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_login, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //navController= Navigation.findNavController(view);
        setViewsAction();
        binding.btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //  navController.navigate(R.id.action_loginFragment_to_registerFragment);

            }
        });
    }

    private void setViewsAction() {
        binding.imgHidePassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (binding.imgHidePassword.getDrawable().getConstantState().equals
                        (getResources().getDrawable(R.drawable.show_password_icon).getConstantState())) {

                    showPassword(binding.etLoginPassword, binding.imgHidePassword);
                } else {
                    hidePassword(binding.etLoginPassword, binding.imgHidePassword);


                }
            }
        });
    }

    private void showPassword(EditText editText, ImageView imageView) {
        editText.setTransformationMethod(PasswordTransformationMethod.getInstance());
        imageView.setImageDrawable(getResources().getDrawable(R.drawable.hide_password_icon));
    }


    private void hidePassword(EditText editText, ImageView imageView) {
        editText.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
        imageView.setImageDrawable(getResources().getDrawable(R.drawable.show_password_icon));
    }
}