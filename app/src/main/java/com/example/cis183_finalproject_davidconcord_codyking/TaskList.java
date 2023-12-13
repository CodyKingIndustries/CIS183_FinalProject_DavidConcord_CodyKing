package com.example.cis183_finalproject_davidconcord_codyking;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;

public class TaskList extends AppCompatActivity
{
    ImageView iv_j_tl_addbtn;
    ImageView iv_j_tl_homebtn;
    ListView lv_j_tl_tasklist;
    Intent mainActivity;
    Intent addScreen;
    Intent updateScreen;
    Intent detailScreen;
    Group group;
    EventListAdapter eventListAdapter;
    ArrayList<Event> eventArray;
    EventDatabaseHelper edbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_list);
        iv_j_tl_addbtn = findViewById(R.id.iv_v_tl_addbtn);
        iv_j_tl_homebtn = findViewById(R.id.iv_v_tl_homebtn);
        lv_j_tl_tasklist = findViewById(R.id.lv_v_tl_tasklist);
        Intent cameFrom = getIntent();
        group = (Group) cameFrom.getSerializableExtra("Group");
        mainActivity = new Intent(this, ChooseOption.class);
        updateScreen = new Intent(this, CRUDEventUpdate.class);
        detailScreen = new Intent(this, CRUDEventDescription.class);
        addScreen = new Intent(this, registertask.class);
        edbHelper = new EventDatabaseHelper(this);
        edbHelper.initializeDB();
        eventArray = new ArrayList<Event>();
        eventArray = edbHelper.getAllEventsByGroup(group.gname);
        displayGroups();
        updateGroup();;
        groupDescription();
        iv_j_tl_homebtn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                mainActivity.putExtra("Group", group);
                startActivity(mainActivity);
            }
        });

        iv_j_tl_addbtn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                addScreen.putExtra("Group", group);
                startActivity(addScreen);
            }
        });
    }

    public void displayGroups()
    {
        eventListAdapter = new EventListAdapter(this, eventArray);
        lv_j_tl_tasklist.setAdapter(eventListAdapter);
    }
    public void groupDescription()
    {
        lv_j_tl_tasklist.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l)
            {
                detailScreen.putExtra("Event", eventArray.get(i));
                updateScreen.putExtra("Group", group);
                startActivity(detailScreen);
            }
        });
    }
    public void updateGroup()
    {
        lv_j_tl_tasklist.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener()
        {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l)
            {
                updateScreen.putExtra("Event", eventArray.get(i));
                updateScreen.putExtra("Group", group);
                startActivity(updateScreen);
                return false;
            }
        });
    }
}