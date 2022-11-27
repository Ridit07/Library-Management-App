package com.example.test3;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.test3.data.MyDbHandler;
import com.example.test3.models.Librarian;

import java.util.ArrayList;
import java.util.List;

public class Viewuser extends AppCompatActivity {
ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewuser);
        MyDbHandler db = new MyDbHandler(Viewuser.this);



        ArrayList<String> viewall=new ArrayList<>();
        listView = findViewById(R.id.listView);
        List<Librarian> alllibrarain = db.getAllContacts();
        for(Librarian librarian: alllibrarain){

            viewall.add(librarian.getId()+" | "+librarian.getName()+" | "+librarian.getPhone_number());



        }
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, viewall);
        listView.setAdapter(arrayAdapter);

    }
}