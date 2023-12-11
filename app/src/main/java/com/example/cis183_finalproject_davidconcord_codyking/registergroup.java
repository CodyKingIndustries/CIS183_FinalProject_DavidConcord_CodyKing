package com.example.cis183_finalproject_davidconcord_codyking;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class registergroup extends AppCompatActivity
{
    EditText et_j_rg_groupid;
    EditText et_j_rg_groupname;
    EditText et_j_rg_grouppassword;
    Button btn_j_rg_create;
    ImageView iv_j_rg_homebtn;
    boolean newGroup;
    Group newestGroup;
    GroupDatabaseHelper gdbHelper;
    ArrayList<Group> groupList;
    Intent hub;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registergroup);
        btn_j_rg_create = findViewById(R.id.btn_v_rg_create);
        iv_j_rg_homebtn = findViewById(R.id.iv_v_rg_homebtn);
        et_j_rg_groupid = findViewById(R.id.et_v_rg_groupid);
        et_j_rg_groupname = findViewById(R.id.et_v_rg_groupname);
        et_j_rg_grouppassword = findViewById(R.id.et_v_rg_grouppassword);

        hub = new Intent(this, hubpage.class);
        gdbHelper = new GroupDatabaseHelper(this);

        groupList = gdbHelper.getAllRows();

        backButtonEvent();
        registerButtonEvent();
    }

    public void backButtonEvent() {
        iv_j_rg_homebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(hub);
            }
        });
    }

    public void registerButtonEvent() {
        btn_j_rg_create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String f = et_j_rg_groupid.getText().toString();
                String l = et_j_rg_grouppassword.getText().toString();
                String u = et_j_rg_groupname.getText().toString();
                newGroup = true;
                if (f.equals("") || l.equals("") || u.equals("")) {
                    Toast.makeText(registergroup.this, "All fields must be filled", Toast.LENGTH_SHORT).show();
                } else {
                    newGroup = true;
                    for (int i = 0; i < groupList.size(); i++) {
                        if (u.equals(groupList.get(i).getGname())) {
                            newGroup = false;
                        }
                    }
                    if (newGroup) {
                        newestGroup = new Group(f, l, u);
                        gdbHelper.addNewGroup(newestGroup);
                        startActivity(hub);
                    } else {
                        Toast.makeText(registergroup.this, "Group name already in use", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}