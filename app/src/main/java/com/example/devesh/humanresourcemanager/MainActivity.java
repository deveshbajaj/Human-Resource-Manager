package com.example.devesh.humanresourcemanager;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Button;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;


public class MainActivity extends AppCompatActivity {

    Button but1,but2;
    EditText mail,pass;
    TextView tv1;
    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        firebaseAuth = FirebaseAuth.getInstance();

        but1 = (Button)findViewById(R.id.log);
        but2 = (Button)findViewById(R.id.sing);
        mail = (EditText)findViewById(R.id.mail);
        pass = (EditText)findViewById(R.id.pass);
        tv1  =  (TextView)findViewById(R.id.textView);

        but1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                String email= mail.getText().toString().trim();
                String pass_word= pass.getText().toString().trim();
                firebaseAuth.createUserWithEmailAndPassword(email,pass_word)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if(task.isComplete())
                                {
                                    Toast.makeText(MainActivity.this,"Register",Toast.LENGTH_SHORT).show();
                                    Intent in = new Intent(getApplicationContext(),choose.class);
                                    startActivity(in);
                                }
                                else
                                {
                                    Toast.makeText(MainActivity.this,"Fail ",Toast.LENGTH_SHORT).show();
                                }


                            }
                        });
            }
        });
        but2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Toast.makeText(MainActivity.this,"Singing up HR Resource Manager",Toast.LENGTH_SHORT).show();
                Intent in = new Intent(getApplicationContext(),signup.class);
                startActivity(in);



            }
        });

    }



}
