package com.example.test3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.test3.data.MyDbHandler;
import com.example.test3.models.Book;
import com.example.test3.models.Issue;

import java.util.ArrayList;
import java.util.List;

public class Viewissuebook extends AppCompatActivity {
    ListView listto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewissuebook);

        MyDbHandler db = new MyDbHandler(Viewissuebook.this);

        ArrayList<String> viewall=new ArrayList<>();
        listto=findViewById(R.id.letsdothis);
        List<Issue> allissue = db.getallissuebooks();
        for(Issue issue: allissue){

            viewall.add(issue.getBookid()+" | "+issue.getStudentid()+" | "+issue.getStudentidname()+" | "+issue.getStudentcontact());



        }
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, viewall);
        listto.setAdapter(arrayAdapter);


    }
}