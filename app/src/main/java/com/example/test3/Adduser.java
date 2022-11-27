package com.example.test3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.test3.data.MyDbHandler;

public class Adduser extends AppCompatActivity {
 private EditText id1,password,name1,contact1;
 private Button button;
 MyDbHandler DB;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adduser);

        DB = new MyDbHandler(Adduser.this);

        id1=(EditText) findViewById(R.id.enterid);
        password=(EditText) findViewById(R.id.enterpass);
        name1=(EditText) findViewById(R.id.entername);
        contact1=(EditText) findViewById(R.id.entercontact);
        button=(Button)findViewById(R.id.button6);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user1 = id1.getText().toString();
                String pass = password.getText().toString();
                String contact = contact1.getText().toString();
                String name = name1.getText().toString();
           Boolean insert=     DB.insertdata(user1, pass, name, contact);
        if(insert==true){
            Toast.makeText(getApplicationContext(),"User added",Toast.LENGTH_SHORT).show();
            Log.d("ridit123","bkl");
        }
        else{
            Log.d("ridit123","bkl234");
        }

            }
        });

    }
    public void loginpage(){
        Intent intent=new Intent(this, LoginPage.class);
        startActivity(intent);
    }

}