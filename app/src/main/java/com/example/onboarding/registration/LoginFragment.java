package com.example.onboarding.registration;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.text.Editable;
import android.text.TextWatcher;
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
    private String validEmail;

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
        checkInputEmail();
        loginAction();
    }

    private void loginAction(){

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
    private void checkInputEmail(){

        binding.etLoginEmail.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {


            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }


            @Override
            public void afterTextChanged(Editable s) {

                checkEmailValidation(binding.etLoginEmail); // pass your EditText Obj here.


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

    private void showPassword(EditText editText, ImageView imageView) {
        editText.setTransformationMethod(PasswordTransformationMethod.getInstance());
        imageView.setImageDrawable(getResources().getDrawable(R.drawable.hide_password_icon));
    }


    private void hidePassword(EditText editText, ImageView imageView) {
        editText.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
        imageView.setImageDrawable(getResources().getDrawable(R.drawable.show_password_icon));
    }
}