package com.example.test3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.test3.data.MyDbHandler;
import com.example.test3.models.Book;

public class Welcomelib extends AppCompatActivity {
private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcomelib);

        MyDbHandler db2=new MyDbHandler(Welcomelib.this);



        button = (Button) findViewById(R.id.deletebookbu);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openlayout();
            }
        });
        button = (Button) findViewById(R.id.viewbook);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openlayout2();
            }
        });
        button = (Button) findViewById(R.id.deletebook);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openlayout3();
            }
        });

        button = (Button) findViewById(R.id.issuebook);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openlayout4();
            }
        });


        button = (Button) findViewById(R.id.viewissue);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openlayout5();
            }
        });

        button = (Button) findViewById(R.id.returnbook);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openlayout6();
            }
        });

        button = (Button) findViewById(R.id.checkfine2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openlayout7();
            }
        });

//default book
        Book book1=new Book();
        book1.setId("1");
        book1.setName("abc");
        book1.setAuthor("def");
        book1.setQuantity("4");
//       db2.addbook(book1);
        Log.d("riditgrrrr",book1.getName());
        db2.close();
    }



    public void openlayout(){
        Intent intent=new Intent(this, Addbook.class);
        startActivity(intent);
    }
    public void openlayout2(){
        Intent intent=new Intent(this, Viewbook.class);
        startActivity(intent);
    }
    public void openlayout3(){
        Intent intent=new Intent(this, Deletebook.class);
        startActivity(intent);
    }
    public void openlayout4(){
        Intent intent=new Intent(this, Issuebook.class);
        startActivity(intent);
    }
    public void openlayout5(){
        Intent intent=new Intent(this, Viewissuebook.class);
        startActivity(intent);
    }
    public void openlayout6(){
        Intent intent=new Intent(this, Returnbook.class);
        startActivity(intent);
    }
    public void openlayout7(){
        Intent intent=new Intent(this, Finesss.class);
        startActivity(intent);
    }
}