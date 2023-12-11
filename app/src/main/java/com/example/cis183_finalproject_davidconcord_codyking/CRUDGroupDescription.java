package com.example.cis183_finalproject_davidconcord_codyking;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class CRUDGroupDescription extends AppCompatActivity {
    TextView tv_j_dg_gname;
    TextView tv_j_dg_gid;
    TextView tv_j_dg_gowner;
    Button btn_j_dg_back;
    Button btn_j_dg_delete;

    Intent mainActivity;
    Group group;
    GroupDatabaseHelper dbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crudgroup_description);
        tv_j_dg_gname = findViewById(R.id.tv_v_dg_fname);
        tv_j_dg_gid = findViewById(R.id.tv_v_d_lname);
        tv_j_dg_gowner = findViewById(R.id.tv_v_d_username);
    }
}