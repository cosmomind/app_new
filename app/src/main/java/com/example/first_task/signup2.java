package com.example.first_task;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;


public class signup2 extends AppCompatActivity {

    Button button9;
    Button button3,button4;
    TextInputLayout t1,t2;
    private FirebaseAuth mAuth;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup21);

        mAuth = FirebaseAuth.getInstance();

        // t1 = findViewById(R.id.button3);
        // t2 = (TextInputLayout)findViewById(R.id.button4);





        button4 = (Button)findViewById(R.id.button4) ;
        button3 = (Button)findViewById(R.id.button3) ;
        button9 = (Button) findViewById(R.id.button9);

        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Register();

            }
        });


    }
    private  void  Register(){
        Bundle bundle = getIntent().getExtras();
        String t1 = bundle.getString("data2");
        String t2 = bundle.getString("data3");
        String emaill = t1;
        String passwordd = t2;

        //mAuth = FirebaseAuth.getInstance();
        mAuth.createUserWithEmailAndPassword(emaill, passwordd)
                .addOnCompleteListener(signup2.this, new OnCompleteListener<AuthResult>() {
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
                            Intent in = new Intent(signup2.this, activity_user.class);
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