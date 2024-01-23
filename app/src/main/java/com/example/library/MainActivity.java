package com.example.library;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText Bookid,Title,Author,Year;

    Button load,upload;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Bookid=findViewById(R.id.id1);
        Title=findViewById(R.id.title1);
        Author=findViewById(R.id.authour1);
        Year=findViewById(R.id.year1);
        load=findViewById(R.id.load1);
        upload=findViewById(R.id.update1);


        upload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String eBookid = Bookid.getText().toString();
                String etitle = Title.getText().toString();
                String eauthor = Author.getText().toString();
                String eyear = Year.getText().toString();

                ContentValues values = new ContentValues();
                values.put(MyContentProvider.Bookid, eBookid);
                values.put(MyContentProvider.Title, etitle);
                values.put(MyContentProvider.Author, eauthor);
                values.put(MyContentProvider.Year, eyear);

                getContentResolver().insert(MyContentProvider.CONTENT_URI, values);

                android.widget.Toast.makeText(getApplicationContext(), "New Record Inserted", Toast.LENGTH_LONG).show();
            }
        });

        load.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("Range")
            @Override
            public void onClick(View v) {

                TextView resultView= (TextView) findViewById(R.id.result);

                Cursor cursor = getContentResolver().query(MyContentProvider.CONTENT_URI,
                        null, null, null, null);

                if(cursor.moveToFirst()) {
                    StringBuilder strBuild=new StringBuilder();
                    while (!cursor.isAfterLast()) {
                        strBuild.append("\n").
                                append(cursor.getString(cursor.getColumnIndex(MyContentProvider.Bookid))).
                                append("  ").append(cursor.getString(cursor.getColumnIndex(MyContentProvider.Title))).
                                append("  ").append(cursor.getString(cursor.getColumnIndex(MyContentProvider.Author))).
                                append("  ").append(cursor.getString(cursor.getColumnIndex(MyContentProvider.Year)));
                        cursor.moveToNext();
                    }
                    resultView.setText(strBuild);
                }
                else {
                    resultView.setText("No Records Found");
                }
            }
        });
    }
}