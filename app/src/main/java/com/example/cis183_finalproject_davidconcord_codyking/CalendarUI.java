package com.example.cis183_finalproject_davidconcord_codyking;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class CalendarUI extends AppCompatActivity {

    private MyEventAdapter eventAdapter;
    private ArrayList<MyEvent> eventList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calendar_ui);

        ListView listView = findViewById(R.id.listView);
        eventList = new ArrayList<>();
        eventAdapter = new MyEventAdapter(this, eventList);
        listView.setAdapter(eventAdapter);
    }

    private void addEvent(String date, String time, String description) {
        MyEvent newEvent = new MyEvent(date, time, description);
        eventList.add(newEvent);

        // Sort events by date if needed
        sortEventsByDate();

        // Notify the adapter of the changes
        eventAdapter.notifyDataSetChanged();
    }

    private void sortEventsByDate() {

    }

    public void onAddEventButtonClick(View view) {

        addEvent("", "", "");
    }
}
