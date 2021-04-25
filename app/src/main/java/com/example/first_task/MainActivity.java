package com.example.first_task;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


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
                if(!button.getText().toString().isEmpty() && !button1.getText().toString().isEmpty()) {

                    showToast();
                    Intent intent = new Intent(MainActivity.this,signup.class);
                    intent.putExtra("data",button.getText().toString());
                    intent.putExtra("data1",button1.getText().toString());

                    startActivity(intent);
                }else{

                    showToast1();
                    //Toast.makeText(MainActivity.this, "Field is empty",Toast.LENGTH_SHORT).show();
                }




           }
        });




    }

    @SuppressLint("SetTextI18n")
    public void showToast() {
        EditText button =(EditText)findViewById(R.id.button);
        EditText button1 =(EditText)findViewById(R.id.button1);
        LayoutInflater inflater= getLayoutInflater();
        View layout = inflater.inflate(R.layout.toast_layout, (ViewGroup) findViewById(R.id.toast_root));

        //if(!button.getText().toString().isEmpty() && !button1.getText().toString().isEmpty()){

            //button10.setOnClickListener(new View.OnClickListener() {
                //@Override

                //public void onClick(View v) {
                    //if(!button.getText().toString().isEmpty() && !button1.getText().toString().isEmpty()) {
                    // Toast.makeText(MainActivity.this, success,Toast.LENGTH_LONG).show() ;
                    //showToast();
            TextView toastText1 = layout.findViewById(R.id.toast_text1);
            toastText1.setText("Welcome");


        Toast toast = new Toast(getApplicationContext());
        toast.setGravity(Gravity.BOTTOM,0,0);
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.setView(layout);

        toast.show();

    }

    @SuppressLint("SetTextI18n")
    public void showToast1() {

        EditText button =(EditText)findViewById(R.id.button);
        EditText button1 =(EditText)findViewById(R.id.button1);
        LayoutInflater inflater= getLayoutInflater();
        View layout = inflater.inflate(R.layout.toast_layout, (ViewGroup) findViewById(R.id.toast_root));

        TextView toastText = layout.findViewById(R.id.toast_text);
        toastText.setText("Field is Empty");
        Toast toast = new Toast(getApplicationContext());
        toast.setGravity(Gravity.BOTTOM,0,0);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setView(layout);

        toast.show();


    }


}