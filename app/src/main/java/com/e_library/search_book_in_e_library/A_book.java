package com.e_library.search_book_in_e_library;

/**
 * Created by Doston on 12/6/2017.
 */

public class A_book {

    private String category;
    private String title;
    private String author;
    private int year;
    private int pages;
    private int bought;
    private int available;
    private int price;

    public A_book(String category, String title, String author, int year, int pages, int bought, int available, int price) {
        this.category = category;
        this.title = title;
        this.author = author;
        this.year = year;
        this.pages = pages;
        this.bought = bought;
        this.available = available;
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getYear() {
        return year;
    }

    public int getPages() {
        return pages;
    }

    public int getBought() {
        return bought;
    }

    public int getAvailable() {
        return available;
    }

    public int getPrice() {
        return price;
    }
}
