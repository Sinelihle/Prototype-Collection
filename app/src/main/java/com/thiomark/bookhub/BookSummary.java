package com.thiomark.bookhub;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class BookSummary extends AppCompatActivity {

    TextView bookTitle;
    TextView summary;
    TextView currentPage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_summary);

        bookTitle = findViewById(R.id.textView11);
        summary = findViewById(R.id.textView14);
        currentPage = findViewById(R.id.textView15);

        String title = getIntent().getStringExtra("key1");
        String description = getIntent().getStringExtra("key2");
        String bookCurrent = getIntent().getStringExtra("key3");

        bookTitle.setText(title);
        summary.setText(description);
        currentPage.setText(bookCurrent);
    }

    public void viewAllBooks(View v){
        setContentView(R.layout.activity_all_books);
    }
}