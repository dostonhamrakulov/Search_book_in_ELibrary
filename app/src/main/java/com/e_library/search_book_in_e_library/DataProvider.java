package com.e_library.search_book_in_e_library;

/**
 * Created by Doston on 12/7/2017.
 */

public class DataProvider{

    private String category;
    private String title;
    private String author;
    private String year;
    private String pages;
    private String bought;
    private String available;
    private String price;

        public DataProvider(String category, String title, String author, String year, String pages, String bought, String available, String price) {
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

        public void setCategory(String category) {
            this.category = category;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public String getYear() {
            return year;
        }

        public void setYear(String year) {
            this.year = year;
        }

        public String getPages() {
            return pages;
        }

        public void setPages(String pages) {
            this.pages = pages;
        }

        public String getBought() {
            return bought;
        }

        public void setBought(String bought) {
            this.bought = bought;
        }

        public String getAvailable() {
            return available;
        }

        public void setAvailable(String available) {
            this.available = available;
        }

        public String getPrice() {
            return price;
        }

        public void setPrice(String price) {
            this.price = price;
        }
}
