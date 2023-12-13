package com.example.cis183_finalproject_davidconcord_codyking;
import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.ArrayList;
public class EventDatabaseHelper extends SQLiteOpenHelper
{
    private static final String DATABASE_NAME = "Events.db";
    private static final String TABLE_NAME = "Events";

    public EventDatabaseHelper(Context context)
    {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        db.execSQL("CREATE TABLE " + TABLE_NAME + " (ename TEXT PRIMARY KEY NOT NULL, etime TEXT, edate TEXT, egid TEXT);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1)
    {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME + ";");
        onCreate(db);
    }

    public boolean initializeDB()
    {
        if(numberOfRowsInTable() == 0)
        {
            SQLiteDatabase db = this.getWritableDatabase();

            db.close();

            return true;
        }
        else
        {
            return false;
        }
    }

    public int numberOfRowsInTable()
    {
        SQLiteDatabase db = this.getReadableDatabase();
        int numRows = (int)DatabaseUtils.queryNumEntries(db, TABLE_NAME);
        db.close();

        return numRows;
    }

    @SuppressLint("Range")
    public ArrayList<Event> getAllEvents()
    {
        ArrayList<Event> listEvents = new ArrayList<Event>();

        String selectQuery = " SELECT * FROM " + TABLE_NAME + ";";

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery(selectQuery, null);

        String n;
        String t;
        String d;
        String gi;

        if (cursor.moveToFirst())
        {
            do
            {
                n = cursor.getString(cursor.getColumnIndex("ename"));
                t = cursor.getString(cursor.getColumnIndex("etime")); // Corrected column name
                d = cursor.getString(cursor.getColumnIndex("edate")); // Corrected column name
                gi = cursor.getString(cursor.getColumnIndex("egid")); // Corrected column name

                listEvents.add(new Event(n, t, d, gi));
            }
            while (cursor.moveToNext());
        }

        cursor.close();
        db.close();

        return listEvents;
    }


    public void addNewEvent(Event e)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("INSERT INTO " + TABLE_NAME + " VALUES ('" + e.getEname() + "','" + e.getEtime() + "','" + e.getEdate() + "','" + e.getEgid() + "');");
        db.close();
    }

    public void deleteEvent(String ename)
    {
        SQLiteDatabase db = this.getWritableDatabase();

        db.execSQL("DELETE FROM " + TABLE_NAME + " WHERE ename = '" + ename + "';");
        db.close();
    }

    public void updateEvent(Event e)
    {
        SQLiteDatabase db = this.getWritableDatabase();

        String updateCommand = "UPDATE " + TABLE_NAME + " SET ename = '" + e.getEname() + "' , etime = '" + e.getEtime() + "' , edate = '" + e.getEdate() + "' , egid = '" + e.getEgid() + "' WHERE ename = '" + e.getEname() + "';";
        db.execSQL(updateCommand);
        db.close();
    }

    @SuppressLint("Range")
    public ArrayList<Event> getAllEventsByGroup(String gname)
    {
        ArrayList<Event> listEventsByGroup = new ArrayList<Event>();

        String selectQuery = (" SELECT * FROM " + TABLE_NAME + " WHERE egid = '" + gname + "';");

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery(selectQuery, null);

        String n;
        String t;
        String d;
        String gi;

        if (cursor.moveToFirst())
        {
            do
            {
                n = cursor.getString(cursor.getColumnIndex("ename"));
                t = cursor.getString(cursor.getColumnIndex("etime")); // Corrected column name
                d = cursor.getString(cursor.getColumnIndex("edate")); // Corrected column name
                gi = cursor.getString(cursor.getColumnIndex("egid")); // Corrected column name

                listEventsByGroup.add(new Event(n, t, d, gi));
            }
            while (cursor.moveToNext());
        }

        cursor.close();
        db.close();

        return listEventsByGroup;
    }

    @SuppressLint("Range")
    public ArrayList<Event> getAllEventsByDate(String edate)
    {
        ArrayList<Event> listEventsByDate = new ArrayList<Event>();

        String selectQuery = (" SELECT * FROM " + TABLE_NAME + " WHERE edate = '" + edate + "';");

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery(selectQuery, null);

        String n;
        String t;
        String d;
        String gi;

        if (cursor.moveToFirst())
        {
            do
            {
                n = cursor.getString(cursor.getColumnIndex("ename"));
                t = cursor.getString(cursor.getColumnIndex("etime")); // Corrected column name
                d = cursor.getString(cursor.getColumnIndex("edate")); // Corrected column name
                gi = cursor.getString(cursor.getColumnIndex("egid")); // Corrected column name

                listEventsByDate.add(new Event(n, t, d, gi));
            }
            while (cursor.moveToNext());
        }

        cursor.close();
        db.close();

        return listEventsByDate;
    }
    @SuppressLint("Range")
    public ArrayList<Event> getAllEventsByAsc()
    {
        ArrayList<Event> listEventsByDate = new ArrayList<Event>();

        String selectQuery = " SELECT * FROM " + TABLE_NAME + " ORDER BY edate ASC " ;

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery(selectQuery, null);

        String n;
        String t;
        String d;
        String gi;

        if (cursor.moveToFirst())
        {
            do
            {
                n = cursor.getString(cursor.getColumnIndex("ename"));
                t = cursor.getString(cursor.getColumnIndex("etime")); // Corrected column name
                d = cursor.getString(cursor.getColumnIndex("edate")); // Corrected column name
                gi = cursor.getString(cursor.getColumnIndex("egid")); // Corrected column name

                listEventsByDate.add(new Event(n, t, d, gi));
            }
            while (cursor.moveToNext());
        }

        cursor.close();
        db.close();

        return listEventsByDate;
    }

    @SuppressLint("Range")
    public ArrayList<Event> getAllEventsByDesc()
    {
        ArrayList<Event> listEventsByDate = new ArrayList<Event>();

        String selectQuery = " SELECT * FROM " + TABLE_NAME + " ORDER BY edate Desc " ;

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery(selectQuery, null);

        String n;
        String t;
        String d;
        String gi;

        if (cursor.moveToFirst())
        {
            do
            {
                n = cursor.getString(cursor.getColumnIndex("ename"));
                t = cursor.getString(cursor.getColumnIndex("etime")); // Corrected column name
                d = cursor.getString(cursor.getColumnIndex("edate")); // Corrected column name
                gi = cursor.getString(cursor.getColumnIndex("egid")); // Corrected column name

                listEventsByDate.add(new Event(n, t, d, gi));
            }
            while (cursor.moveToNext());
        }

        cursor.close();
        db.close();

        return listEventsByDate;
    }

}
