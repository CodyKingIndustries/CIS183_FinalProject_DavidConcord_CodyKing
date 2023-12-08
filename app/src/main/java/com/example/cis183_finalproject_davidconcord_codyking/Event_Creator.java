package com.example.cis183_finalproject_davidconcord_codyking;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Locale;

public class event_Creator extends AppCompatActivity {

    private Spinner dateSpinner;
    private Spinner timeSpinner;
    private EditText etEventDescription;
    private Button btnSaveEvent;
    private ArrayList<MyEvent> selectedEventList;
    private MyEventAdapter adapter;
    private Button btnGoBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.event_creator_ui);

        dateSpinner = findViewById(R.id.dateSpinner);
        timeSpinner = findViewById(R.id.timeSpinner);
        etEventDescription = findViewById(R.id.etEventDescription);
        btnSaveEvent = findViewById(R.id.btnSaveEvent);
        btnGoBack = findViewById(R.id.btnGoBack);

        // Populate date spinner
        populateDateSpinner();

        // Populate time spinner
        populateTimeSpinner();

        // Initialize selectedEventList
        selectedEventList = new ArrayList<>();

        // Button click event
        btnSaveEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle save event action
                String selectedDate = dateSpinner.getSelectedItem().toString();
                String selectedTime = timeSpinner.getSelectedItem().toString();
                String eventDescription = etEventDescription.getText().toString();

                // Create a MyEvent object with the selected data
                MyEvent myEvent = new MyEvent(selectedDate, selectedTime, eventDescription);

                // Save the selected event to CalendarUI
                addEventToCalendar(myEvent);

                // Optionally, clear the input fields after saving
                etEventDescription.setText("");

                Toast.makeText(event_Creator.this, "Event Saved: " + selectedDate + " " + selectedTime + "\nDescription: " + eventDescription, Toast.LENGTH_SHORT).show();
            }
        });

        btnGoBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Go back to ChooseOption screen
                Intent i = new Intent(event_Creator.this, ChooseOption.class);
                startActivity(i);
            }
        });

        // ... (any additional initialization code)
    }

    private void populateDateSpinner() {
        // Populate date spinner with, for example, the next 365 days
        ArrayList<String> dates = new ArrayList<>();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        for (int i = 0; i < 365; i++) {
            dates.add(dateFormat.format(new Date(System.currentTimeMillis() + i * 24 * 60 * 60 * 1000)));
        }

        ArrayAdapter<String> dateAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, dates);
        dateAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        dateSpinner.setAdapter(dateAdapter);
    }

    private void populateTimeSpinner() {
        // Populate time spinner with, for example, hourly intervals
        ArrayList<String> times = new ArrayList<>();
        SimpleDateFormat timeFormat = new SimpleDateFormat("hh:mm a", Locale.getDefault());
        for (int i = 0; i < 24; i++) {
            times.add(timeFormat.format(new Date(2023, 1, 1, i, 0))); // Year, Month, Day, Hour, Minute
        }

        ArrayAdapter<String> timeAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, times);
        timeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        timeSpinner.setAdapter(timeAdapter);
    }

    private void addEventToCalendar(MyEvent myEvent) {
        // Pass the event to CalendarUI using Intent
        Intent intent = new Intent(event_Creator.this, CalendarUI.class);
        intent.putExtra("myEvent", myEvent);
        startActivity(intent);
    }
}
