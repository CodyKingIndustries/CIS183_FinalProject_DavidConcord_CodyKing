package com.example.cis183_finalproject_davidconcord_codyking;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;

public class EventListGetGroup extends AppCompatActivity
{
    ListView lv_j_eventgroup_grouplist;
    Intent mainActivity;
    GroupListAdapter groupListAdapter;
    ArrayList<Group> groupArray;
    GroupDatabaseHelper gdbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_list_get_group);
        lv_j_eventgroup_grouplist = findViewById(R.id.lv_v_eventgroup_grouplist);
        mainActivity = new Intent(this, ChooseOption.class);
        gdbHelper = new GroupDatabaseHelper(this);
        gdbHelper.initializeDB();
        groupArray = new ArrayList<Group>();
        groupArray = gdbHelper.getAllGroups();
        displayGroups();
        sendGroup();
    }

    public void sendGroup()
    {
        lv_j_eventgroup_grouplist.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l)
            {
                mainActivity.putExtra("Group", groupArray.get(i));
                startActivity(mainActivity);
            }
        });
    }
    public void displayGroups()
    {
        groupListAdapter = new GroupListAdapter(this, groupArray);
        lv_j_eventgroup_grouplist.setAdapter(groupListAdapter);
    }
}