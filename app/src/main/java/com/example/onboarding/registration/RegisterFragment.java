package com.example.onboarding.registration;


import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.text.Editable;
import android.text.TextWatcher;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.onboarding.ApllicationPojo.RegisterPojo.RegisterRequest;
import com.example.onboarding.ApllicationPojo.RegisterPojo.RegisterResponse;
import com.example.onboarding.Network.RetrofitClient;
import com.example.onboarding.R;
import com.example.onboarding.databinding.FragmentRegisterBinding;

import rx.SingleSubscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;


public class RegisterFragment extends Fragment {

private FragmentRegisterBinding binding;
private String validEmail;
//private NavController navController;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_register, container, false);
        return binding.getRoot();    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
      // navController= Navigation.findNavController(view);

        createAccount();
        hidePassword();
        hideRepeatedPassword();
        checkInputEmail();
        registerTest();

    }

    private void createAccount(){

        binding.btnCreateAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //  startActivity(new Intent(getContext(), SuccessRegisterActivity.class));
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.linear_login_register, new SuccessRegisterFragment()).commit();

            }
        });

    }
    private void hidePassword(){
        binding.imgHidePassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(    binding.imgHidePassword.getDrawable().getConstantState().equals
                        (getResources().getDrawable(R.drawable.show_password_icon).getConstantState())){
                    showPassword(binding.etRegisterPassword,binding.imgHidePassword);
                }
                else{
                    hidePassword(binding.etRegisterPassword,binding.imgHidePassword);


                }
            }
        });


    }
    private void hideRepeatedPassword(){

        binding.imgHideRepeatPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(     binding.imgHideRepeatPassword.getDrawable().getConstantState().equals
                        (getResources().getDrawable(R.drawable.show_password_icon).getConstantState())){

                    showPassword(  binding.etRegisterRepeatPassword,  binding.imgHideRepeatPassword);
                }
                else{
                    hidePassword(   binding.etRegisterRepeatPassword,  binding.imgHideRepeatPassword);


                }
            }
        });
    }





    private void checkInputEmail(){

        binding.etRegisterEmail.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {


            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }


            @Override
            public void afterTextChanged(Editable s) {

                checkEmailValidation(binding.etRegisterEmail); // pass your EditText Obj here.


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



    private void showPassword(EditText editText, ImageView imageView){
        editText.setTransformationMethod( PasswordTransformationMethod.getInstance());
        imageView.setImageDrawable(getResources().getDrawable(R.drawable.hide_password_icon));
    }



    private void hidePassword(EditText editText, ImageView imageView){
       editText.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
       imageView.setImageDrawable(getResources().getDrawable(R.drawable.show_password_icon));
    }

    private void registerTest(){
        RegisterRequest registerRequest = new RegisterRequest("aya", "alaa","ayaalaa010920@gmail.com","+201092098006", "Nawras12#");
        RetrofitClient.getApi().register(registerRequest).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleSubscriber<RegisterResponse>() {
                    @Override
                    public void onSuccess(RegisterResponse value) {
                        Toast.makeText(getContext(), "Acount Created"+value.getRegistered_email(), Toast.LENGTH_LONG).show();

                    }

                    @Override
                    public void onError(Throwable error) {
                      //  Log.i(TAG, "onError: "+ error.getLocalizedMessage());
                     Toast.makeText(getContext(), error.getMessage(), Toast.LENGTH_LONG).show();

                    }
                });


    }


}