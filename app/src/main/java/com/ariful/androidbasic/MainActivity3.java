package com.ariful.androidbasic;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity3 extends AppCompatActivity {

    ListView myListView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        myListView = findViewById(R.id.listViewId);


        ArrayAdapter<CharSequence>myArrayAdapter = ArrayAdapter.createFromResource(this,R.array.countryName,android.R.layout.simple_list_item_1);
        myListView.setAdapter(myArrayAdapter);
    }
}