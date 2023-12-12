package com.example.cis183_finalproject_davidconcord_codyking;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import java.util.ArrayList;

public class EventCrud {

    private EventDatabaseHelper dbHelper;

    public EventCrud(Context context) {
        dbHelper = new EventDatabaseHelper(context);
    }

    public void addEvent(Event event) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("eventname", event.getEname());
        values.put("ename", event.getEname());
        values.put("etime", event.getEtime());
        values.put("edate", event.getEdate());
        //values.put("eauthor", event.getEauthor());
        values.put("egid", event.getEgid());
        db.insert("Events", null, values);
        db.close();
    }

    public ArrayList<Event> getAllEvents() {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        ArrayList<Event> eventList = new ArrayList<>();
        Cursor cursor = db.rawQuery("SELECT * FROM Events", null);

        if (cursor.moveToFirst()) {
            do {
                @SuppressLint("Range") String name = cursor.getString(cursor.getColumnIndex("eventname"));
                @SuppressLint("Range") String time = cursor.getString(cursor.getColumnIndex("etime"));
                @SuppressLint("Range") String date = cursor.getString(cursor.getColumnIndex("edate"));
                @SuppressLint("Range") String author = cursor.getString(cursor.getColumnIndex("eauther"));
                @SuppressLint("Range") String gid = cursor.getString(cursor.getColumnIndex("egid"));

                Event event = new Event(name, time, date, gid);
                eventList.add(event);
            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();
        return eventList;
    }

    public void updateEvent(Event event) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("ename", event.getEname());
        values.put("etime", event.getEtime());
        values.put("edate", event.getEdate());
        //values.put("eauthor", event.getEauthor());
        values.put("egid", event.getEgid());

        db.update("Events", values, "eventname=?", new String[]{event.getEname()});
        db.close();
    }

    public void deleteEvent(String eventName) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        db.delete("Events", "eventname=?", new String[]{eventName});
        db.close();
    }
}
