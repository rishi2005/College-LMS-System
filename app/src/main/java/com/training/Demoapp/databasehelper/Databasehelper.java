package com.training.Demoapp.databasehelper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Databasehelper extends SQLiteOpenHelper {




private static final String DATABASE_NAME = "StudentProfile.db";
private static final int DATABASE_VERSION = 1;
private static final String TABLE_NAME ="students";
private static final String COLUMN_ID  ="id";
private static final String COLUMN_NAME ="names";
private static final String COLUMN_COURSE ="course";
private static final String COLUMN_EMAIL ="email";
private static final String COLUMN_PHONE ="phone";
private static final String CREATE_TABLE =
        "CREATE TABLE " + TABLE_NAME + "(" + COLUMN_ID + "INTEGER PRIMARY KEY AUTOINCREMENT," +
                COLUMN_NAME + "TEXT," +
                COLUMN_COURSE + "TEXT," +
                COLUMN_EMAIL + "TEXT," +
                COLUMN_PHONE + "TEXT)";


public Databasehelper(Context context) {
    super(context, DATABASE_NAME, null, DATABASE_VERSION);

}


    @Override
    public void onCreate(SQLiteDatabase db) { db.execSQL(CREATE_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
    onCreate(db);
    }




    public boolean insertStudent(String name, String course, String email, String phone){
    SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME, name);
        values.put(COLUMN_COURSE, course);
        values.put(COLUMN_EMAIL, email);
        values.put(COLUMN_PHONE, phone);

        long result = db.insert(TABLE_NAME, null, values);
        return result != -1;
    }


    public boolean updateStudent(int id, String name,String course,String email,String phone){
    SQLiteDatabase db = this.getWritableDatabase();
    ContentValues values = new ContentValues();
    values.put(COLUMN_NAME, name);
    values.put(COLUMN_COURSE, course);
    values.put(COLUMN_EMAIL, email);
    values.put(COLUMN_PHONE, phone);

    int rowsUpdated = db.update(TABLE_NAME, values, COLUMN_ID + "=?", new String[]{String.valueOf(id)});
    return rowsUpdated > 0;

    }


    public boolean deleteStudent(int id){

    SQLiteDatabase db = this.getWritableDatabase();
    int rowsDeleted = db.delete(TABLE_NAME, COLUMN_ID + "=?", new String[]{String.valueOf(id)});
    return rowsDeleted > 0;
    }



    public Cursor getStudent(){
    SQLiteDatabase db = this.getReadableDatabase();
    return db.rawQuery("SELECT * FROM " + TABLE_NAME, null);
    }


    public Cursor getStudentData(String students){
    SQLiteDatabase db = this.getReadableDatabase();
    Cursor cursor = db.rawQuery("SELECT * FROM students WHERE id=?", new String[]{students});
    return cursor;
    }
}
