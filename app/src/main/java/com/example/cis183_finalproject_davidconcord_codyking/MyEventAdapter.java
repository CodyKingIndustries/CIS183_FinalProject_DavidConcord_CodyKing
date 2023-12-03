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
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.list_item_my_event, parent, false);
        }

        MyEvent event = getItem(position);

        TextView tvDate = convertView.findViewById(R.id.tvDate);
        TextView tvTime = convertView.findViewById(R.id.tvTime);
        TextView tvDescription = convertView.findViewById(R.id.tvDescription);

        if (event != null) {
            tvDate.setText(event.getDate());
            tvTime.setText(event.getTime());
            tvDescription.setText(event.getDescription());
        }

        return convertView;
    }
}

