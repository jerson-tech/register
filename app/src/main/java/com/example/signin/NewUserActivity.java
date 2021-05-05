package com.example.signin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class NewUserActivity extends AppCompatActivity {



    EditText username, mailId, password;
    Button signIn;
    TextView alreadyUser;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_user);




        username = findViewById(R.id.userName);
        mailId = findViewById(R.id.mailId2);
        password = findViewById(R.id.pass2);
        signIn = findViewById(R.id.signIn);
        alreadyUser = findViewById(R.id.alreadyUser);


        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                String newUserName = username.getText().toString();
                String newUserMailId = mailId.getText().toString();
                String newUserPass = mailId.getText().toString();


                SharedPreferences sharedPreferences = getSharedPreferences("MySH",MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("UserName",newUserName);
                editor.putString("MailID", newUserMailId);
                editor.putString("Password", newUserPass);
                editor.commit();

                Intent intent = new Intent(NewUserActivity.this, UserActivity.class);
                intent.putExtra("UserName", newUserName);
                finish();


            }
        });


        alreadyUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent2 =new Intent(NewUserActivity.this, MainActivity.class);
                startActivity(intent2);
                finish();


            }
        });


    }
}