package com.example.onboarding.registration.notwork;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.onboarding.R;
import com.example.onboarding.databinding.ActivityRegisterSuccessBinding;
import com.example.onboarding.ui.home.notused.MainActivity;
//TODO DELETE THIS ACTIVITY
public class SuccessRegisterActivity extends AppCompatActivity {
    private ActivityRegisterSuccessBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this,R.layout.activity_register_success);
        setViewsAction();
    }

    private void setViewsAction(){
        binding.btnContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SuccessRegisterActivity.this, MainActivity.class));
            }
        });


    }
}