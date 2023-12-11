package com.example.cis183_finalproject_davidconcord_codyking;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;

public class GroupList extends AppCompatActivity
{
    ImageView iv_j_gl_addbtn;
    ImageView iv_j_gl_homebtn;
    ListView lv_j_gl_grouplist;
    Intent mainActivity;
    Intent updateScreen;
    Intent detailScreen;
    Intent addScreen;
    GroupListAdapter groupListAdapter;
    ArrayList<Group> groupArray;
    GroupDatabaseHelper gdbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group_list);
        iv_j_gl_addbtn = findViewById(R.id.iv_v_gl_addbtn);
        iv_j_gl_homebtn = findViewById(R.id.iv_v_gl_homebtn);
        lv_j_gl_grouplist = findViewById(R.id.lv_v_gl_grouplist);
        mainActivity = new Intent(this, hubpage.class);
        addScreen = new Intent(this, registergroup.class);
        updateScreen = new Intent(this, CRUDupdate.class);
        detailScreen = new Intent(this, CRUDdescription.class);
        groupArray = new ArrayList<Group>();
        groupArray = gdbHelper.getAllRows();

        iv_j_gl_homebtn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                startActivity(mainActivity);
            }
        });

        iv_j_gl_addbtn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                startActivity(addScreen);
            }
        });
    }

    public void displayUsers()
    {
        groupListAdapter = new GroupListAdapter(this, groupArray);
        lv_j_gl_grouplist.setAdapter(groupListAdapter);
    }
    public void userDescription()
    {
        lv_j_gl_grouplist.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l)
            {
                detailScreen.putExtra("User", groupArray.get(i));
                startActivity(detailScreen);
            }
        });
    }
    public void updateUser()
    {
        lv_j_gl_grouplist.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener()
        {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l)
            {
                updateScreen.putExtra("User", groupArray.get(i));
                startActivity(updateScreen);
                return false;
            }
        });
    }
}