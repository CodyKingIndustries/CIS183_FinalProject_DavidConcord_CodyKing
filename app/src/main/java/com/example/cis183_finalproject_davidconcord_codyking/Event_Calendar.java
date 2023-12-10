package com.example.cis183_finalproject_davidconcord_codyking;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class Event_Calendar extends AppCompatActivity {

    private ListView listView;
    private MyEventAdapter eventAdapter;
    private ArrayList<MyEvent> eventList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calendar_ui);

        listView = findViewById(R.id.lv_v_c_calender);  // Replace with your actual ListView ID

        eventList = new ArrayList<>();
        eventAdapter = new MyEventAdapter(this, eventList);
        listView.setAdapter(eventAdapter);

        // Retrieve the selected dates and times from event_Creator
        if (getIntent().hasExtra("selectedDateTimeList")) {
            ArrayList<String> selectedDateTimeList = getIntent().getStringArrayListExtra("selectedDateTimeList");

            // Iterate through the list and create MyEvent objects
            for (String dateTime : selectedDateTimeList) {
                // Split the date and time (modify this based on your actual format)
                String[] parts = dateTime.split(" ");
                String date = parts[0];
                String time = parts[1];

                // Create MyEvent object and add it to the list
                MyEvent event = new MyEvent(date, time, "Description"); // Replace "Description" with your actual description or fetch it from the user
                eventList.add(event);
            }

            // Notify the adapter that the data set has changed
            eventAdapter.notifyDataSetChanged();
        }
    }
}
