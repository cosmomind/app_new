package com.example.first_task;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class MainActivity extends AppCompatActivity {

    Button button10;
    Button button2;
    Button button;
    Button button1;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAuth = FirebaseAuth.getInstance();
        EditText button = (EditText) findViewById(R.id.button);
        EditText button1 = (EditText) findViewById(R.id.button1);
        button10 = findViewById(R.id.button10);
        button2 = (Button) findViewById(R.id.button2);




       /* @Override
        public void onStart {
            super.onStart();

            FirebaseUser currentUser = mAuth.getCurrentUser();

        }*/


        button10.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                if (!button.getText().toString().isEmpty() && !button1.getText().toString().isEmpty()) {

                    showToast();



                    //FirebaseUser currentUser = mAuth.getCurrentUser();
                   // if(currentUser ==  null ){
                        //startActivity(new Intent(MainActivity.this,signup.class));
                        Intent intent = new Intent(MainActivity.this, signup.class);
                        Bundle bundle = new Bundle();
                        bundle.putString("data", button.getText().toString());
                        bundle.putString("data1", button1.getText().toString());
                        // intent.putExtra("data",button.getText().toString());
                        // intent.putExtra("data1",button1.getText().toString());
                        intent.putExtras(bundle);
                        startActivity(intent);
                   // }


                    //Intent intent23 = new Intent(MainActivity.this,user_account.class);

                    //startActivity(intent23);


                } else {

                    showToast1();
                    //Toast.makeText(MainActivity.this, "Field is empty",Toast.LENGTH_SHORT).show();
                }


            }
        });


        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Login();

            }
        });


    }

    @SuppressLint("SetTextI18n")
    public void showToast() {
        EditText button1 = (EditText) findViewById(R.id.button1);
        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate(R.layout.toast_layout, (ViewGroup) findViewById(R.id.toast_root));


        TextView toastText1 = layout.findViewById(R.id.toast_text1);
        toastText1.setText("Welcome");


        Toast toast = new Toast(getApplicationContext());
        //toast.setGravity(Gravity.BOTTOM,0,0);
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.setView(layout);

        toast.show();

    }

    @SuppressLint("SetTextI18n")
    public void showToast1() {

        EditText button = (EditText) findViewById(R.id.button);
        EditText button1 = (EditText) findViewById(R.id.button1);
        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate(R.layout.toast_layout, (ViewGroup) findViewById(R.id.toast_root));

        TextView toastText = layout.findViewById(R.id.toast_text);
        toastText.setText("Field is Empty");
        Toast toast = new Toast(getApplicationContext());
        toast.setGravity(Gravity.BOTTOM, 0, 0);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setView(layout);

        toast.show();


    }
    private void Login(){
        button = (Button)findViewById(R.id.button);
        button1= (Button)findViewById(R.id.button1);
        String emaill = button.getText().toString();
        String passwordd = button1.getText().toString();

        //mAuth = FirebaseAuth.getInstance();
        mAuth.signInWithEmailAndPassword(emaill, passwordd)
                .addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            //Intent in = new Intent(signup2.this, activity_user.class);
                            //in.putExtra("data",button.getText().toString());
                            //Bundle bundle= new Bundle();
                            //bundle.putString("data",button3.getText().toString());
                            //in.putExtras(bundle);
                            // startActivity(in);

                            Toast.makeText(getApplicationContext(),"Signed Up",Toast.LENGTH_LONG).show();
                            Intent in = new Intent(MainActivity.this, activity_user.class);
                            //in.putExtra("data",button.getText().toString());
                            // Bundle bundle= new Bundle();
                            // bundle.putString("data",button3.getText().toString());
                            // in.putExtras(bundle);
                            startActivity(in);
                            finish();



                        } else {

                            //Toast.makeText(signup2.this, "Failed Registration: "+e.getMessage(), Toast.LENGTH_SHORT).show();
                            Toast.makeText(getApplicationContext(),"Process Error ",Toast.LENGTH_LONG).show();
                            // Intent in = new Intent(signup2.this, activity_user.class);
                            //in.putExtra("data",button.getText().toString());
                            //Bundle bundle= new Bundle();
                            //bundle.putString("data",button3.getText().toString());
                            //in.putExtras(bundle);
                            //startActivity(in);
                        }
                    }
                });

    }






    }



