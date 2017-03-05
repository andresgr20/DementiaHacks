package com.example.andres.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.util.Log;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    public void signUp(View view){
        EditText myUser = (EditText) findViewById(R.id.userbox);
        EditText myPass = (EditText) findViewById(R.id.passbox);
        Log.i("Username",myUser.getText().toString());
        Log.i("Password",myPass.getText().toString());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
