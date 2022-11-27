package com.example.test3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.test3.data.MyDbHandler;
import com.example.test3.data.MyDbHandler;

public class Addbook extends AppCompatActivity {
    private EditText bookid,bookname,bookauthor,bookquantity;
    private Button button;
MyDbHandler DB2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addbook);

        DB2 = new MyDbHandler(Addbook.this);

        bookid=(EditText) findViewById(R.id.enterbookid);
        bookname=(EditText) findViewById(R.id.enterbookname);
        bookauthor=(EditText) findViewById(R.id.enterbookauther);
        bookquantity=(EditText) findViewById(R.id.enterbookquantity);
        button=(Button)findViewById(R.id.addbookbutton);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String id1 = bookid.getText().toString();
                String name12 = bookname.getText().toString();
                String auther1 = bookauthor.getText().toString();
                String quantity1 = bookquantity.getText().toString();
                Boolean insert=     DB2.insertBook(id1, name12, auther1, quantity1);
                if(insert==true){
                    Toast.makeText(getApplicationContext(),"Book added",Toast.LENGTH_SHORT).show();

                    Log.d("ridit123","bkl");
                }
                else{
                    Log.d("ridit123","bkl2333");
                }

            }
        });

    }
}