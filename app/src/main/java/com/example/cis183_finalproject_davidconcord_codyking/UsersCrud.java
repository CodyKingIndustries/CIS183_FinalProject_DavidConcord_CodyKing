package com.example.cis183_finalproject_davidconcord_codyking;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import java.util.ArrayList;

public class UsersCrud {
    private UserDatabaseHelper dbHelper;

    public UsersCrud(Context context) {
        dbHelper = new UserDatabaseHelper(context);
    }

    public boolean initializeDB() {
        return dbHelper.initializeDB();
    }

    public int numberOfRowsInTable() {
        return dbHelper.numberOfRowsInTable();
    }

    public ArrayList<User> getAllUsers() {
        return dbHelper.getAllUsers();
    }

    public void addNewUser(User user) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("username", user.getUsername());
        values.put("firstname", user.getFname());
        values.put("lastname", user.getLname());
        values.put("password", user.getPassword());
        values.put("email", user.getEmail());
        values.put("age", user.getAge());

        db.insert("Users", null, values);
        db.close();
    }

    public void deleteUser(String username) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        db.delete("Users", "username=?", new String[]{username});
        db.close();
    }

    public void updateUser(User user) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("firstname", user.getFname());
        values.put("lastname", user.getLname());
        values.put("password", user.getPassword());
        values.put("email", user.getEmail());
        values.put("age", user.getAge());

        db.update("Users", values, "username=?", new String[]{user.getUsername()});
        db.close();
    }
}
