package com.example.cis183_finalproject_davidconcord_codyking;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class ChooseOption extends AppCompatActivity
{

    ImageView iv_j_ct_calender;
    ImageView iv_j_ct_tasks;
    ImageView iv_j_ct_homebtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_option);

        iv_j_ct_calender = findViewById(R.id.iv_v_ct_calender);
        iv_j_ct_tasks = findViewById(R.id.iv_v_ct_tasks);
        iv_j_ct_homebtn = findViewById(R.id.iv_v_ct_homebtn);

        iv_j_ct_calender.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                goToCalendar();
            }
        });

        iv_j_ct_tasks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToEventCreator();
            }
        });
        iv_j_ct_homebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToHome();
            }
        });
    }

    private void goToCalendar()
    {
        Intent intent2 = new Intent(this, CalendarUI.class);
        startActivity(intent2);
    }

    private void goToEventCreator()
    {
        Intent intent = new Intent(this, Event_Creator.class);
        startActivity(intent);
    }

    private void goToHome()
    {
        Intent intent3 = new Intent(this, MainActivity.class);
        startActivity(intent3);
    }

}
