package com.example.test3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.test3.data.MyDbHandler;

public class Returnbook extends AppCompatActivity {
    private EditText id2;
    private Button button;
    MyDbHandler DB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_returnbook);


        DB = new MyDbHandler(Returnbook.this);
        id2=(EditText) findViewById(R.id.editTextTextPersonName7);
        button=(Button)findViewById(R.id.button8);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String bookid = id2.getText().toString();
                DB.deleteissueBookById(bookid);
                Toast.makeText(getApplicationContext(),"Book returned",Toast.LENGTH_SHORT).show();


            }
        });
    }
}