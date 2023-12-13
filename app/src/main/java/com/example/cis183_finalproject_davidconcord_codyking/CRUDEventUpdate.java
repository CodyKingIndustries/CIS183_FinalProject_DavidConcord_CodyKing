package com.example.cis183_finalproject_davidconcord_codyking;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class CRUDEventUpdate extends AppCompatActivity
{
    TextView tv_j_crude_eventname;
    TextView tv_j_crude_groupname;
    EditText et_j_crude_eventdate;
    EditText et_j_crude_eventtime;
    Button btn_j_crude_update;
    Button btn_j_crude_back;
    Intent mainActivity;
    ArrayList<Event> eventList;
    Event event;
    Group group;
    EventDatabaseHelper edbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crudevent_update);
        tv_j_crude_eventname = findViewById(R.id.tv_v_crude_eventname);
        tv_j_crude_groupname = findViewById(R.id.tv_v_crude_groupname);
        et_j_crude_eventdate = findViewById(R.id.et_v_crude_eventdate);
        et_j_crude_eventtime = findViewById(R.id.et_v_crude_eventtime);
        btn_j_crude_update = findViewById(R.id.btn_v_crude_update);
        btn_j_crude_back = findViewById(R.id.btn_v_crude_back);
        edbHelper = new EventDatabaseHelper(this);

        mainActivity = new Intent(this, TaskList.class);
        Intent cameFrom = getIntent();
        eventList = (ArrayList<Event>) cameFrom.getSerializableExtra("EventList");
        event = (Event) cameFrom.getSerializableExtra("Event");
        group = (Group) cameFrom.getSerializableExtra("Group");

        description();
        updateButton();
        back();
    }
    public void description()
    {
        tv_j_crude_eventname.setText(event.getEname());
        tv_j_crude_groupname.setText(event.getEgid());
        et_j_crude_eventdate.setText(event.getEdate(), TextView.BufferType.EDITABLE);
        et_j_crude_eventtime.setText(event.getEtime(), TextView.BufferType.EDITABLE);
    }
    public void back()
    {
        btn_j_crude_back.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                mainActivity.putExtra("Group", group);
                startActivity(mainActivity);
            }
        });
    }
    public void updateButton()
    {
        btn_j_crude_update.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                String n = tv_j_crude_eventname.getText().toString();
                String t = et_j_crude_eventtime.getText().toString();
                String d = et_j_crude_eventdate.getText().toString();
                String gi = tv_j_crude_groupname.getText().toString();

                if (n.equals("") || t.equals("") || d.equals("") || gi.equals(""))
                {

                }
                else
                {
                    Event newEvent = new Event(n, t, d, gi);
                    edbHelper.updateEvent(newEvent);
                    mainActivity.putExtra("Group", group);
                    startActivity(mainActivity);
                }
            }
        });
    }
}