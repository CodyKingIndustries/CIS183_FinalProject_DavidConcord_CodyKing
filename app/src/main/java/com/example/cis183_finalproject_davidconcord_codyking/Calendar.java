package com.example.cis183_finalproject_davidconcord_codyking;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.CalendarView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class Calendar extends AppCompatActivity {

    CalendarView calendarView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calendar_ui);

        calendarView = findViewById(R.id.calendarView);

        //setting the calendar to the current day
        java.util.Calendar today = java.util.Calendar.getInstance();
        calendarView.setDate(today.getTimeInMillis());

        dateChangeListener();
        customizeCalendarText();


    }

    private void dateChangeListener() {
        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {

                String selectedDate = dayOfMonth + "/" + (month + 1) + "/" + year;
                Toast.makeText(Calendar.this, "", Toast.LENGTH_SHORT).show();
                ;
            }
        });

    }

    private void customizeCalendarText() {
        // Get the child TextViews of the CalendarView
        for (int i = 0; i < calendarView.getChildCount(); i++) {
            if (calendarView.getChildAt(i) instanceof TextView) {
                TextView child = (TextView) calendarView.getChildAt(i);
                child.setTextColor(Color.WHITE);
            }
        }
    }
}