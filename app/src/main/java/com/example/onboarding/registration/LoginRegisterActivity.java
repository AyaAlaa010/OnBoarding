package com.example.onboarding.registration;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.onboarding.R;
import com.example.onboarding.databinding.ActivityLoginRegisterBinding;
import com.example.onboarding.ui.home.notused.MainActivity;

public class LoginRegisterActivity extends AppCompatActivity {
    private ColorStateList def;
    private TextView tvLogin;
    private TextView tvRegister;
    private TextView select;
    private ImageView ivBack;
    private RegisterFragment registerFragment;
    private LoginFragment loginFragment;
    private ActivityLoginRegisterBinding binding;
    private static int flagSpecifyFragment = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login_register);
        overridePendingTransition(R.anim.slide_in_bottom, R.anim.slide_out_top);

        tvLogin = findViewById(R.id.tv_login);
        tvRegister = findViewById(R.id.tv_register);
        select = findViewById(R.id.select);
        ivBack = findViewById(R.id.iv_back);
        def = tvRegister.getTextColors();
        registerFragment = new RegisterFragment();
        loginFragment = new LoginFragment();
        setTabsAction();
        setViewsAction();

    }

    private void setViewsAction() {
        ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    startActivity(new Intent(LoginRegisterActivity.this, MainActivity.class));




                }


        });


    }

    private void setTabsAction() {
        tvLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                flagSpecifyFragment = 1;
                setLoginAnimation();
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragmentContainerView_login_register, loginFragment).commit();

            }
        });


        tvRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                flagSpecifyFragment = 2;
               setRegisterAnimation();
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragmentContainerView_login_register, registerFragment).commit();


            }
        });


    }
    private void setLoginAnimation(){

        String item_two = tvRegister.getText().toString();
        String item_One = tvLogin.getText().toString();
        tvLogin.setText("");
        tvRegister.setText("");
        select.animate().x(0).setDuration(500);
        binding.fragmentContainerViewLoginRegister.animate().x(0).setDuration(1000);

        tvRegister.setText(item_two);
        tvLogin.setText(item_One);
        tvLogin.setTextColor(Color.WHITE);
        tvRegister.setTextColor(def);

    }
    private void setRegisterAnimation(){

        String item_one = tvLogin.getText().toString();
        String item_two = tvRegister.getText().toString();

        tvLogin.setText("");
        tvRegister.setText("");

        int size = tvRegister.getWidth();
        select.animate().x(size).setDuration(500);
        binding.fragmentContainerViewLoginRegister.animate().x(0).setDuration(1000);

        tvLogin.setText(item_one);
        tvRegister.setText(item_two);

        tvLogin.setTextColor(def);
        tvRegister.setTextColor(Color.WHITE);

    }
}