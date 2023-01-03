package com.example.onboarding.registration;

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

import com.example.onboarding.ApllicationPojo.LoginPojo.LoginRequest;
import com.example.onboarding.ApllicationPojo.LoginPojo.LoginResponse;
import com.example.onboarding.Network.RetrofitClient;
import com.example.onboarding.R;
import com.example.onboarding.databinding.FragmentLoginBinding;

import rx.SingleSubscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;


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


    private void login(String email,String password){

      //LoginRequest loginRequest = new LoginRequest("eng.nawrasma@gmail.com", "Nawras12#");
        LoginRequest loginRequest = new LoginRequest(email, password);

        RetrofitClient.getApi().login(loginRequest).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleSubscriber<LoginResponse>() {
                    @Override
                    public void onSuccess(LoginResponse value) {
//                        Toast.makeText(getContext(),value.getRegistered_email(),Toast.LENGTH_LONG).show();
//                        Toast.makeText(getContext(),value.getUser_id()+"",Toast.LENGTH_LONG).show();

                        setOTP(value.getUser_id());
                      // String  token = value.gr();
//                        SharedPreferences preferences = getSharedPreferences("products", Context.MODE_PRIVATE);
//                        preferences.edit().putString("accessToken", myToken).apply();
//                        myToken = getSharedPreferences("products", MODE_PRIVATE).getString("accessToken", "");
//                        String token = "Bearer " + myToken;
//                        Log.i(TAG, "onCreate:my token =  " + token);
//                        Log.i(TAG, "onResponse: xxxxxxxxxxxxx" + myToken);
//                        if (myToken.isEmpty()) {
//
//                            Toast.makeText(LoginActivity.this, "token empty", Toast.LENGTH_LONG).show();
//                        }
//                        Toast.makeText(LoginActivity.this, "sucess", Toast.LENGTH_LONG).show();
//
//                        startActivity(new Intent(LoginActivity.this, MainActivity.class));
//                        finish();
                    }

                    @Override
                    public void onError(Throwable error) {

                       // Log.i(TAG, "onError: " + error.getLocalizedMessage());
                        Toast.makeText(getContext(),error.getLocalizedMessage().toString(),Toast.LENGTH_LONG).show();
                    }
                });


    }

    private void loginAction(){

        binding.btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //  navController.navigate(R.id.action_loginFragment_to_registerFragment);
                checkEmailAndPasswordExistance();
            }
        });


    }

    private void checkEmailAndPasswordExistance() {
        if(binding.etLoginEmail.getText().toString().isEmpty()&&binding.etLoginPassword.getText().toString().isEmpty()){

            binding.etLoginPassword.setError("please enter the password");
            binding.etLoginEmail.setError("please enter the email");

        }

       else if(binding.etLoginEmail.getText().toString().isEmpty()){

            Toast.makeText(getContext(), "please enter your email", Toast.LENGTH_SHORT).show();
            binding.etLoginEmail.setError("please enter the email");

        }
        else if(binding.etLoginPassword.getText().toString().isEmpty()){

            Toast.makeText(getContext(), "please enter your password", Toast.LENGTH_SHORT).show();
            binding.etLoginPassword.setError("please enter the  password");

        }
        else{

            login( binding.etLoginEmail.getText().toString(), binding.etLoginPassword.getText().toString());



        }
    }

    private void setOTP(int userId){
        OTPFragment otpFragment = new OTPFragment();
        Bundle args = new Bundle();
        args.putInt("user_id", userId);
        otpFragment.setArguments(args);
       // getFragmentManager().beginTransaction().add(R.id.linear_login_register, otpFragment).commit();
        getActivity().getSupportFragmentManager().beginTransaction().add(R.id.linear_login_register, otpFragment).commit();



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