package com.example.mobileproject;


import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.Toast;

import java.util.Calendar;


/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment {

    public MainActivity mainActivity;

    public MainFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_main, container, false);

        DatePicker datePicker = (DatePicker) view.findViewById(R.id.calendarView);
        datePicker.setOnDateChangedListener(dateChangedListener);
        return view;
    }

    private DatePicker.OnDateChangedListener dateChangedListener =
            new DatePicker.OnDateChangedListener(){
                @Override
                public void onDateChanged(DatePicker datePicker, int i, int i1, int i2) {
                    mainActivity = (MainActivity) getActivity();
                    mainActivity.Day = datePicker.getDayOfMonth();
                    mainActivity.Month = datePicker.getMonth();
                    mainActivity.Year = datePicker.getYear();
                    Toast.makeText(getActivity(), "picked date is " + datePicker.getDayOfMonth() +
                            " / " + (datePicker.getMonth()+1) +
                            " / " + datePicker.getYear(), Toast.LENGTH_SHORT).show();

                    DialogFragment newFragment = new TimePickerFragment();
                    newFragment.show(getFragmentManager(), "timePicker");
                }
            };

}
