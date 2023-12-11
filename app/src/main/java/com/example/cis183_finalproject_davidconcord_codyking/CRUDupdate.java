package com.example.cis183_finalproject_davidconcord_codyking;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class CRUDupdate extends AppCompatActivity
{
    TextView tv_j_crudu_username;
    EditText et_j_crudu_fname;
    EditText et_j_crudu_lname;
    EditText et_j_crudu_password;
    EditText et_j_crudu_email;
    EditText et_j_crudu_age;
    Button btn_j_crudu_update;
    Button btn_j_crudu_back;

    Intent mainActivity;
    ArrayList<User> userList;
    User user;
    UserDatabaseHelper dbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crudupdate);
        tv_j_crudu_username = findViewById(R.id.tv_v_crudu_username);
        et_j_crudu_fname = findViewById(R.id.et_v_crudu_fname);
        et_j_crudu_lname = findViewById(R.id.et_v_crudu_lname);
        et_j_crudu_password = findViewById(R.id.et_v_crudu_password);
        et_j_crudu_email = findViewById(R.id.et_v_crudu_email);
        et_j_crudu_age = findViewById(R.id.et_v_crudu_age);
        btn_j_crudu_update = findViewById(R.id.btn_v_crudu_update);
        btn_j_crudu_back = findViewById(R.id.btn_v_crudu_back);
        dbHelper = new UserDatabaseHelper(this);

        mainActivity = new Intent(this, MainActivity.class);
        Intent cameFrom = getIntent();
        userList = (ArrayList<User>) cameFrom.getSerializableExtra("UserList");
        user = (User) cameFrom.getSerializableExtra("User");

        description();
        updateButton();
        back();
    }
    public void description()
    {
        tv_j_crudu_username.setText(user.getUsername());
        et_j_crudu_fname.setText(user.getFname(), TextView.BufferType.EDITABLE);
        et_j_crudu_lname.setText(user.getLname(), TextView.BufferType.EDITABLE);
        et_j_crudu_password.setText(user.getPassword(), TextView.BufferType.EDITABLE);
        et_j_crudu_email.setText(user.getEmail(), TextView.BufferType.EDITABLE);
        et_j_crudu_age.setText(user.getAge(), TextView.BufferType.EDITABLE);
    }
    public void back()
    {
        btn_j_crudu_back.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                startActivity(mainActivity);
            }
        });
    }
    public void updateButton()
    {
        btn_j_crudu_update.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                String f = et_j_crudu_fname.getText().toString();
                String l = et_j_crudu_lname.getText().toString();
                String u = tv_j_crudu_username.getText().toString();
                String p = et_j_crudu_password.getText().toString();
                String e = et_j_crudu_email.getText().toString();
                String a = et_j_crudu_age.getText().toString();

                if (u.equals("") || f.equals("") || l.equals("") || p.equals("") || e.equals("") || a.equals(""))
                {

                }
                else
                {
                    User newUser = new User(f, l, u, p, e, a);
                    dbHelper.updateUser(newUser);
                    startActivity(mainActivity);
                }
            }
        });
    }
}