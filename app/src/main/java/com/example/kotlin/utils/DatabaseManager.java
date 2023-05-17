package com.example.kotlin.utils;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.kotlin.data.PersionData;

import java.util.ArrayList;
import java.util.List;

//chatGPT生成的数据库管理工具类
public class DatabaseManager {

    private SQLiteDatabase database;

    public DatabaseManager(Context context) {
        DatabaseHelper helper = new DatabaseHelper(context);
        database = helper.getWritableDatabase();
    }

    public void addData(PersionData data) {
        ContentValues values = new ContentValues();
        values.put("name", data.getName());
        values.put("age", data.getAge());
        database.insert("data_table", null, values);
    }

    public void deleteData(int id) {
        String whereClause = "id=?";
        String[] whereArgs = {String.valueOf(id)};
        database.delete("data_table", whereClause, whereArgs);
    }

    public void updateData(PersionData data) {
        ContentValues values = new ContentValues();
        values.put("name", data.getName());
        values.put("age", data.getAge());
        String whereClause = "id=?";
        String[] whereArgs = {String.valueOf(data.getId())};
        database.update("data_table", values, whereClause, whereArgs);
    }

    public List<PersionData> queryData(String keyword) {
        List<PersionData> result = new ArrayList<>();
        String selection = "name like ?";
        String[] selectionArgs = {"%" + keyword + "%"};
        Cursor cursor = database.query("data_table", null, selection, selectionArgs, null, null, null);
        if (cursor != null) {
            while (cursor.moveToNext()) {
                @SuppressLint("Range") int id = cursor.getInt(cursor.getColumnIndex("id"));
                @SuppressLint("Range") String name = cursor.getString(cursor.getColumnIndex("name"));
                @SuppressLint("Range") int age = cursor.getInt(cursor.getColumnIndex("age"));
                PersionData data = new PersionData(id, name, age);
                result.add(data);
            }
            cursor.close();
        }
        return result;
    }

    private class DatabaseHelper extends SQLiteOpenHelper {

        private static final String DATABASE_NAME = "data.db";
        private static final int DATABASE_VERSION = 1;

        private static final String CREATE_TABLE = "CREATE TABLE data_table ("
                + "id INTEGER PRIMARY KEY AUTOINCREMENT,"
                + "name TEXT,"
                + "age INTEGER)";

        public DatabaseHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL(CREATE_TABLE);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLE IF EXISTS data_table");
            onCreate(db);
        }
    }
}
