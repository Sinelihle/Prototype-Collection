package com.thiomark.bookhub;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    //when the user signs in with correct credentials redirect them to the main page
    public void onSignIn(View v){
        setContentView(R.layout.activity_main);
    }

    //when the user wants to register, launch registration page
    public void onRegisterClick(View v){
        Intent i = new Intent(this, RegisterActivity.class);
        startActivity(i);
    }

    //
    public void signUp(View v){
        Intent i = new Intent(this, LoginActivity.class);
        startActivity(i);
    }

    //when the user wants to login, launch login page
    public void onLoginClick(View v){
        Intent i = new Intent(this, LoginActivity.class);
        startActivity(i);
    }

    public void addBooks(View v){
        Intent i = new Intent(this, AddBookActivity.class);
        startActivity(i);
    }
}