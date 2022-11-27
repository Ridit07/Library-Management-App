package com.example.test3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.test3.data.MyDbHandler;
import com.example.test3.models.Book;

import java.util.ArrayList;
import java.util.List;

public class Viewbook extends AppCompatActivity {
    ListView listto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewbook);



        MyDbHandler db = new MyDbHandler(Viewbook.this);



        ArrayList<String> viewall=new ArrayList<>();
        listto=findViewById(R.id.listto);
        List<Book>allbook = db.getallbooks();
        for(Book book: allbook){

            viewall.add(book.getId()+" | "+book.getName()+" | "+book.getAuthor()+" | "+book.getQuantity());



        }
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, viewall);
        listto.setAdapter(arrayAdapter);
    }
}