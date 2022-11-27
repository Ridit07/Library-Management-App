package com.example.test3;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.test3.data.MyDbHandler;

public class Issuebook extends AppCompatActivity {
    private EditText bookid,studentname,studentid,contact;
    private Button button;
    MyDbHandler DB2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_issuebook);


        DB2 = new MyDbHandler(Issuebook.this);

        bookid=(EditText) findViewById(R.id.editTextTextPersonName3);
        studentname=(EditText) findViewById(R.id.editTextTextPersonName4);
        studentid=(EditText) findViewById(R.id.editTextTextPersonName5);
        contact=(EditText) findViewById(R.id.editTextTextPersonName6);
        button=(Button)findViewById(R.id.button7);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String id = bookid.getText().toString();
                String sname = studentname.getText().toString();
                String sid = studentid.getText().toString();
                String scontact = contact.getText().toString();
                Boolean check=DB2.checkbookid(id);
                if(check==true){
                    Boolean insert=     DB2.insertdata2(id, sname, sid, scontact);
                    if(insert==true){
                        Log.d("ridit123","maihukhan");
                        Toast.makeText(getApplicationContext(),"Book Issued",Toast.LENGTH_SHORT).show();

                    }
                    else{
                        Log.d("ridit123","najina");
                    }
                }
                else{
                    Log.d("ridit123","najinapart2");
                    Toast.makeText(getApplicationContext(),"Book Id Does not exist",Toast.LENGTH_SHORT).show();

                }

            }
        });
    }
}