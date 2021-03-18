package com.example.example2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity2 extends AppCompatActivity {

    Button buttonManager2;
    Intent myIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        buttonManager2 = findViewById(R.id.button2);
        buttonManager2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                myIntent = new Intent(MainActivity2.this, MainActivity.class);
                startActivity(myIntent);
            }
        });
    }
}
