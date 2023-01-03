package com.example.onboarding.registration;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.onboarding.ApllicationPojo.OTPPojo.OTPRequest;
import com.example.onboarding.ApllicationPojo.OTPPojo.OTPResponse;
import com.example.onboarding.HomeActivity;

import com.example.onboarding.Network.RetrofitClient;
import com.example.onboarding.R;
import com.example.onboarding.databinding.FragmentOTPBinding;

import rx.SingleSubscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;


public class OTPFragment extends Fragment {
private FragmentOTPBinding binding;
private int userId;

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
        getActivity().findViewById(R.id.custom_tab).setVisibility(View.GONE);
        getActivity().findViewById(R.id.card_login_register).setVisibility(View.GONE);
        userId=getArguments().getInt("user_id");
        setBackButtonAction();
        setVerifyAction();
    }


    private void setBackButtonAction(){
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

    private void setVerifyAction(){

        binding.btnVerify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // startActivity(new Intent(getContext(), HomeActivity.class));
                checkOTPFilled();            }
        });



    }
    private void checkOTPFilled(){

        if( !(  binding.etOtpOne.getText().toString().isEmpty()&& binding.etOtpTwo.getText().toString().isEmpty()&& binding.etOtpThree.getText().toString().isEmpty() && binding.etOtpFour.getText().toString().isEmpty()&& binding.etOtpFive.getText().toString().isEmpty()&& binding.etOtpSix.getText().toString().isEmpty())){
            String otp=    binding.etOtpOne.getText().toString()+ binding.etOtpTwo.getText().toString()+ binding.etOtpThree.getText().toString()+ binding.etOtpFour.getText().toString()+ binding.etOtpFive.getText().toString()+ binding.etOtpSix.getText().toString();
            int intOTP=Integer.parseInt(otp);
            sendOtp(intOTP);

        }
        else{

            Toast.makeText(getContext(),"you must enter six digits",Toast.LENGTH_LONG).show();

        }




    }

    private void sendOtp(int otp){
        OTPRequest otpRequest = new OTPRequest("mobile", userId,otp);
        RetrofitClient.getApi().sendOTP(otpRequest).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleSubscriber<OTPResponse>() {
                    @Override
                    public void onSuccess(OTPResponse value) {
                        Toast.makeText(getContext(),value.getToken()+"",Toast.LENGTH_LONG).show();
                        startActivity(new Intent(getContext(),HomeActivity.class));

                        String  token = value.getToken();
                        System.out.println("----------------------------"+token+"----------------------------------------");
                        SharedPreferences preferences = getActivity().getSharedPreferences("token", Context.MODE_PRIVATE);
                      preferences.edit().putString("accessToken", token).apply();
//                        myToken = getSharedPreferences("products", MODE_PRIVATE).getString("accessToken", "");
//                        String token = "Bearer " + myToken;

                    }

                    @Override
                    public void onError(Throwable error) {

                        // Log.i(TAG, "onError: " + error.getLocalizedMessage());
                        Toast.makeText(getContext(),error.getLocalizedMessage().toString(),Toast.LENGTH_LONG).show();
                    }
                });

    }

}