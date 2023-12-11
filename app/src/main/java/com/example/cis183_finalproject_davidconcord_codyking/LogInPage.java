package com.example.cis183_finalproject_davidconcord_codyking;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class LogInPage extends AppCompatActivity {
    ImageView iv_j_l_homebtn;
    Button btn_j_l_login;
    EditText et_j_l_username;
    EditText et_j_l_password;
    Intent mainActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in_page);

        iv_j_l_homebtn = findViewById(R.id.iv_v_l_homebtn);
        btn_j_l_login = findViewById(R.id.btn_v_l_login);
        et_j_l_username = findViewById(R.id.et_v_l_username);
        et_j_l_password = findViewById(R.id.et_v_l_password);
        mainActivity = new Intent(LogInPage.this, MainActivity.class);

        homeButtonEvent();
        logInButtonEvent();
    }

    public void homeButtonEvent() {
        iv_j_l_homebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(mainActivity);
            }
        });
    }

    public void logInButtonEvent() {
        btn_j_l_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String enteredUsername = et_j_l_username.getText().toString();
                String enteredPassword = et_j_l_password.getText().toString();

                // Validate the entered credentials against the database
                if (isValidCredentials(enteredUsername, enteredPassword)) {
                    // Navigate to ChooseOption activity
                    Intent goToChooseOption = new Intent(LogInPage.this, hubpage.class);
                    startActivity(goToChooseOption);
                } else {
                    // Display an error message or handle invalid credentials
                    Toast.makeText(LogInPage.this, "Invalid username or password", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private boolean isValidCredentials(String enteredUsername, String enteredPassword) {
        // Retrieve the stored password for the entered username from the database
        String storedPassword = getPasswordFromDatabase(enteredUsername);

        // Compare the entered password with the stored password
        return enteredPassword.equals(storedPassword);
    }

    @SuppressLint("Range")
    private String getPasswordFromDatabase(String username) {
        UserDatabaseHelper dbHelper = new UserDatabaseHelper(this);
        SQLiteDatabase db = dbHelper.getReadableDatabase();

        Cursor cursor = db.rawQuery("SELECT password FROM Users WHERE username = ?", new String[]{username});

        String storedPassword = "";

        if (cursor.moveToFirst()) {
            storedPassword = cursor.getString(cursor.getColumnIndex("password"));
        }

        cursor.close();
        db.close();

        return storedPassword;
    }
}
