package com.example.onboarding.registration;


import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.onboarding.R;
import com.example.onboarding.databinding.FragmentRegisterBinding;


public class RegisterFragment extends Fragment {

private FragmentRegisterBinding binding;
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

        setViewsAcions();

    }



    private void setViewsAcions() {

        binding.btnCreateAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              //  startActivity(new Intent(getContext(), SuccessRegisterActivity.class));
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.linear_login_register, new SuccessRegisterFragment()).commit();

            }
        });

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

    private void showPassword(EditText editText, ImageView imageView){
        editText.setTransformationMethod( PasswordTransformationMethod.getInstance());
        imageView.setImageDrawable(getResources().getDrawable(R.drawable.hide_password_icon));
    }



    private void hidePassword(EditText editText, ImageView imageView){
       editText.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
       imageView.setImageDrawable(getResources().getDrawable(R.drawable.show_password_icon));
    }


}