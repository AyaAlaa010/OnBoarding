package com.example.onboarding.settings;

import android.os.Bundle;

import androidx.annotation.MenuRes;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupMenu;

import com.example.onboarding.R;
import com.example.onboarding.databinding.FragmentPreferenceBinding;

public class PreferenceFragment extends Fragment {

private FragmentPreferenceBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_preference, container, false);
        return binding.getRoot();
    }
    private void showMenu(View view, @MenuRes int menuRes) {
        PopupMenu popup = new PopupMenu(getActivity(), view);
        popup.getMenuInflater().inflate(menuRes, popup.getMenu());
        popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {

                binding.selectCurrancy.setText(menuItem.getTitle());
                return false;
            }
        });

    }}