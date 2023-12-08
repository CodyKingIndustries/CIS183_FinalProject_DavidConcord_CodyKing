package com.example.cis183_finalproject_davidconcord_codyking;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.content.Intent;
import android.widget.TextView;

import java.util.ArrayList;

public class LogInPage extends AppCompatActivity
{
    ImageView iv_j_l_homebtn;
    Button btn_j_l_login;
    EditText et_j_l_username;
    EditText et_j_l_password;
    Intent mainActivity;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in_page);

        iv_j_l_homebtn = findViewById(R.id.iv_v_l_homebtn);
        btn_j_l_login = findViewById(R.id.btn_v_l_login);
        et_j_l_username = findViewById(R.id.et_v_l_username);
        mainActivity = new Intent(LogInPage.this, MainActivity.class);

        homeButtonEvent();
    }

    public void homeButtonEvent()
    {
        iv_j_l_homebtn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                startActivity(mainActivity);
            }
        });
    }

    public void logInButtonEvent()
    {
        btn_j_l_login.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                calendarScreen();
            }
        });
    }
    public void calendarScreen()
    {
        Intent goToCalendar = new Intent(this, ChooseOption.class);
        startActivity(goToCalendar);
    }
}