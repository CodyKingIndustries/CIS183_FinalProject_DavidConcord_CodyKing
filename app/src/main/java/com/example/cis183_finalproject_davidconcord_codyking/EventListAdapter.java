package com.example.cis183_finalproject_davidconcord_codyking;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
public class EventListAdapter extends BaseAdapter
{
    Context context;
    ArrayList<Event> listOfEvents;

    public EventListAdapter(Context c, ArrayList<Event> ls)
    {
        context = c;
        listOfEvents = ls;
    }

    @Override
    public int getCount()
    {
        return listOfEvents.size();
    }

    @Override
    public Object getItem(int i)
    {
        return listOfEvents.get(i);
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
            view = mInflater.inflate(R.layout.groupcell, null);
        }
        TextView tv_j_groupcell_groupname = view.findViewById(R.id.tv_v_groupcell_groupname);
        TextView tv_j_groupcell_groupowner = view.findViewById(R.id.tv_v_groupcell_groupowner);
        Event event = listOfEvents.get(i);
        tv_j_groupcell_groupname.setText(event.getEname());
        tv_j_groupcell_groupowner.setText(event.getEdate());
        tv_j_groupcell_groupowner.setText(event.getEtime());

        return view;
    }
}
