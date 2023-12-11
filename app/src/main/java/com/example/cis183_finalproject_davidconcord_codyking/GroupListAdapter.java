package com.example.cis183_finalproject_davidconcord_codyking;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class GroupListAdapter extends BaseAdapter
{
    Context context;
    ArrayList<Group> listOfGroups;

    public GroupListAdapter(Context c, ArrayList<Group> ls)
    {
        context = c;
        listOfGroups = ls;
    }

    @Override
    public int getCount()
    {
        return listOfGroups.size();
    }

    @Override
    public Object getItem(int i)
    {
        return listOfGroups.get(i);
    }

    @Override
    public long getItemId(int i)
    {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup)
    {
        if (view == null)
        {
            LayoutInflater mInflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            view = mInflater.inflate(R.layout.usercell, null);
        }
        TextView tv_j_usercell_username = view.findViewById(R.id.tv_v_usercell_username);
        TextView tv_j_usercell_lnamefname = view.findViewById(R.id.tv_v_usercell_lnamefname);
        Group group = listOfGroups.get(i);
        tv_j_usercell_username.setText(group.getGname());

        return view;
    }
}
