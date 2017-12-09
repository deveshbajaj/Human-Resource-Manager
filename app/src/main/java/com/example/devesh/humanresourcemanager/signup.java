package com.example.devesh.humanresourcemanager;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class signup extends AppCompatActivity {

    EditText ed1,ed2,ed3,ed4,ed5;
    DatabaseReference user_data;
    Button bt1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        ed1 = (EditText) findViewById(R.id.Name);
        ed2 = (EditText) findViewById(R.id.Password);
        ed3 = (EditText) findViewById(R.id.R_Password);
        ed4 = (EditText) findViewById(R.id.Aadar);
        ed5 = (EditText) findViewById(R.id.mail);
        bt1 = (Button) findViewById(R.id.singup);
        user_data = FirebaseDatabase.getInstance().getReference("Users");

        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = ed1.getText().toString().trim();
                String pass = ed2.getText().toString().trim();
                String R_pass = ed3.getText().toString().trim();
                String Addar = ed4.getText().toString().trim();
                String mail = ed5.getText().toString().trim();
                final mydata yo = new mydata(name,pass,R_pass,Addar,mail);

                if(pass.equals(R_pass))
                {

                    user_data .child(Addar).setValue(yo);
                    Toast.makeText(signup.this,"User Added and Loging In ",Toast.LENGTH_SHORT).show();
                    Intent in = new Intent(getApplicationContext(),choose.class);
                    startActivity(in);

                }
                else { Toast.makeText(signup.this,"Wrong Password  ",Toast.LENGTH_SHORT).show();}



            }
        });

    }
}
