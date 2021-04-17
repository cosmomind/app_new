package com.example.first_task;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    Button button10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText button =(EditText)findViewById(R.id.button);
        EditText button1 =(EditText)findViewById(R.id.button1);
        button10 = (Button) findViewById(R.id.button10);
        button10.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,signup.class);
                intent.putExtra("data",button.getText().toString());
                intent.putExtra("data1",button1.getText().toString());

                startActivity(intent);
            }
        });




    }


}