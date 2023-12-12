package com.example.cis183_finalproject_davidconcord_codyking;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CRUDdescription extends AppCompatActivity
{
    TextView tv_j_d_fname;
    TextView tv_j_d_lname;
    TextView tv_j_d_username;
    TextView tv_j_d_password;
    TextView tv_j_d_email;
    TextView tv_j_d_age;
    Button btn_j_d_back;
    Button btn_j_d_delete;

    Intent mainActivity;
    User user;
    UserDatabaseHelper dbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cruddescription);
        tv_j_d_fname = findViewById(R.id.tv_v_d_fname);
        tv_j_d_lname = findViewById(R.id.tv_v_d_lname);
        tv_j_d_username = findViewById(R.id.tv_v_d_username);
        tv_j_d_password = findViewById(R.id.tv_v_d_password);
        tv_j_d_email = findViewById(R.id.tv_v_d_email);
        tv_j_d_age = findViewById(R.id.tv_v_d_age);
        btn_j_d_back = findViewById(R.id.btn_v_d_back);
        btn_j_d_delete = findViewById(R.id.btn_v_d_delete);
        dbHelper = new UserDatabaseHelper(this);
        mainActivity = new Intent(this, UserListScreen.class);

        Intent cameFrom = getIntent();
        mainActivity = new Intent(this, UserListScreen.class);
        user = (User) cameFrom.getSerializableExtra("User");

        description();
        deleteThis();
        back();
    }
    public void description()
    {
        tv_j_d_fname.setText("First Name: " + user.getFname());
        tv_j_d_lname.setText("Last Name: " + user.getLname());
        tv_j_d_username.setText("Username: " + user.getUsername());
        tv_j_d_password.setText("Password: " + user.getPassword());
        tv_j_d_email.setText("Email: " + user.getEmail());
        tv_j_d_age.setText("Age: " + user.getAge());
    }
    public void deleteThis()
    {
        btn_j_d_delete.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                dbHelper.deleteUser(user.getUsername());
                startActivity(mainActivity);
            }
        });
    }
    public void back()
    {
        btn_j_d_back.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                startActivity(mainActivity);
            }
        });
    }
}