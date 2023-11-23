package com.example.cis183_finalproject_davidconcord_codyking;
import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.ArrayList;
public class GroupMemberDatabaseHelper extends SQLiteOpenHelper
{
    private static final String DATABASE_NAME = "Members.db";
    private static final String TABLE_NAME = "Members";

    public GroupMemberDatabaseHelper(Context context)
    {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        db.execSQL("CREATE TABLE " + TABLE_NAME + " (eventname TEXT PRIMARY KEY NOT NULL, username TEXT, gid TEXT);");
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
    public ArrayList<GroupMember> getAllRows()
    {
        ArrayList<GroupMember> listMembers = new ArrayList<GroupMember>();

        String selectQuery = " SELECT * FROM " + TABLE_NAME + ";";

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery(selectQuery, null);

        String u;
        String i;

        if (cursor.moveToFirst())
        {
            do
            {
                u = cursor.getString(cursor.getColumnIndex("username"));
                i = cursor.getString(cursor.getColumnIndex("gid"));

                listMembers.add(new GroupMember(u, i));
            }
            while (cursor.moveToNext());
        }

        db.close();

        return listMembers;
    }

    public void addNewMember(GroupMember m)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("INSERT INTO " + TABLE_NAME + " VALUES ('" + m.getUsername() + "','" + m.getGid() + "');");
        db.close();
    }

    public void deleteMember(String username)
    {
        SQLiteDatabase db = this.getWritableDatabase();

        db.execSQL("DELETE FROM " + TABLE_NAME + " WHERE username = '" + username + "';");
        db.close();
    }

    public void updateMember(GroupMember m)
    {
        SQLiteDatabase db = this.getWritableDatabase();

        String updateCommand = "UPDATE " + TABLE_NAME + " SET username = '" + m.getUsername() + "' , gid = '" + m.getGid() + "' WHERE username = '" + m.getUsername() + "';";
        db.execSQL(updateCommand);
        db.close();
    }
}
