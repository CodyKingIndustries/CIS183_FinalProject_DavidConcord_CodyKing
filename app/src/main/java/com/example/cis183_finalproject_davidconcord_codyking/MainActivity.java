//XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
//Authors: Cody King
//Date: 11/4/2023
//Description: This is a scheduling App
//XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX

package com.example.cis183_finalproject_davidconcord_codyking;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.content.Intent;
import java.util.ArrayList;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity
{
    Button btn_j_register;
    Intent registerUser;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_j_register = findViewById(R.id.btn_v_register);

        registerUser = new Intent(MainActivity.this, registeruser.class);
    }

    public void registerNewUserButtonEvent()
    {
        btn_j_register.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                startActivity(registerUser);
            }
        });
    }
}