package com.royal.mukhi.homework;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.Toast;


public  class MyActivity extends Activity {

    EditText Name;
    EditText Password;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        Name = (EditText) findViewById(R.id.editText);
        Password = (EditText) findViewById(R.id.editText2);

    }
    public void onClickSave(View v) {

        SharedPreferences sharedPreferences = getSharedPreferences("data", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("Name", Name.getText().toString());
        editor.putString("Password", Password.getText().toString());
        editor.commit();

        Toast.makeText(this, "Data was saved successfully", Toast.LENGTH_SHORT).show();
    }

    public void onClickEnter(View v){
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }

    }

