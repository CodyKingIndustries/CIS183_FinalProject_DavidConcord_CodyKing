package com.example.cis183_finalproject_davidconcord_codyking;
import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.ArrayList;

public class UserDatabaseHelper extends SQLiteOpenHelper
{
    private static final String DATABASE_NAME = "Users.db";
    private static final String TABLE_NAME = "Users";

    public UserDatabaseHelper(Context context)
    {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        db.execSQL("CREATE TABLE " + TABLE_NAME + " (username TEXT PRIMARY KEY NOT NULL, firstname TEXT, lastname TEXT, password TEXT, email TEXT, age TEXT);");
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
    public ArrayList<User> getAllRows()
    {
        ArrayList<User> listUsers = new ArrayList<User>();

        String selectQuery = " SELECT * FROM " + TABLE_NAME + ";";

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery(selectQuery, null);

        String f;
        String l;
        String u;
        String p;
        String e;
        String a;

        if (cursor.moveToFirst())
        {
            do
            {
                f = cursor.getString(cursor.getColumnIndex("firstname"));
                l = cursor.getString(cursor.getColumnIndex("lastname"));
                u = cursor.getString(cursor.getColumnIndex("username"));
                p = cursor.getString(cursor.getColumnIndex("password"));
                e = cursor.getString(cursor.getColumnIndex("email"));
                a = cursor.getString(cursor.getColumnIndex("age"));

                listUsers.add(new User(f, l, u, p, e, a));
            }
            while (cursor.moveToNext());
        }

        db.close();

        return listUsers;
    }

    public void addNewUser(User u)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("INSERT INTO " + TABLE_NAME + " VALUES ('" + u.getUsername() + "','" + u.getFname() + "','" + u.getLname() + "','" + u.getPassword() + "','" + u.getEmail() + "','" + u.getAge() + "');");
        db.close();
    }

    public void deleteUser(String username)
    {
        SQLiteDatabase db = this.getWritableDatabase();

        db.execSQL("DELETE FROM " + TABLE_NAME + " WHERE username = '" + username + "';");
        db.close();
    }

    public void updateUser(User u)
    {
        SQLiteDatabase db = this.getWritableDatabase();

        String updateCommand = "UPDATE " + TABLE_NAME + " SET firstname = '" + u.getFname() + "' , lastname = '" + u.getLname() + "' , password = '" + u.getPassword() + "' , email = '" + u.getEmail() + "' , age = '" + u.getAge() + "' WHERE username = '" + u.getUsername() + "';";
        db.execSQL(updateCommand);
        db.close();
    }
}
