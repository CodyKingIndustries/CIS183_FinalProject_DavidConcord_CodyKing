package com.example.cis183_finalproject_davidconcord_codyking;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

public class GroupList extends AppCompatActivity
{
    ImageView iv_j_gl_addbtn;
    ImageView iv_j_gl_homebtn;
    ListView lv_j_gl_tasklist;
    Intent mainActivity;
    Intent addScreen;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group_list);
        iv_j_gl_addbtn = findViewById(R.id.iv_v_gl_addbtn);
        iv_j_gl_homebtn = findViewById(R.id.iv_v_gl_homebtn);
        lv_j_gl_tasklist = findViewById(R.id.lv_v_gl_grouplist);
        mainActivity = new Intent(this, hubpage.class);
        addScreen = new Intent(this, registeruser.class);
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
}