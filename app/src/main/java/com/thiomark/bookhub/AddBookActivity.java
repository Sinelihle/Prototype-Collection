package com.thiomark.bookhub;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.ContentValues;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class AddBookActivity extends AppCompatActivity {

    private static final int  PERMISSION_CODE = 1000;
    private static final int  IMAGE_CAPTURE_CODE = 1001;
    private EditText bookTitle, bookDescription, currentPage;
    private Button btn;
    String title, description, currPage;
    ImageButton image;

    Uri img_uri;

   public static final String EXTRA_TEXT = "com.thiomark.bookhub.EXTRA_TEXT";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_book);
        btn = findViewById(R.id.addBookBtn);
        bookTitle = findViewById(R.id.title_txt);
        bookDescription = findViewById(R.id.description_txt);
        currentPage = findViewById(R.id.current_page_txt);
        image = findViewById(R.id.add_image_btn);

        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
                    if(checkSelfPermission(Manifest.permission.CAMERA) ==
                            PackageManager.PERMISSION_DENIED ||
                            checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE)==
                                PackageManager.PERMISSION_DENIED){
                        //permission denied
                        String[] permission = {Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE};

                        //show request message
                        requestPermissions(permission, PERMISSION_CODE);
                    }
                    else{
                        //if permission granted already
                        openCamera();
                    }
                }
                else{
                    //os is less than required
                    openCamera();

                }
            }
        });
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

    private void openCamera() {
        ContentValues values = new ContentValues();
        values.put(MediaStore.Images.Media.TITLE, "NEW PICTURE");
        values.put(MediaStore.Images.Media.DESCRIPTION, "FROM CAMERA");
        img_uri = getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, values);

        //camera intent
        Intent camIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        camIntent.putExtra(MediaStore.EXTRA_OUTPUT, img_uri);
        startActivityForResult(camIntent, IMAGE_CAPTURE_CODE);

    }
//persion result
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch(requestCode){
            case PERMISSION_CODE:{
                if(grantResults.length > 0 && grantResults[0] ==
                            PackageManager.PERMISSION_GRANTED){
                    openCamera();
                }
                else{
                    Toast.makeText(this, "Permission Denied", Toast.LENGTH_SHORT).show();
                }
            }
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            //image captured to image button
            image.setImageURI(img_uri);
        }
    }
}