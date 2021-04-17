package com.example.first_task;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class signup extends AppCompatActivity {

    Button button6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);


        TextView button3 =(TextView)findViewById(R.id.button3);
        Bundle bundle = getIntent().getExtras();
        String data = bundle.getString("data");
        button3.setText(data);

        TextView button4 = (TextView)findViewById(R.id.button4);
        Bundle bundle1 = getIntent().getExtras();
        String data1 = bundle1.getString("data1");
        button4.setText(data1);


        button6 = (Button) findViewById(R.id.button6);
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(signup.this, signup2.class);
                startActivity(in);

            }
        });




    }
}