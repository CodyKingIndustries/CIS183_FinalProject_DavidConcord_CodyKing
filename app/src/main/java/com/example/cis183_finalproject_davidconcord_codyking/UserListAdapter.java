package com.example.cis183_finalproject_davidconcord_codyking;

import android.widget.BaseAdapter;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.ArrayList;

public class UserListAdapter extends BaseAdapter
{
    Context context;
    ArrayList<User> listOfUsers;

    public UserListAdapter(Context c, ArrayList<User> ls)
    {
        context = c;
        listOfUsers = ls;
    }

    @Override
    public int getCount()
    {
        return listOfUsers.size();
    }

    @Override
    public Object getItem(int i)
    {
        return listOfUsers.get(i);
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
        User user = listOfUsers.get(i);
        tv_j_usercell_username.setText(user.getUsername());
        tv_j_usercell_lnamefname.setText(user.getLname() + ", " + user.getFname());

        return view;
    }
}
