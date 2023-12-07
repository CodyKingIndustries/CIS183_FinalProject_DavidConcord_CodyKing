package com.example.cis183_finalproject_davidconcord_codyking;

import android.content.Intent;
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

        Intent intent = getIntent();
        if (intent != null) {
            MyEvent myEvent = (MyEvent) intent.getSerializableExtra("myEvent");

            if (myEvent != null) {
                // Initialize the adapter and set it to the ListView
                eventList = new ArrayList<>();
                eventList.add(myEvent);
                eventAdapter = new MyEventAdapter(this, eventList);
                listView.setAdapter(eventAdapter);
            }
        }
    }


}
