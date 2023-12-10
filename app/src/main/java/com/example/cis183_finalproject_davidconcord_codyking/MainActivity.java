//XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
//Authors: Cody King
//Date: 11/4/2023
//Description: This is a scheduling App
//XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX

package com.example.cis183_finalproject_davidconcord_codyking;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;

public class MainActivity extends AppCompatActivity
{
    Button btn_j_login;

    Button btn_j_signup;
    Intent registerUser;
    Intent logInUser;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_j_signup = findViewById(R.id.btn_v_signup);

        btn_j_login = findViewById(R.id.btn_v_login);

        registerNewUserButtonEvent();

        signInButtonEvent();

        registerUser = new Intent(MainActivity.this, registeruser.class);

        logInUser = new Intent(MainActivity.this, LogInPage.class);
    }

    public void registerNewUserButtonEvent()
    {
        btn_j_signup.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                startActivity(registerUser);
            }
        });
    }

    public void signInButtonEvent()
    {
        btn_j_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                startActivity(logInUser);
            }
        });
    }

    public void calendarScreen()
    {
        Intent goToCalendar = new Intent(this, ChooseOption.class);
        startActivity(goToCalendar);
    }
}