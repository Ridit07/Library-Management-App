package com.example.test3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.test3.data.MyDbHandler;
import com.example.test3.models.Librarian;
import com.example.test3.params.Params;

public class MainActivity extends AppCompatActivity {
    private Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//buttons
        button = (Button) findViewById(R.id.button9);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openlayout();
            }
        });

        button = (Button) findViewById(R.id.button2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openlayout2();
            }
        });




        //databse objects
        MyDbHandler db=new MyDbHandler(MainActivity.this);

        //adding data
        Librarian lib1=new Librarian();
        lib1.setId("1");
        lib1.setName("priyansh");
        lib1.setPassword("priyansh1");
        lib1.setPhone_number("983292392");
        db.addlibrarian(lib1);

        Librarian lib2=new Librarian();
        lib2.setId("2");
        lib2.setName("vishav");
        lib2.setPassword("vishav2");
        lib2.setPhone_number("798542545");
//        db.addlibrarian(lib2);
        Log.d("ridit",lib1.getId()+lib1.getName().toString()+lib2.getName().toString());


    }

//button functions
    public void openlayout(){
        Intent intent=new Intent(this, LoginPage.class);
        startActivity(intent);
    }
    public void openlayout2(){
        Intent intent=new Intent(this, Managelib.class);
        startActivity(intent);

    }
}