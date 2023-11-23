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
        db.execSQL("CREATE TABLE " + TABLE_NAME + " (eventname TEXT PRIMARY KEY NOT NULL, ename TEXT, etime TEXT, edate TEXT, eauther TEXT, egid TEXT);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1)
    {
        //In case I change the version number of the database
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME + ";");
        //Then make new table
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
    public ArrayList<Event> getAllRows()
    {
        ArrayList<Event> listEvents = new ArrayList<Event>();

        String selectQuery = " SELECT * FROM " + TABLE_NAME + ";";

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery(selectQuery, null);

        String n;
        String t;
        String d;
        String a;
        String i;

        if (cursor.moveToFirst())
        {
            do
            {
                n = cursor.getString(cursor.getColumnIndex("eventname"));
                t = cursor.getString(cursor.getColumnIndex("eventtime"));
                d = cursor.getString(cursor.getColumnIndex("eventdate"));
                a = cursor.getString(cursor.getColumnIndex("eventauthor"));
                i = cursor.getString(cursor.getColumnIndex("eventgid"));

                listEvents.add(new Event(n, t, d, a, i));
            }
            while (cursor.moveToNext());
        }

        db.close();

        return listEvents;
    }

    public void addNewEvent(Event e)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("INSERT INTO " + TABLE_NAME + " VALUES ('" + e.getEname() + "','" + e.getEtime() + "','" + e.getEdate() + "','" + e.getEauthor() + "','" + e.getEgid() + "');");
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

        String updateCommand = "UPDATE " + TABLE_NAME + " SET ename = '" + e.getEname() + "' , etime = '" + e.getEtime() + "' , edate = '" + e.getEdate() + "' , eauthor = '" + e.getEauthor() + "' , egid = '" + e.getEgid() + "' WHERE ename = '" + e.getEname() + "';";
        db.execSQL(updateCommand);
        db.close();
    }
}
