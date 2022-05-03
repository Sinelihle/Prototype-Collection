package com.thiomark.bookhub;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class BookSummary extends AppCompatActivity {

    TextView bookTitle;
    TextView summary;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_summary);

        bookTitle = findViewById(R.id.textView11);
        summary = findViewById(R.id.textView14);

        String title = getIntent().getStringExtra("key1");
        String description = getIntent().getStringExtra("key2");

        bookTitle.setText(title);
        summary.setText(description);
    }
}