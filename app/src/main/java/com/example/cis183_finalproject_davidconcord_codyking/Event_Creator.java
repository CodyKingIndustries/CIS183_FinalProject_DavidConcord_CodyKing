package com.example.cis183_finalproject_davidconcord_codyking;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Locale;

public class Event_Creator extends AppCompatActivity {

    private Spinner dateSpinner;
    private Spinner timeSpinner;
    private EditText et_j_ec_name;
    private Button btn_j_ec_create;
    private ArrayList<MyEvent> selectedEventList;
    private MyEventAdapter adapter;
    private ImageView iv_j_ec_homebtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.event_creator_ui);

        dateSpinner = findViewById(R.id.dateSpinner);
        timeSpinner = findViewById(R.id.timeSpinner);
        et_j_ec_name = findViewById(R.id.et_v_ec_name);
        btn_j_ec_create = findViewById(R.id.btn_v_ec_create);
        iv_j_ec_homebtn = findViewById(R.id.iv_v_ec_homebtn);

        // Populate date spinner
        populateDateSpinner();

        // Populate time spinner
        populateTimeSpinner();

        selectedEventList = new ArrayList<>();

        btn_j_ec_create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle save event action
                String selectedDate = dateSpinner.getSelectedItem().toString();
                String selectedTime = timeSpinner.getSelectedItem().toString();
                String eventDescription = et_j_ec_name.getText().toString();

                MyEvent myEvent = new MyEvent("username", selectedDate, selectedTime, eventDescription);

                // Save the selected event to CalendarUI
                addEventToCalendar(myEvent);

                et_j_ec_name.setText("");

                Toast.makeText(Event_Creator.this, "Event Saved: " + selectedDate + " " + selectedTime + "\nDescription: " + eventDescription, Toast.LENGTH_SHORT).show();
            }
        });

        iv_j_ec_homebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Go back to ChooseOption screen
                Intent i = new Intent(Event_Creator.this, ChooseOption.class);
                startActivity(i);
            }
        });


    }

    private void populateDateSpinner() {
        // Populate date spinner
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

        ArrayList<String> times = new ArrayList<>();
        SimpleDateFormat timeFormat = new SimpleDateFormat("hh:mm a", Locale.getDefault());
        for (int i = 0; i < 24; i++) {
            times.add(timeFormat.format(new Date(2023, 1, 1, i, 0)));
        }

        ArrayAdapter<String> timeAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, times);
        timeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        timeSpinner.setAdapter(timeAdapter);
    }

    private void addEventToCalendar(MyEvent myEvent) {
        // Pass the event to CalendarUI using Intent
        Intent intent = new Intent(Event_Creator.this, CalendarUI.class);
        intent.putExtra("myEvent", myEvent);
        startActivity(intent);
    }
}