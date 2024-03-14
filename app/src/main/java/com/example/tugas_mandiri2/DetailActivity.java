package com.example.tugas_mandiri2;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.tugas_mandiri2.R;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        ImageView imageView = findViewById(R.id.image_view);
        TextView textView = findViewById(R.id.text_view);

        Intent intent = getIntent();
        String category = intent.getStringExtra("category");
        int position = intent.getIntExtra("position", 0);

        String[] items;
        int[] images;

        if ("Laptop".equals(category)) {
            items = getResources().getStringArray(R.array.laptop_items);
            images = new int[]{R.drawable.asus, R.drawable.lenovo, R.drawable.acer, R.drawable.hpleptop, R.drawable.msi
            };
        } else if ("HP".equals(category)) {
            items = getResources().getStringArray(R.array.hp_items);
            images = new int[]{R.drawable.samsung, R.drawable.iphone, R.drawable.oppo, R.drawable.vivo, R.drawable.xiaomi};
        } else {
            items = getResources().getStringArray(R.array.tablet_items);
            images = new int[]{R.drawable.tabhuawei, R.drawable.tabsamsung, R.drawable.tabxiaomi, R.drawable.ipadair, R.drawable.ipadpro};
        }

        imageView.setImageResource(images[position]);
        textView.setText(items[position]);
    }
}
