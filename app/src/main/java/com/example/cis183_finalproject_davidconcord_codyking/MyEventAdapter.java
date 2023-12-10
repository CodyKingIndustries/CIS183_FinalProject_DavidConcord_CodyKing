package com.example.cis183_finalproject_davidconcord_codyking;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class MyEventAdapter extends ArrayAdapter<MyEvent> {

    private Context context;
    private ArrayList<MyEvent> events;

    public MyEventAdapter(Context context, ArrayList<MyEvent> events) {
        super(context, 0, events);
        this.context = context;
        this.events = events;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;

        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.list_item_layout, parent, false);

            viewHolder = new ViewHolder();
            viewHolder.textViewUsername = convertView.findViewById(R.id.textViewUsername);
            viewHolder.textViewDate = convertView.findViewById(R.id.textViewDate);
            viewHolder.textViewTime = convertView.findViewById(R.id.textViewTime);
            viewHolder.textViewDescription = convertView.findViewById(R.id.textViewDescription);


            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        // Get the data item for this position
        MyEvent myEvent = getItem(position);

        // Update the views with the data from MyEvent
        if (myEvent != null) {
            viewHolder.textViewUsername.setText(myEvent.getUsername());
            viewHolder.textViewDate.setText("Date: " + myEvent.getDate());
            viewHolder.textViewTime.setText("Time: " + myEvent.getTime());
            viewHolder.textViewDescription.setText("Description: " + myEvent.getDescription());
        }

        return convertView;
    }


    private static class ViewHolder {
        TextView textViewUsername;
        TextView textViewDate;

        TextView textViewTime;
        TextView textViewDescription;
    }
}
