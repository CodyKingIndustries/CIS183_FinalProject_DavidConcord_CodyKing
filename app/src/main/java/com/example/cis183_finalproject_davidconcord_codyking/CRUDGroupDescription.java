package com.example.cis183_finalproject_davidconcord_codyking;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
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
    GroupDatabaseHelper gdbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crudgroup_description);
        tv_j_dg_gname = findViewById(R.id.tv_v_dg_gname);
        tv_j_dg_gid = findViewById(R.id.tv_v_dg_gid);
        tv_j_dg_gowner = findViewById(R.id.tv_v_dg_gowner);
        btn_j_dg_back = findViewById(R.id.btn_v_dg_back);
        btn_j_dg_delete = findViewById(R.id.btn_v_dg_delete);
        gdbHelper = new GroupDatabaseHelper(this);
        mainActivity = new Intent(this, GroupList.class);

        Intent cameFrom = getIntent();
        mainActivity = new Intent(this, GroupList.class);
        group = (Group) cameFrom.getSerializableExtra("Group");

        description();
        deleteThis();
        back();
    }
    public void description()
    {
        tv_j_dg_gname.setText("Group Name: " + group.getGname());
        tv_j_dg_gowner.setText("Group Owner: " + group.getGowner());
        tv_j_dg_gid.setText("Group ID: " + group.getGid());
    }
    public void deleteThis()
    {
        btn_j_dg_delete.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                gdbHelper.deleteGroup(group.getGname());
                startActivity(mainActivity);
            }
        });
    }
    public void back()
    {
        btn_j_dg_back.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                startActivity(mainActivity);
            }
        });
    }
}