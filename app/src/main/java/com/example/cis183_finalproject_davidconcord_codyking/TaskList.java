package com.example.cis183_finalproject_davidconcord_codyking;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ListView;

public class TaskList extends AppCompatActivity
{
    ImageView iv_j_tl_addbtn;
    ImageView iv_j_tl_homebtn;
    ListView lv_j_tl_tasklist;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_list);
        iv_j_tl_addbtn = findViewById(R.id.iv_v_tl_addbtn);
        iv_j_tl_homebtn = findViewById(R.id.iv_v_tl_homebtn);
        lv_j_tl_tasklist = findViewById(R.id.lv_v_tl_tasklist);
    }
}