package com.example.cis183_finalproject_davidconcord_codyking;
import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.ArrayList;
public class GroupDatabaseHelper extends SQLiteOpenHelper
{
    private static final String DATABASE_NAME = "Groups.db";
    private static final String TABLE_NAME = "Groups";

    public GroupDatabaseHelper(Context context)
    {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        db.execSQL("CREATE TABLE " + TABLE_NAME + " (groupname TEXT PRIMARY KEY NOT NULL, gname TEXT, gowner TEXT, gid TEXT);");
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
    public ArrayList<Group> getAllRows()
    {
        ArrayList<Group> listGroups = new ArrayList<Group>();

        String selectQuery = " SELECT * FROM " + TABLE_NAME + ";";

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery(selectQuery, null);

        String n;
        String o;
        String i;

        if (cursor.moveToFirst())
        {
            do
            {
                n = cursor.getString(cursor.getColumnIndex("groupname"));
                o = cursor.getString(cursor.getColumnIndex("groupowner"));
                i = cursor.getString(cursor.getColumnIndex("groupid"));

                listGroups.add(new Group(n, o, i));
            }
            while (cursor.moveToNext());
        }

        db.close();

        return listGroups;
    }

    public void addNewGroup(Group g)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("INSERT INTO " + TABLE_NAME + " VALUES ('" + g.getGname() + "','" + g.getGowner() + "','" + g.getGid() + "');");
        db.close();
    }

    public void deleteGroup(String gid)
    {
        SQLiteDatabase db = this.getWritableDatabase();

        db.execSQL("DELETE FROM " + TABLE_NAME + " WHERE gid = '" + gid + "';");
        db.close();
    }

    public void updateGroup(Group g)
    {
        SQLiteDatabase db = this.getWritableDatabase();

        String updateCommand = "UPDATE " + TABLE_NAME + " SET gname = '" + g.getGname() + "' , gowner = '" + g.getGowner() + "' , gid = '" + g.getGid() + "' WHERE username = '" + g.getGid() + "';";
        db.execSQL(updateCommand);
        db.close();
    }
}
