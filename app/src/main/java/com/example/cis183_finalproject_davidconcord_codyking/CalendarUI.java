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

        ListView lv_j_c_calender = findViewById(R.id.lv_v_c_calender);

        Intent intent = getIntent();
        if (intent != null) {
            MyEvent myEvent = (MyEvent) intent.getSerializableExtra("myEvent");

            if (myEvent != null) {
                // Initialize the adapter and set it to the ListView
                eventList = new ArrayList<>();
                eventList.add(myEvent);
                eventAdapter = new MyEventAdapter(this, eventList);
                lv_j_c_calender.setAdapter(eventAdapter);
            }
        }
    }


}
