package com.example.assignment3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageSwitcher;
import android.widget.ImageView;

public class GalleryActivity extends AppCompatActivity implements View.OnClickListener {
    private ImageButton imageButton01, imageButton02, imageButton03, imageButton04, imageButton05,
            imageButton06, imageButton07, imageButton08;
    private ImageView imageView01;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);

        // file name image deosai_land.jpg dudipatsar_lake.jpg rama_lake.jpg
        imageButton01 = (ImageButton) findViewById(R.id.imageButton01);
        imageButton01.setOnClickListener(this);

        imageButton02 = (ImageButton) findViewById(R.id.imageButton02);
        imageButton02.setOnClickListener(this);

        imageButton03 = (ImageButton) findViewById(R.id.imageButton03);
        imageButton03.setOnClickListener(this);

        imageButton04 = (ImageButton) findViewById(R.id.imageButton04);
        imageButton04.setOnClickListener(this);

        imageButton05 = (ImageButton) findViewById(R.id.imageButton05);
        imageButton05.setOnClickListener(this);

        imageButton06 = (ImageButton) findViewById(R.id.imageButton06);
        imageButton06.setOnClickListener(this);

        imageButton07 = (ImageButton) findViewById(R.id.imageButton07);
        imageButton07.setOnClickListener(this);

        imageButton08 = (ImageButton) findViewById(R.id.imageButton08);
        imageButton08.setOnClickListener(this);

        imageView01 = (ImageView) findViewById(R.id.imageView01);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();

        if (id == R.id.imageButton01) {
            imageView01.setImageResource(R.drawable.example_1);
        } else if (id == R.id.imageButton02) {
            imageView01.setImageResource(R.drawable.example_2);
        } else if (id == R.id.imageButton03) {
            imageView01.setImageResource(R.drawable.example_3);
        } else if (id == R.id.imageButton04) {
            imageView01.setImageResource(R.drawable.example_4);
        } else if (id == R.id.imageButton05) {
            imageView01.setImageResource(R.drawable.example_5);
        } else if (id == R.id.imageButton06) {
            imageView01.setImageResource(R.drawable.example_6);
        } else if (id == R.id.imageButton07) {
            imageView01.setImageResource(R.drawable.example_7);
        } else if (id == R.id.imageButton08) {
            imageView01.setImageResource(R.drawable.example_8);
        }
    }
}