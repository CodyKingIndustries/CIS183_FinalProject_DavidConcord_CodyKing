package com.example.cis183_finalproject_davidconcord_codyking;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class ChooseOption extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_option);


        Button btnGoToCalendar = findViewById(R.id.btnGoToCalendar);
        Button btnGoToEventCreator = findViewById(R.id.btnGoToEventCreator);

        btnGoToCalendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToCalendar();
            }
        });

        btnGoToEventCreator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToEventCreator();
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
        Intent intent = new Intent(this, event_Creator.class);
        startActivity(intent);
    }
}
