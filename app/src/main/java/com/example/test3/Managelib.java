package com.example.test3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Managelib extends AppCompatActivity {
private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_managelib);
        button = (Button) findViewById(R.id.button3);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openlayout();
            }
        });

        button = (Button) findViewById(R.id.button4);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openlayout2();
            }
        });

        button = (Button) findViewById(R.id.button5);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openlayout3();
            }
        });


    }
    public void openlayout(){
        Intent intent=new Intent(this, Adduser.class);
        startActivity(intent);
    }
    public void openlayout2(){
        Intent intent=new Intent(this, Viewuser.class);
        startActivity(intent);

    }
    public void openlayout3(){
        Intent intent=new Intent(this, Deletelib.class);
        startActivity(intent);

    }
}