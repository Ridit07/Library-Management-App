package com.example.test3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.test3.data.MyDbHandler;

public class LoginPage extends AppCompatActivity {
    private Button button;
    private EditText userName;
    private EditText password;
    MyDbHandler DB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);

        //button
        userName = (EditText) findViewById(R.id.editTextTextPersonName);
        password = (EditText) findViewById(R.id.editTextTextPersonName23);
        button = (Button) findViewById(R.id.button);
        DB=new MyDbHandler(this);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
String user=userName.getText().toString();
String pass=password.getText().toString();
Boolean checkusernamepass=DB.checkusernamepass(user,pass);
if(checkusernamepass==true){
 nextpage();
}
else {

}

            }
        });


    }
    public void nextpage(){
        Intent intent=new Intent(this, Welcomelib.class);
        startActivity(intent);
    }

}