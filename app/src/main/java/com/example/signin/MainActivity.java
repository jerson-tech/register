package com.example.signin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {



    EditText mailID, password;
    Button login;
    TextView NewUser;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        NewUser = findViewById(R.id.newUser);
        mailID = findViewById(R.id.mailId);
        password = findViewById(R.id.pass);
        login = findViewById(R.id.logIn);





        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                String curMailID = mailID.getText().toString();
                String curPassword = password.getText().toString();

                SharedPreferences sharedPreferences = getSharedPreferences("MySH", MODE_PRIVATE);

                String shName = sharedPreferences.getString("UserName","User");
                String shMaiId = sharedPreferences.getString("MailID","");
                String shPass = sharedPreferences.getString("Password","");


                if (curMailID.equals(shMaiId) || curPassword.equals(shPass)) {


                    Intent intent2 = new Intent(MainActivity.this, UserActivity.class);
                    intent2.putExtra("UserName", shName);
                    finish();

                }else{

                    Toast.makeText(MainActivity.this, "Check the MailId and Password !", Toast.LENGTH_SHORT).show();

                }

                }
        });



        NewUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                    Intent intent = new Intent(MainActivity.this, NewUserActivity.class);
                    startActivity(intent);




            }
        });



    }
}