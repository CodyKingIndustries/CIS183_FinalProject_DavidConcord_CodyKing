package com.example.cis183_finalproject_davidconcord_codyking;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

public class TaskList extends AppCompatActivity
{
    ImageView iv_j_tl_addbtn;
    ImageView iv_j_tl_homebtn;
    ListView lv_j_tl_tasklist;
    Intent mainActivity;
    Intent addScreen;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_list);
        iv_j_tl_addbtn = findViewById(R.id.iv_v_tl_addbtn);
        iv_j_tl_homebtn = findViewById(R.id.iv_v_tl_homebtn);
        lv_j_tl_tasklist = findViewById(R.id.lv_v_tl_tasklist);
        mainActivity = new Intent(this, MainActivity.class);
        addScreen = new Intent(this, registertask.class);
        iv_j_tl_homebtn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                startActivity(mainActivity);
            }
        });

        iv_j_tl_addbtn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                startActivity(addScreen);
            }
        });
    }
}