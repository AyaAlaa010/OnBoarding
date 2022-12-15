package com.example.onboarding.registration;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.onboarding.R;
import com.example.onboarding.databinding.ActivityLoginRegisterBinding;

public class LoginRegisterActivity extends AppCompatActivity {
    ColorStateList def;
    TextView tvLogin;
    TextView tvRegister;
    TextView select;
    ActivityLoginRegisterBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       binding= DataBindingUtil. setContentView(this,R.layout.activity_login_register);
        tvLogin = findViewById(R.id.tv_login);
        tvRegister = findViewById(R.id.tv_register);
        select = findViewById(R.id.select);
        def = tvRegister.getTextColors();
        setTabsAction();
    }

    private void setTabsAction(){
        tvLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String item_two=tvRegister.getText().toString();
                String item_One=tvLogin.getText().toString();
                tvLogin.setText("");
                tvRegister.setText("");
                select.animate().x(0).setDuration(1000);
                binding.fragmentContainerViewLoginRegister.animate().x(0).setDuration(1000);

                tvRegister.setText(item_two);
                tvLogin.setText(item_One);
               tvLogin.setTextColor(Color.WHITE);
                tvRegister.setTextColor(def);
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragmentContainerView_login_register, new LoginFragment()).commit();

            }
        });
        tvRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String item_one=tvLogin.getText().toString();
                String item_two=tvRegister.getText().toString();

                tvLogin.setText("");
                tvRegister.setText("");

                int size = tvRegister.getWidth();
                select.animate().x(size).setDuration(1000);
                binding.fragmentContainerViewLoginRegister.animate().x(0).setDuration(1000);

                tvLogin.setText(item_one);
                tvRegister.setText(item_two);

                tvLogin.setTextColor(def);
                tvRegister.setTextColor(Color.WHITE);
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragmentContainerView_login_register, new RegisterFragment()).commit();



            }
        });



    }
}