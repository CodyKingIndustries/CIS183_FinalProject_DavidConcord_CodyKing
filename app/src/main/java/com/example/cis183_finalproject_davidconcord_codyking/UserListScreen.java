package com.example.cis183_finalproject_davidconcord_codyking;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.content.Intent;

public class UserListScreen extends AppCompatActivity
{
    ImageView iv_j_ul_addBtn;
    ImageView iv_j_ul_homeBtn;
    ListView lv_j_ul_userlist;
    Intent mainActivity;
    Intent addScreen;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_list_screen);

        iv_j_ul_addBtn = findViewById(R.id.iv_v_ul_addbtn);
        iv_j_ul_homeBtn = findViewById(R.id.iv_v_ul_homebtn);
        lv_j_ul_userlist = findViewById(R.id.lv_v_ul_userlist);
        mainActivity = new Intent(this, MainActivity.class);
        addScreen = new Intent(this, registeruser.class);

        iv_j_ul_homeBtn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                startActivity(mainActivity);
            }
        });

        iv_j_ul_addBtn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                startActivity(addScreen);
            }
        });
    }
}