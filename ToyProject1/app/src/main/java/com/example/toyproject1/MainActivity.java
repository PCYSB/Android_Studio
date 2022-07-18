package com.example.toyproject1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Intent = new Intent(MainActivity.this, Button1Activity.class);
                startActivity(Intent);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                Intent Intent = new Intent(MainActivity.this, Button2Activity.class);
                startActivity(Intent);
            }

        });
        button3.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent Intent = new Intent(MainActivity.this, Button3Activity.class);
                startActivity(Intent);
            }
        });

        button4.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent Intent = new Intent(MainActivity.this, Button4Activity.class);
                startActivity(Intent);
            }
        });


    }


}