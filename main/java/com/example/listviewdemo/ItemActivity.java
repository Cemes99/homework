package com.example.listviewdemo;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ItemActivity extends AppCompatActivity {
    TextView textView;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item);
        textView = findViewById(R.id.titleSubject);

        Intent intent = getIntent();
        textView.setText(intent.getStringExtra("Subject"));
    }
}
