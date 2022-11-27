package com.example.test3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.test3.data.MyDbHandler;

public class Deletebook extends AppCompatActivity {
    private EditText id2;
    private Button button;
    MyDbHandler DB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deletebook);



        DB = new MyDbHandler(Deletebook.this);
        id2=(EditText) findViewById(R.id.deletebookb);
        button=(Button)findViewById(R.id.deletebookbu);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user1 = id2.getText().toString();
                DB.deleteBookById(user1);
                Toast.makeText(getApplicationContext(),"Book Deleted successfully",Toast.LENGTH_SHORT).show();


            }
        });

    }
}