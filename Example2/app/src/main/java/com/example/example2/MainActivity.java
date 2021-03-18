package com.example.example2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button buttonManager;
    Button buttonManager2;
    TextView txtViewManager;
    ImageView imgViewManager;
    Intent myIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonManager = findViewById(R.id.button);
        buttonManager2 = findViewById(R.id.button3);
        txtViewManager = findViewById(R.id.textView2);
        imgViewManager = findViewById(R.id.imageView);

        final int[] counter = {0};
        buttonManager.setOnClickListener(v -> {
            counter[0]++;
            txtViewManager.setText("Clicked " + counter[0] + " times");
            if (imgViewManager.getVisibility() == View.VISIBLE) {
                imgViewManager.setVisibility(View.INVISIBLE);
            } else {
                imgViewManager.setVisibility(View.VISIBLE);
            }
        });
        buttonManager2.setOnClickListener(v -> {
            myIntent = new Intent(MainActivity.this, MainActivity2.class);
            startActivity(myIntent);
        });

    }
}