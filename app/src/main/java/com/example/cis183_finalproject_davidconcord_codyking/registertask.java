package com.example.cis183_finalproject_davidconcord_codyking;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.content.Intent;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.Button;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class registertask extends AppCompatActivity
{
    EditText et_j_rt_eventname;
    CalendarView cv_j_rt_eventdate;
    Calendar event_calendar;
    EditText et_j_rt_time;
    ImageView iv_j_rt_homebtn;
    Button btn_j_rt_create;
    Intent mainActivity;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registertask);
        iv_j_rt_homebtn = findViewById(R.id.iv_v_rt_homebtn);
        btn_j_rt_create = findViewById(R.id.btn_v_rt_create);
        et_j_rt_eventname = findViewById(R.id.et_v_rt_name);
        et_j_rt_time = findViewById(R.id.et_v_rt_time);
        cv_j_rt_eventdate = findViewById(R.id.cv_v_rt_calendar);
        mainActivity = new Intent(this, MainActivity.class);

        iv_j_rt_homebtn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                startActivity(mainActivity);
            }
        });

        cv_j_rt_eventdate.setOnDateChangeListener(new CalendarView.OnDateChangeListener()
        {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth)
            {
                getDate();
            }
        });
    }

    public void getDate()
    {
        long date = cv_j_rt_eventdate.getDate();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yy", Locale.getDefault());
        event_calendar.setTimeInMillis(date);
        String selected_date = simpleDateFormat.format(event_calendar.getTime());
    }
}