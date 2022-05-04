package com.thiomark.bookhub;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddBookActivity extends AppCompatActivity {

    private EditText bookTitle, bookDescription, currentPage;
    private Button btn;
    String title, description, currPage;

   public static final String EXTRA_TEXT = "com.thiomark.bookhub.EXTRA_TEXT";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_book);
        btn = findViewById(R.id.addBookBtn);
        bookTitle = findViewById(R.id.title_txt);
        bookDescription = findViewById(R.id.description_txt);
        currentPage = findViewById(R.id.current_page_txt);

        btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                title = bookTitle.getText().toString();
                description = bookDescription.getText().toString();
                currPage = currentPage.getText().toString();

                Intent intent = new Intent(AddBookActivity.this, BookSummary.class);
                intent.putExtra("key1", title);
                intent.putExtra("key2", description);
                intent.putExtra("key3", currPage);
                startActivity(intent);
            }
        });
    }


}