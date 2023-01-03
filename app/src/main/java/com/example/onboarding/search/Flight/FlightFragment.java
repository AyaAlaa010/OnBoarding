package com.example.onboarding.search.Flight;

import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.onboarding.R;
import com.google.android.material.datepicker.CalendarConstraints;
import com.google.android.material.datepicker.DateValidatorPointForward;
import com.google.android.material.datepicker.MaterialDatePicker;
import com.google.android.material.datepicker.MaterialPickerOnPositiveButtonClickListener;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;


public class FlightFragment extends Fragment {

private LinearLayout depatureReturnDateView;
private TextView tvDepartureDate,tvReturnDate;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_flight, container, false);    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViews(view);
        setDatePicker();
    }


    private void initViews(View view){

        depatureReturnDateView=view.findViewById(R.id.linear_flight_2);
        tvDepartureDate=view.findViewById(R.id.tv_date_departure);
        tvReturnDate=view.findViewById(R.id.tv_date_return);
    }



    private void setDatePicker(){

        CalendarConstraints.Builder calendarConstraintBuilder = new CalendarConstraints.Builder();
        calendarConstraintBuilder.setValidator(DateValidatorPointForward.now());
        MaterialDatePicker.Builder builder = MaterialDatePicker.Builder.dateRangePicker();
        builder.setTitleText("SELECT A DATE");
        // now pass the constrained calendar builder to
        // material date picker Calendar constraints
        builder.setCalendarConstraints(calendarConstraintBuilder.build());
        // now build the material date picker dialog
        final MaterialDatePicker materialDatePicker = builder.build();




        depatureReturnDateView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                materialDatePicker.show(getActivity().getSupportFragmentManager(), materialDatePicker.toString());

                materialDatePicker.addOnPositiveButtonClickListener(new MaterialPickerOnPositiveButtonClickListener() {
                    @RequiresApi(api = Build.VERSION_CODES.O)
                    @Override
                    public void onPositiveButtonClick(Object selection) {



                        String dates = materialDatePicker.getHeaderText();
                        String[] datesArray = dates.split(" – ",2);
                        Toast.makeText(requireContext(), datesArray[0]+"", Toast.LENGTH_SHORT).show();
                        String departureDate = datesArray[0];
                        String returnDate = datesArray[1];
                        tvDepartureDate.setText(departureDate);
                        tvReturnDate.setText(returnDate);
                    }
                }) ;
            }
        });






    }
}