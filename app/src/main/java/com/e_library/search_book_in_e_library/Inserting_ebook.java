package com.e_library.search_book_in_e_library;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.LinkedList;
import java.util.List;

public class Inserting_ebook extends AppCompatActivity {

    DatabaseHelper myDB;

    private EditText edit_category, edit_author, edit_title, edit_year, edit_price, edit_pages;
    private Button btn_insert;
    private String Category;
    private String Author;
    private String Title;
    private int Year;
    private int Pages;
    private int Price;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inserting_ebook);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        myDB = new DatabaseHelper(this);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        edit_category = (EditText) findViewById(R.id.id_insert_book_category);
        edit_author = (EditText) findViewById(R.id.id_insert_book_Author);
        edit_title = (EditText) findViewById(R.id.id_insert_book_title);
        edit_year = (EditText) findViewById(R.id.id_insert_book_year);
        edit_pages = (EditText) findViewById(R.id.id_insert_book_pages);
        edit_price = (EditText) findViewById(R.id.id_insert_book_price);

        btn_insert = (Button) findViewById(R.id.id_btn_insert);

        //A_book book = new A_book();
        List<A_book> list = new LinkedList<A_book>();

        A_book b1 = new A_book("Technology", "HTML development", "Doston Hamrakulov", 2017, 500, 25, 100, 15);
        A_book b2 = new A_book("Fiction", "My daily story", "John Adam", 2018, 100, 35, 50, 15);
        A_book b3 = new A_book("Economic", "Buniss issues", "James Chanies", 2017, 400, 5, 78, 20);

        list.add(b1);
        list.add(b2);
        list.add(b3);

        boolean defaultValues = false;
        for(A_book b : list){
            defaultValues = myDB.insertDefaultBook(b.getCategory(), b.getTitle(), b.getAuthor(), b.getYear(), b.getPages(), b.getBought(), b.getAvailable(), b.getPrice());
        }

        if (defaultValues = true){
            Toast.makeText(Inserting_ebook.this, "Default stored books are added!!!", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(Inserting_ebook.this, "Unfortunately NOT added!!!", Toast.LENGTH_LONG).show();
        }



    }
    public void AddBook(View view){
        btn_insert.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        Category = edit_category.getText().toString();
                        Author = edit_author.getText().toString();
                        Title = edit_title.getText().toString();
                        Year = Integer.parseInt(edit_year.getText().toString());
                        Pages = Integer.parseInt(edit_pages.getText().toString());
                        Price = Integer.parseInt(edit_price.getText().toString());

                        boolean isInserted = myDB.insertBook(Category, Title, Author, Year, Pages, Price);
                        if (isInserted = true){
                            Toast.makeText(Inserting_ebook.this, "New Book inserted!!!", Toast.LENGTH_LONG).show();
                        } else {
                            Toast.makeText(Inserting_ebook.this, "Oops not inserted!!!", Toast.LENGTH_LONG).show();
                        }
                    }
                }
        );
    }



}
