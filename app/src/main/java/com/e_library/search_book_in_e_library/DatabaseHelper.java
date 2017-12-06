package com.e_library.search_book_in_e_library;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.Context;

/**
 * Created by Doston on 12/6/2017.
 */

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "Bookstore.db";
    public static final String TABLE_NAME = "Book_table";
    public static final String COL_1 = "ID";
    public static final String COL_2 = "CATEGORY";
    public static final String COL_3 = "TITLE";
    public static final String COL_4 = "AUTHOR";
    public static final String COL_5 = "YEAR";
    public static final String COL_6 = "PAGES";
    public static final String COL_7 = "POPULARITY";
    public static final String COL_8 = "ID";
    public static final String COL_9 = "PRICE";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
        SQLiteDatabase db = this.getReadableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db){

        //db.execSQL("create table " + TABLE_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, NAME TEXT, SURNAME TEXT)");

        db.execSQL("create table " + TABLE_NAME + "( " + COL_1 + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COL_2 + " TEXT, " +  COL_3 + " TEXT, " + COL_4 + " TEXT, " + COL_5 + " INTEGER, " + COL_6 + " INTEGER, " + COL_7 + " INTEGER, " + COL_8 + " TEXT, " + COL_9 + " INTEGER)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){

        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
}
