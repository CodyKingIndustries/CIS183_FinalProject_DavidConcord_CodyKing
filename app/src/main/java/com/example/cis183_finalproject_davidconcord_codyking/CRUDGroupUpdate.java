package com.example.cis183_finalproject_davidconcord_codyking;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class CRUDGroupUpdate extends AppCompatActivity
{
    TextView tv_j_crudg_groupname;
    EditText et_j_crudg_groupowner;
    EditText et_j_crudg_groupid;
    Button btn_j_crudg_update;
    Button btn_j_crudg_back;
    Intent mainActivity;
    ArrayList<Group> groupList;
    Group group;
    GroupDatabaseHelper gdbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crudgroup_update);
        tv_j_crudg_groupname = findViewById(R.id.tv_v_crudg_groupname);
        et_j_crudg_groupowner = findViewById(R.id.et_v_crudg_groupowner);
        et_j_crudg_groupid = findViewById(R.id.et_v_crudg_groupid);
        btn_j_crudg_update = findViewById(R.id.btn_v_crudg_update);
        btn_j_crudg_back = findViewById(R.id.btn_v_crudg_back);
        gdbHelper = new GroupDatabaseHelper(this);

        mainActivity = new Intent(this, GroupList.class);
        Intent cameFrom = getIntent();
        groupList = (ArrayList<Group>) cameFrom.getSerializableExtra("GroupList");
        group = (Group) cameFrom.getSerializableExtra("Group");

        description();
        updateButton();
        back();
    }
    public void description()
    {
        tv_j_crudg_groupname.setText(group.getGname());
        et_j_crudg_groupowner.setText(group.getGowner(), TextView.BufferType.EDITABLE);
        et_j_crudg_groupid.setText(group.getGid(), TextView.BufferType.EDITABLE);
    }
    public void back()
    {
        btn_j_crudg_back.setOnClickListener(new View.OnClickListener()
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
        btn_j_crudg_update.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                String n = tv_j_crudg_groupname.getText().toString();
                String o = et_j_crudg_groupowner.getText().toString();
                String i = et_j_crudg_groupid.getText().toString();

                if (n.equals("") || o.equals("") || i.equals(""))
                {

                }
                else
                {
                    Group newGroup = new Group(n, o, i);
                    gdbHelper.updateGroup(newGroup);
                    startActivity(mainActivity);
                }
            }
        });
    }

}