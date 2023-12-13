package com.example.cis183_finalproject_davidconcord_codyking;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CRUDEventDescription extends AppCompatActivity
{
    TextView tv_j_de_ename;
    TextView tv_j_de_edate;
    TextView tv_j_de_etime;
    TextView tv_j_de_gname;
    Button btn_j_de_back;
    Button btn_j_de_delete;

    Intent mainActivity;
    Group group;
    Event event;
    EventDatabaseHelper edbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crudevent_description);
        tv_j_de_ename = findViewById(R.id.tv_v_de_ename);
        tv_j_de_edate = findViewById(R.id.tv_v_de_edate);
        tv_j_de_etime = findViewById(R.id.tv_v_de_etime);
        tv_j_de_gname = findViewById(R.id.tv_v_de_gname);
        btn_j_de_back = findViewById(R.id.btn_v_de_back);
        btn_j_de_delete = findViewById(R.id.btn_v_de_delete);
        edbHelper = new EventDatabaseHelper(this);

        Intent cameFrom = getIntent();
        mainActivity = new Intent(this, TaskList.class);
        group = (Group) cameFrom.getSerializableExtra("Group");
        event = (Event) cameFrom.getSerializableExtra("Event");

        description();
        deleteThis();
        back();
    }
    public void description()
    {
        tv_j_de_ename.setText("Event Name: " + event.getEname());
        tv_j_de_edate.setText("Event Date: " + event.getEdate());
        tv_j_de_etime.setText("Event Time: " + event.getEtime());
        tv_j_de_gname.setText("Group Name: " + event.getEgid());
    }
    public void deleteThis()
    {
        btn_j_de_delete.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                edbHelper.deleteEvent(event.getEname());
                startActivity(mainActivity);
            }
        });
    }
    public void back()
    {
        btn_j_de_back.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                mainActivity.putExtra("Group", group);
                startActivity(mainActivity);
            }
        });
    }
}