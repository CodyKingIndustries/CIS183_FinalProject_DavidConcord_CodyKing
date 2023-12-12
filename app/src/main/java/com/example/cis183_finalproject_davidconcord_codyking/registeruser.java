// registeruser.java
package com.example.cis183_finalproject_davidconcord_codyking;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;

public class registeruser extends AppCompatActivity {
    ImageView iv_j_r_homebtn;
    Button btn_j_r_register;
    EditText et_j_r_fname;
    EditText et_j_r_lname;
    EditText et_j_r_username;
    EditText et_j_r_password;
    EditText et_j_r_email;
    EditText et_j_r_age;
    TextView tv_j_r_usernameerror;
    boolean newUser;
    User newestUser;
    UserDatabaseHelper udbHelper;
    ArrayList<User> userList;
    Intent mainActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registeruser);

        btn_j_r_register = findViewById(R.id.btn_v_r_register);
        iv_j_r_homebtn = findViewById(R.id.iv_v_r_homebtn);
        et_j_r_fname = findViewById(R.id.et_v_r_fname);
        et_j_r_lname = findViewById(R.id.et_v_r_lname);
        et_j_r_username = findViewById(R.id.et_v_r_username);
        et_j_r_password = findViewById(R.id.et_v_r_password);
        et_j_r_email = findViewById(R.id.et_v_r_email);
        et_j_r_age = findViewById(R.id.et_v_r_age);

        mainActivity = new Intent(registeruser.this, MainActivity.class);
        udbHelper = new UserDatabaseHelper(this);

        userList = udbHelper.getAllUsers();

        backButtonEvent();
        registerButtonEvent();
    }

    public void backButtonEvent() {
        iv_j_r_homebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(mainActivity);
            }
        });
    }

    public void registerButtonEvent() {
        btn_j_r_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String f = et_j_r_fname.getText().toString();
                String l = et_j_r_lname.getText().toString();
                String u = et_j_r_username.getText().toString();
                String p = et_j_r_password.getText().toString();
                String e = et_j_r_email.getText().toString();
                String a = et_j_r_age.getText().toString();
                newUser = true;
                if (f.equals("") || l.equals("") || u.equals("") || p.equals("") || e.equals("") || a.equals(""))
                {
                    Toast.makeText(registeruser.this, "All fields must be filled", Toast.LENGTH_SHORT).show();
                } else {
                    newUser = true;
                    for (int i = 0; i < userList.size(); i++)
                    {
                        if (u.equals(userList.get(i).getUsername()))
                        {
                            newUser = false;
                        }
                    }
                    if (newUser)
                    {
                        //tv_j_r_usernameerror.setVisibility(View.INVISIBLE);
                        newestUser = new User(f, l, u, p, e, a);
                        udbHelper.addNewUser(newestUser);
                        startActivity(mainActivity);
                    }
                    else
                    {
                        Toast.makeText(registeruser.this, "Username already in use", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}
