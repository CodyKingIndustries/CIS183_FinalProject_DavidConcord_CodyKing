package com.example.cis183_finalproject_davidconcord_codyking;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CalendarView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Calendar;

public class CalendarUI extends AppCompatActivity {

    private MyEventAdapter eventAdapter;
    private ArrayList<MyEvent> eventList;
    Group group;
    Intent mainActivity;
    Intent calendarScreen;
    ImageView iv_j_c_homebtn;
    Button btn_j_c_ascend;
    Button btn_j_c_descend;
    CalendarView cv_j_c_eventdate;
    Calendar cv_j_c_eventcalendar;
    String eventDate;
    int option;
    int optionPicked;
    EventListAdapter eventListAdapter;
    ArrayList<Event> eventArray;
    EventDatabaseHelper edbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calendar_ui);
        ListView lv_j_c_calender = findViewById(R.id.lv_v_c_calender);
        iv_j_c_homebtn = findViewById(R.id.iv_v_c_homebtn);
        cv_j_c_eventdate = findViewById(R.id.cv_v_c_calendar);
        cv_j_c_eventcalendar = Calendar.getInstance();
        btn_j_c_ascend = findViewById(R.id.btn_v_c_ascend);
        btn_j_c_descend = findViewById(R.id.btn_v_c_descend);
        edbHelper = new EventDatabaseHelper(this);
        edbHelper.initializeDB();
        mainActivity = new Intent(this, ChooseOption.class);
        calendarScreen = new Intent(this, CalendarUI.class);
        Intent cameFrom = getIntent();
        group = (Group) cameFrom.getSerializableExtra("Group");
        Intent intent = getIntent();
        optionPicked = (int) cameFrom.getSerializableExtra("Num");
        eventDate = (String) cameFrom.getSerializableExtra("EventDate");


        if (optionPicked == 2)
        {
            eventArray = edbHelper.getAllEventsByAsc();
            eventListAdapter = new EventListAdapter(this, eventArray);
            lv_j_c_calender.setAdapter(eventListAdapter);
        }
        if (optionPicked == 3)
        {
            eventArray = edbHelper.getAllEventsByDesc();
            eventListAdapter = new EventListAdapter(this, eventArray);
            lv_j_c_calender.setAdapter(eventListAdapter);
        }
        if (optionPicked == 1)
        {
            eventArray = edbHelper.getAllEventsByDate(eventDate);
            eventListAdapter = new EventListAdapter(this, eventArray);
            lv_j_c_calender.setAdapter(eventListAdapter);
        }

        iv_j_c_homebtn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                mainActivity.putExtra("Group", group);
                startActivity(mainActivity);
            }
        });
        btn_j_c_ascend.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                option = 2;
                eventDate = "null";
                calendarScreen.putExtra("EventDate", eventDate);
                calendarScreen.putExtra("Group", group);
                calendarScreen.putExtra("Num", option);
                startActivity(calendarScreen);
            }
        });
        btn_j_c_descend.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                option = 3;
                eventDate = "null";
                calendarScreen.putExtra("EventDate", eventDate);
                calendarScreen.putExtra("Group", group);
                calendarScreen.putExtra("Num", option);
                startActivity(calendarScreen);
            }
        });
        cv_j_c_eventdate.setOnDateChangeListener(new CalendarView.OnDateChangeListener()
        {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth)
            {
                eventDate = String.valueOf(dayOfMonth) + "/" + String.valueOf(month) + "/" + String.valueOf(year);
                option = 1;
                calendarScreen.putExtra("Group", group);
                calendarScreen.putExtra("Num", option);
                calendarScreen.putExtra("EventDate", eventDate);
                startActivity(calendarScreen);
            }
        });


    }
}
