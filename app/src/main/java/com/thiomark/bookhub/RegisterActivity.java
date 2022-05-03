package com.thiomark.bookhub;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
    }

    public void onSignUp(View v){
        EditText mail = findViewById(R.id.email);
        EditText uName = findViewById(R.id.name);
        EditText pass = findViewById(R.id.password);

        if(mail.getText().toString().indexOf("@") < 1 || uName.getText().toString().length() < 4 || pass.getText().toString().length() < 8){
            Toast.makeText(this, "Please re-enter your credentials correctly", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(this, "Success!!", Toast.LENGTH_SHORT).show();
            Intent i = new Intent(this, LoginActivity.class);
            startActivity(i);
        }
    }
}