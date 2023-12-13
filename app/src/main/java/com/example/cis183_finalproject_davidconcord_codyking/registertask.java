package com.example.cis183_finalproject_davidconcord_codyking;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.content.Intent;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.Button;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;

public class registertask extends AppCompatActivity
{
    EditText et_j_rt_eventname;
    CalendarView cv_j_rt_eventdate;
    Calendar cv_j_rt_eventcalendar;
    EditText et_j_rt_time;
    ImageView iv_j_rt_homebtn;
    Button btn_j_rt_create;
    boolean newEvent;
    String eventDate;
    Intent mainActivity;
    Group group;
    ArrayList<Event> eventList;
    EventDatabaseHelper edbHelper;
    Event newestEvent;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registertask);
        iv_j_rt_homebtn = findViewById(R.id.iv_v_rt_homebtn);
        btn_j_rt_create = findViewById(R.id.btn_v_rt_create);
        et_j_rt_eventname = findViewById(R.id.et_v_rt_name);
        et_j_rt_time = findViewById(R.id.et_v_rt_time);
        cv_j_rt_eventdate = findViewById(R.id.cv_v_rt_calendar);
        cv_j_rt_eventcalendar = Calendar.getInstance();
        edbHelper = new EventDatabaseHelper(this);
        edbHelper.initializeDB();
        Intent cameFrom = getIntent();
        group = (Group) cameFrom.getSerializableExtra("Group");
        mainActivity = new Intent(this, TaskList.class);

        eventList = edbHelper.getAllEvents();

        backButtonEvent();
        registerButtonEvent();

        cv_j_rt_eventdate.setOnDateChangeListener(new CalendarView.OnDateChangeListener()
        {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth)
            {
                eventDate = String.valueOf(dayOfMonth) + "/" + String.valueOf(month) + "/" + String.valueOf(year);
            }
        });
    }

    public void backButtonEvent()
    {
        iv_j_rt_homebtn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                mainActivity.putExtra("Group", group);
                startActivity(mainActivity);
            }
        });
    }

    public void registerButtonEvent()
    {
        btn_j_rt_create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                String n = et_j_rt_eventname.getText().toString();
                String t = et_j_rt_time.getText().toString();
                String d = eventDate;
                String gi = group.getGname();
                newEvent = true;
                if (n.equals("") || t.equals("") || d.equals("") || gi.equals("")) {
                    Toast.makeText(registertask.this, "All fields must be filled", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    newEvent = true;
                    for (int i = 0; i < eventList.size(); i++)
                    {
                        if (n.equals(eventList.get(i).getEname()))
                        {
                            newEvent = false;
                        }
                    }
                    if (newEvent)
                    {
                        newestEvent = new Event(n, t, d, gi);
                        edbHelper.addNewEvent(newestEvent);
                        mainActivity.putExtra("Group", group);
                        startActivity(mainActivity);
                    }
                    else
                    {
                        Toast.makeText(registertask.this, "Group name already in use", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}