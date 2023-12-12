package com.example.cis183_finalproject_davidconcord_codyking;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
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


                lv_j_c_calender.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        // Handle item click
                        MyEvent clickedEvent = eventList.get(position);

                        // Start the CRUD activity
                        Intent crudIntent = new Intent(CalendarUI.this, CRUDEventDescribe.class);
                        crudIntent.putExtra("clickedEvent", clickedEvent);
                        startActivity(crudIntent);
                    }
                });
            }
        }
    }
}
