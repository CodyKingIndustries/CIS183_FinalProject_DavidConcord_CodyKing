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
            view = mInflater.inflate(R.layout.eventcell, null);
        }
        TextView tv_j_eventcell_eventname = view.findViewById(R.id.tv_v_eventcell_eventname);
        TextView tv_j_eventcell_eventdate = view.findViewById(R.id.tv_v_eventcell_eventdate);
        TextView tv_j_eventcell_eventtime = view.findViewById(R.id.tv_v_eventcell_eventtime);
        Event event = listOfEvents.get(i);
        tv_j_eventcell_eventname.setText(event.getEname());
        tv_j_eventcell_eventdate.setText(event.getEdate());
        tv_j_eventcell_eventtime.setText(event.getEtime());

        return view;
    }
}
