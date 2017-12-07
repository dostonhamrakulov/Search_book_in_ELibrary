package com.e_library.search_book_in_e_library;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class View_books extends AppCompatActivity {

    DatabaseHelper myDB;
    Cursor cursor;
    SQLiteDatabase sqLiteDatabase;
    ListView listView;
    ListDataAdapter listDataAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_books);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        listView = (ListView) findViewById(R.id.id_list_view_all);


        //myDB = new DatabaseHelper(getApplicationContext());
        //sqLiteDatabase = myDB.getReadableDatabase();

        myDB = new DatabaseHelper(getApplicationContext());
        sqLiteDatabase = myDB.getReadableDatabase();
        cursor = myDB.getInformation(sqLiteDatabase);

        //cursor = myDB.getInformation();

        listDataAdapter = new ListDataAdapter(getApplicationContext(), R.layout.list_view_books);
        listView.setAdapter(listDataAdapter);

        if(cursor.moveToFirst()){
            do{
                String category, title, author, year, pages, bought, available, price;
                category = cursor.getString(0);
                title = cursor.getString(1);
                author = cursor.getString(2);
                year = cursor.getString(3);
                pages = cursor.getString(4);
                bought = cursor.getString(5);
                available = cursor.getString(6);
                price = cursor.getString(7);

                DataProvider dataProvider = new DataProvider(category, title, author, year, pages, bought, available, price);
                listDataAdapter.add(dataProvider);

            } while (cursor.moveToNext());
        }

    }

}
