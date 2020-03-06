package com.example.listviewdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener,
//        ListView.OnItemClickListener,
        AdapterView.OnItemLongClickListener {

    private ListView listView;
    private ArrayList<String> arrayList = new ArrayList<>();
    private ArrayAdapter<String> arrayAdapter;

    private EditText subject;
    private Button importButton, updateButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        connectView();
        listenClick();
        initData();
    }

    private void connectView(){
        listView = findViewById(R.id.list);
        subject = findViewById(R.id.subject);
        importButton = findViewById(R.id.importButton);
        updateButton = findViewById(R.id.updateButton);
    }

    private void listenClick(){
        importButton.setOnClickListener(this);
        updateButton.setOnClickListener(this);
//        listView.setOnItemClickListener(this);
        listView.setOnItemLongClickListener(this);
    }

    private void initData(){
        arrayList.add("Lập trình Java");
        arrayList.add("Lập trình hướng đối tượng");
        arrayList.add("Lập trình trên thiết bị di động");
        arrayList.add("Lập trình IOS");
        arrayList.add("Lập trình Java");
        arrayList.add("Lập trình hướng đối tượng");
        arrayList.add("Lập trình trên thiết bị di động");
        arrayList.add("Lập trình IOS");
        arrayList.add("Lập trình Java");
        arrayList.add("Lập trình hướng đối tượng");
        arrayList.add("Lập trình trên thiết bị di động");
        arrayList.add("Lập trình IOS");
        arrayList.add("Lập trình Java");
        arrayList.add("Lập trình hướng đối tượng");
        arrayList.add("Lập trình trên thiết bị di động");
        arrayList.add("Lập trình IOS");

        arrayAdapter = new ArrayAdapter<>(MainActivity.this,
                R.layout.support_simple_spinner_dropdown_item, arrayList);
        listView.setAdapter(arrayAdapter);
        arrayAdapter.notifyDataSetChanged();
    }

    @Override
    public void onClick(View v) {
        if(v == importButton){
            if(subject.getText().toString().compareTo("") != 0)
                arrayList.add(0, subject.getText().toString());

            arrayAdapter.notifyDataSetChanged();
        }

        if(v == updateButton){
            Toast.makeText(MainActivity.this, "Chọn môn học cần cập nhật",
                    Toast.LENGTH_LONG).show();

            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    arrayList.set(position, subject.getText().toString());
                    arrayAdapter.notifyDataSetChanged();
                }
            });
        }
    }

//    @Override
//    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//
//    }

    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = new Intent(MainActivity.this, ItemActivity.class);

        intent.putExtra("Subject", arrayList.get(position));

        startActivity(intent);
        return false;
    }
}
