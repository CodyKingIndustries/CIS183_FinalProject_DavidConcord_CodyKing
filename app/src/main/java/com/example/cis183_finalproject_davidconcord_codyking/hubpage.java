package com.example.cis183_finalproject_davidconcord_codyking;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.content.Intent;

public class hubpage extends AppCompatActivity
{
    Button btn_j_h_events;
    Button btn_j_h_groups;
    Button btn_j_h_users;
    ImageView iv_j_h_homebtn;
    Intent homepage;
    Intent users;
    Intent groups;
    Intent events;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hubpage);

        btn_j_h_events = findViewById(R.id.btn_v_h_events);
        btn_j_h_groups = findViewById(R.id.btn_v_h_groups);
        btn_j_h_users = findViewById(R.id.btn_v_h_users);
        iv_j_h_homebtn = findViewById(R.id.iv_v_h_homebtn);
        homepage = new Intent(this, MainActivity.class);
        users = new Intent(this, UserListScreen.class);
        groups = new Intent(this, GroupList.class);
        events = new Intent(this, TaskList.class);

        iv_j_h_homebtn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                startActivity(homepage);
            }
        });

        btn_j_h_users.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                startActivity(users);
            }
        });

        btn_j_h_groups.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                startActivity(groups);
            }
        });

        btn_j_h_events.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                startActivity(events);
            }
        });
    }
}