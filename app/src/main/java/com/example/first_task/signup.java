package com.example.first_task;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class signup extends AppCompatActivity {

    Button button6;
    //private FirebaseAuth mAuth;
    //private DatabaseReference reference;
    //private DatabaseReference dbRef;

    /*@Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if (currentUser != null) {
            openMain();
        }
    }

    private void openMain() {
        startActivity(new Intent(this,MainActivity.class));
        finish();
    }*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

       // mAuth = FirebaseAuth.getInstance();
        //reference = FirebaseDatabase.getInstance().getReference();

        TextView button3 = (TextView) findViewById(R.id.button3);
        Bundle bundle = getIntent().getExtras();
        String data = bundle.getString("data");
        button3.setText(data);

        TextView button4 = (TextView) findViewById(R.id.button4);
        bundle = getIntent().getExtras();
        String data1 = bundle.getString("data1");
        button4.setText(data1);


        // EditText button =(EditText)findViewById(R.id.button);

        EditText button = (EditText) findViewById(R.id.button3);

        button6 = (Button) findViewById(R.id.button6);
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //createUser();
                Intent in = new Intent(signup.this, signup2.class);
                Bundle bundle = new Bundle();
                bundle.putString("data2", button3.getText().toString());

                bundle.putString("data3", button4.getText().toString());

                in.putExtras(bundle);
                startActivity(in);

            }

           /* private void createUser() {
                String email = button3.getText().toString();
                String password = button4.getText().toString();
                mAuth.signInWithEmailAndPassword(email, password)
                        .addOnCompleteListener( new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    uploadData();


                                } else {
                                    Toast.makeText(signup.this, "Error : "+task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                                }
                            }

                            

                        }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(signup.this, "Error : "+e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
            }

            private void uploadData() {
                dbRef =  reference.child("users");
                String key = dbRef.push().getKey();

                HashMap<String, String> user = new HashMap<>();
                user.put("key" ,key);
                user.put("email", button3.getText().toString());
                user.put("password",button4.getText().toString());

                dbRef.child(key).setValue(user)
                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {

                                if (task.isSuccessful()) {
                                    Toast.makeText(signup.this, "User created", Toast.LENGTH_SHORT).show();
                                    openMain();



                                } else {
                                    Toast.makeText(signup.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                                }
                            }



                        }) .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(signup.this,e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });*/
            // }
            //});

        });

    }





}

