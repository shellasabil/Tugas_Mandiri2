package com.example.tugas_mandiri2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class ListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        ListView listView = findViewById(R.id.list_view);

        Intent intent = getIntent();
        final String category = intent.getStringExtra("category");

        String[] items;
        if ("Laptop".equals(category)) {
            items = getResources().getStringArray(R.array.laptop_items);
        } else if ("HP".equals(category)) {
            items = getResources().getStringArray(R.array.hp_items);
        } else {
            items = getResources().getStringArray(R.array.tablet_items);
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, items);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent detailIntent = new Intent(ListActivity.this, DetailActivity.class);
                detailIntent.putExtra("category", category);
                detailIntent.putExtra("position", position);
                startActivity(detailIntent);
            }
        });
    }
}
