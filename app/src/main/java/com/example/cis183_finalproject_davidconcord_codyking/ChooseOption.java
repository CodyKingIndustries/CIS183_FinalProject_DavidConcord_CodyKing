package com.example.cis183_finalproject_davidconcord_codyking;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class ChooseOption extends AppCompatActivity
{

    ImageView iv_j_ct_calender;
    ImageView iv_j_ct_tasks;
    ImageView iv_j_ct_homebtn;
    TextView tv_j_ct_groupname;
    Group group;
    String eventDate;
    Intent goToQuery;
    Intent goToList;
    int option;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_option);

        iv_j_ct_calender = findViewById(R.id.iv_v_ct_calender);
        iv_j_ct_tasks = findViewById(R.id.iv_v_ct_tasks);
        iv_j_ct_homebtn = findViewById(R.id.iv_v_ct_homebtn);
        tv_j_ct_groupname = findViewById(R.id.tv_v_ct_groupname);
        Intent cameFrom = getIntent();
        group = (Group) cameFrom.getSerializableExtra("Group");
        goToQuery = new Intent(this, CalendarUI.class);
        goToList = new Intent(this, TaskList.class);
        tv_j_ct_groupname.setText(group.getGname());
        option = 0;
        eventDate = "null";

        iv_j_ct_calender.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                goToQuery.putExtra("EventDate", eventDate);
                goToQuery.putExtra("Num", option);
                goToQuery.putExtra("Group", group);
                startActivity(goToQuery);;
            }
        });

        iv_j_ct_tasks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                goToList.putExtra("Group", group);
                startActivity(goToList);
            }
        });
        iv_j_ct_homebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                goToHome();
            }
        });
    }

    private void goToHome()
    {
        Intent intent3 = new Intent(this, hubpage.class);
        startActivity(intent3);
    }

}
