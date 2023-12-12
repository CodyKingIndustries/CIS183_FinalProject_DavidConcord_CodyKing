package com.example.cis183_finalproject_davidconcord_codyking;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class CRUDEventDescribe extends AppCompatActivity {

    private EditText editTextUser;
    private EditText editTextDate;
    private EditText editTextTime;
    private EditText editTextDescription;

    private Button buttonUpdate;
    private Button buttonDelete;
    private Button buttonBack;

    private Event clickedEvent;
    private EventDatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.crud_event_describe);

        editTextUser = findViewById(R.id.editTextUser);
        editTextDate = findViewById(R.id.editTextDate);
        editTextTime = findViewById(R.id.editTextTime);
        editTextDescription = findViewById(R.id.editTextDescription);
        buttonUpdate = findViewById(R.id.buttonUpdate);
        buttonDelete = findViewById(R.id.buttonDelete);
        buttonBack = findViewById(R.id.buttonBack);

        dbHelper = new EventDatabaseHelper(this);


        clickedEvent = (Event) getIntent().getSerializableExtra("clickedEvent");

        if (clickedEvent != null) {
            editTextUser.setText(clickedEvent.getEname());
            editTextDate.setText(clickedEvent.getEdate());
            editTextTime.setText(clickedEvent.getEtime());
            editTextDescription.setText(clickedEvent.getEname());
        }

        buttonUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateEvent();
            }
        });

        buttonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteEvent();
            }
        });

        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void updateEvent() {


    }

    private void deleteEvent() {

        finish();
    }
}
