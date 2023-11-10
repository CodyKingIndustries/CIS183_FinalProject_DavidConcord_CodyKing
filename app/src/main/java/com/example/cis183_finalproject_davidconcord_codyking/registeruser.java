package com.example.cis183_finalproject_davidconcord_codyking;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.content.Intent;
import java.util.ArrayList;

public class registeruser extends AppCompatActivity
{
    Button btn_j_r_back;
    Button btn_j_r_register;

    Intent mainActivity;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registeruser);

        btn_j_r_register = findViewById(R.id.btn_v_r_register);
        btn_j_r_back = findViewById(R.id.btn_v_r_back);

        mainActivity = new Intent(registeruser.this, MainActivity.class);
    }

    public void backButtonEvent()
    {
        btn_j_r_back.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                startActivity(mainActivity);
            }
        });
    }
}