package com.example.lifecycle_activity;

import androidx.appcompat.app.AppCompatActivity;

import android.icu.util.BuddhistCalendar;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText userName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d("LifeCycle","OnCreate event called");
        userName = findViewById(R.id.editTextTextPersonName);

        if(savedInstanceState != null){
            String  name = savedInstanceState.getString("name");
            userName.setText(name);
        }
    }
    @Override
    protected void onStart(){
        super.onStart();
        Log.d ("LifeCycle", "onStart event called");
    }
    @Override
    protected void onResume(){
        super.onResume();
        Log.d ("LifeCycle", "onResume event called");
    }
    @Override
    protected void onStop(){
        super.onStop();
        Log.d("LifeCycle", "onStop event called");
    }
    @Override
    protected void onDestroy(){
        super.onDestroy();
        Log.d("LifeCycle","onDestroy event called");
    }

    @Override
    public void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);
        Log.d("LifeCycle", "OnCreate event called");

        outState.putString("name", userName.getText().toString());
    }
}