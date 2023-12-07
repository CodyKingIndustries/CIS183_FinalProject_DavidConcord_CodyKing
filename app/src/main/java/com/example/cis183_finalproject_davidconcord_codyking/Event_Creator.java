package com.example.cis183_finalproject_davidconcord_codyking;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class event_Creator extends Activity {

    private Spinner dateSpinner;
    private Spinner timeSpinner;
    private EditText etEventDescription;
    private Button btnSaveEvent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.event_creator_ui);

        dateSpinner = findViewById(R.id.dateSpinner);
        timeSpinner = findViewById(R.id.timeSpinner);
        etEventDescription = findViewById(R.id.etEventDescription);
        btnSaveEvent = findViewById(R.id.btnSaveEvent);

        // Populate date spinner
        String[] dates = {"2023-12-01", "2023-12-02", "2023-12-03"};
        ArrayAdapter<String> dateAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, dates);
        dateAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        dateSpinner.setAdapter(dateAdapter);

        // Populate time spinner
        String[] times = {"08:00 AM", "12:00 PM", "03:00 PM"};
        ArrayAdapter<String> timeAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, times);
        timeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        timeSpinner.setAdapter(timeAdapter);

        // Button click event
        btnSaveEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle save event action
                String selectedDate = dateSpinner.getSelectedItem().toString();
                String selectedTime = timeSpinner.getSelectedItem().toString();
                String eventDescription = etEventDescription.getText().toString();

                saveEvent(selectedDate, selectedTime, eventDescription);

                Toast.makeText(event_Creator.this, "Event Saved: " + selectedDate + " " + selectedTime + "\nDescription: " + eventDescription, Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void saveEvent(String date, String time, String description) {

    }
}
