package com.thiomark.bookhub;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

    }

    //when the user signs in with correct credentials redirect them to the main page
    public void onSignIn(View v){
        EditText name = findViewById(R.id.username);
        EditText pass = findViewById(R.id.password);

       if(name.getText().toString().length() < 4 || name.getText().toString().indexOf("@") < 1){
            Toast.makeText(this, "Name should be longer than 4 characters, email must contain @", Toast.LENGTH_SHORT).show();
       }
       else if(pass.getText().toString().length() < 8){
           Toast.makeText(this, "Your password should be longer than 8", Toast.LENGTH_SHORT).show();
       }
       else{
            setContentView(R.layout.activity_main);
       }
    }

    //when the user wants to register, launch registration page
    public void onRegisterClick(View v){
        Intent i = new Intent(this, RegisterActivity.class);
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

    public void gotoSummary(View v){
        Intent i = new Intent(this, BookSummary.class);
        startActivity(i);
    }

    public void gotoBook(View v){
        setContentView(R.layout.activity_book_summary);
    }

//view a list of all added books
    public void viewAllBooks(View v){
        setContentView(R.layout.activity_all_books);
    }
}