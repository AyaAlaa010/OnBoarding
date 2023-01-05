package com.example.onboarding.registration;

import static android.content.Context.MODE_PRIVATE;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.example.onboarding.ApllicationPojo.OTPPojo.OTPRequest;
import com.example.onboarding.ApllicationPojo.OTPPojo.OTPResponse;
import com.example.onboarding.HomeActivity;

import com.example.onboarding.Network.RetrofitClient;
import com.example.onboarding.R;
import com.example.onboarding.databinding.FragmentOTPBinding;
import com.example.onboarding.ui.home.MainFragment;

import rx.SingleSubscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;


public class OTPFragment extends Fragment {
    private FragmentOTPBinding binding;
    private int userId;
    private String email, checkFragment;
    private SharedPreferences preferences;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_o_t_p, container, false);
        return binding.getRoot();
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        preferences = getActivity().getSharedPreferences("user", MODE_PRIVATE);

        getActivity().findViewById(R.id.custom_tab).setVisibility(View.GONE);
        getActivity().findViewById(R.id.card_login_register).setVisibility(View.GONE);
        getDataSentTHroughBundel();

        binding.tvEmailFormat.setText(email);
        setBackButtonAction();
        setVerifyAction();
    }

    private void getDataSentTHroughBundel() {

        userId = getArguments().getInt("user_id");
        email = getArguments().getString("email");
        checkFragment = getArguments().getString("checkFragment");

    }


    private void setBackButtonAction() {
        binding.ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//restart activity      TODO MUST BACK TO THE OLD FRAGMENT WITH THE OLD DATA INSTEAD OF RESTART
                Intent intent = getActivity().getIntent();
                getActivity().finish();
                startActivity(intent);

//getActivity().onBackPressed();

            }
        });

    }

    private void setVerifyAction() {

        binding.btnVerify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // startActivity(new Intent(getContext(), HomeActivity.class));
                checkOTPFilled();
            }
        });


    }

    private void checkOTPFilled() {

        if (binding.PinView.getText().length() == 6) {
            String otp = binding.PinView.getText().toString();
            int intOTP = Integer.parseInt(otp);
            sendOtp(intOTP);

        } else {

            Toast.makeText(getContext(), "you must fill all six digits", Toast.LENGTH_LONG).show();

        }


    }

    private void sendOtp(int otp) {
        OTPRequest otpRequest = new OTPRequest("mobile", userId, otp);
        RetrofitClient.getApi().sendOTP(otpRequest).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleSubscriber<OTPResponse>() {
                    @Override
                    public void onSuccess(OTPResponse value) {
                        //store name of the user
                        preferences.edit().putString("name",value.getUser().getFirstName()).apply();

                        //store the token to record the session
                        String token = value.getToken();
                        preferences.edit().putString("accessToken", token).apply();

                        //check which fragment sent otp
                        checkTheCurrentFragment();
                    }

                    @Override
                    public void onError(Throwable error) {
                        Toast.makeText(getContext(), error.getLocalizedMessage().toString(), Toast.LENGTH_LONG).show();
                    }
                });

    }
    private void checkTheCurrentFragment(){
        if (checkFragment.equals("login")) {

            startActivity( new Intent(getContext(), HomeActivity.class));
            getActivity().finish();

        } else if (checkFragment.equals("register")) {
            getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.linear_login_register, new SuccessRegisterFragment()).commit();
        }


    }

}