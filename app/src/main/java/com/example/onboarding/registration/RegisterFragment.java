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
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        // navController= Navigation.findNavController(view);

        setBtnCreateAccountAction();
        hidePassword();
        hideRepeatedPassword();
        checkInputEmail();

    }

    private void setBtnCreateAccountAction() {


        binding.btnCreateAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //  startActivity(new Intent(getContext(), SuccessRegisterActivity.class));

                checkFieldsForMakingRegister();

            }

        });
    }

    private void checkFieldsForMakingRegister() {
        String firstName = binding.etRegisterFirstName.getText().toString();
        String lastName = binding.etRegisterLastName.getText().toString();
        String email = binding.etRegisterEmail.getText().toString();
        String phoneNumber = binding.tvCountryCode.getSelectedCountryCodeWithPlus() + binding.tvPhoneNumber.getText().toString();
        String password = binding.etRegisterPassword.getText().toString();

        if (!firstName.isEmpty() && ! lastName.isEmpty() && !email.isEmpty() && !phoneNumber.isEmpty() &&! password.isEmpty()) {

            register(firstName, lastName, email, phoneNumber, password);


        } else {
            Toast.makeText(getContext(), "please enter all fields to register successfully", Toast.LENGTH_SHORT).show();


        }


    }


    private void hidePassword() {
        binding.imgHidePassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (binding.imgHidePassword.getDrawable().getConstantState().equals
                        (getResources().getDrawable(R.drawable.show_password_icon).getConstantState())) {
                    showPassword(binding.etRegisterPassword, binding.imgHidePassword);
                } else {
                    hidePassword(binding.etRegisterPassword, binding.imgHidePassword);


                }
            }
        });


    }

    private void hideRepeatedPassword() {

        binding.imgHideRepeatPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (binding.imgHideRepeatPassword.getDrawable().getConstantState().equals
                        (getResources().getDrawable(R.drawable.show_password_icon).getConstantState())) {

                    showPassword(binding.etRegisterRepeatPassword, binding.imgHideRepeatPassword);
                } else {
                    hidePassword(binding.etRegisterRepeatPassword, binding.imgHideRepeatPassword);


                }
            }
        });
    }


    private void checkInputEmail() {

        binding.etRegisterEmail.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {


            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }


            @Override
            public void afterTextChanged(Editable s) {

                checkEmailValidationFormate(binding.etRegisterEmail);


            }
        });

    }

    public void checkEmailValidationFormate(EditText edtEmail) {
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

    private void register(String firstName, String lastName, String email, String phoneNumber, String password) {
        RegisterRequest registerRequest = new RegisterRequest(firstName, lastName, email, phoneNumber, password);
        // RegisterRequest registerRequest = new RegisterRequest("aya", "alaa","aya@innovationfactory.biz","+971529520601", "ayaaaa12#");

        RetrofitClient.getApi().register(registerRequest).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleSubscriber<RegisterResponse>() {
                    @Override
                    public void onSuccess(RegisterResponse value) {

                        Toast.makeText(getContext(), "Acount Created" + value.getRegistered_email(), Toast.LENGTH_LONG).show();
                        //getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.linear_login_register, new SuccessRegisterFragment()).commit();
                        setOTP( value.getUser_id());
                    }

                    @Override
                    public void onError(Throwable error) {
                        //  Log.i(TAG, "onError: "+ error.getLocalizedMessage());
                        Toast.makeText(getContext(), error.getLocalizedMessage(), Toast.LENGTH_LONG).show();

                    }
                });


    }
    private void setOTP(int userId){
        OTPFragment otpFragment = new OTPFragment();
        Bundle args = new Bundle();
        args.putInt("user_id", userId);
        args.putString("email",binding.etRegisterEmail.getText().toString());
        args.putString("checkFragment","register");
        otpFragment.setArguments(args);
        // getFragmentManager().beginTransaction().add(R.id.linear_login_register, otpFragment).commit();
        getActivity().getSupportFragmentManager().beginTransaction().add(R.id.linear_login_register, otpFragment).commit();



    }


}