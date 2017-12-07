package com.e_library.search_book_in_e_library;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Doston on 12/7/2017.
 */

public class ListDataAdapter extends ArrayAdapter {

    List list = new ArrayList();
    public ListDataAdapter(@NonNull Context context, @LayoutRes int resource) {
        super(context, resource);
    }
    static class LayoutHandler{
        TextView CATEGORY, TITLE,AUTHOR, PAGES, YEAR, BOUGHT, AVAILABLE, PRICE;
    }

    @Override
    public void add(Object object){
        super.add(object);
        list.add(object);
    }

    @Override
    public int getCount(){
        return list.size();
    }
    @Override
    public Object getItem(int position){
        return list.get(position);
    }
    @Override
    public View getView(int position, View convertViewView, ViewGroup parent){

        View row = convertViewView;
        LayoutHandler layoutHandler;
        if (row == null){
            LayoutInflater layoutInflater = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = layoutInflater.inflate(R.layout.list_view_books, parent, false);
            layoutHandler = new LayoutHandler();
            layoutHandler.CATEGORY = (TextView) row.findViewById(R.id.id_txt_category);
            layoutHandler.TITLE = (TextView) row.findViewById(R.id.id_txt_title);
            layoutHandler.AUTHOR = (TextView) row.findViewById(R.id.id_txt_author);
            layoutHandler.PAGES = (TextView) row.findViewById(R.id.id_txt_pages);
            layoutHandler.YEAR = (TextView) row.findViewById(R.id.id_txt_year);
            layoutHandler.BOUGHT = (TextView) row.findViewById(R.id.id_txt_bought);
            layoutHandler.AVAILABLE = (TextView) row.findViewById(R.id.id_txt_available);
            layoutHandler.PRICE = (TextView) row.findViewById(R.id.id_txt_price);

            row.setTag(layoutHandler);

        } else {
            layoutHandler = (LayoutHandler) row.getTag();
        }

        DataProvider dataProvider = (DataProvider) this.getItem(position);
        layoutHandler.CATEGORY.setText(dataProvider.getCategory());
        layoutHandler.TITLE.setText(dataProvider.getTitle());
        layoutHandler.AUTHOR.setText(dataProvider.getAuthor());
        layoutHandler.YEAR.setText("" + dataProvider.getYear());
        layoutHandler.PAGES.setText("" + dataProvider.getPages());
        layoutHandler.BOUGHT.setText("" + dataProvider.getBought());
        layoutHandler.AVAILABLE.setText("" + dataProvider.getAvailable());
        layoutHandler.PRICE.setText("" + dataProvider.getPrice());

        return row;
    }

}
