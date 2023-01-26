package com.hasthiya.offerapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class SignInActivity extends AppCompatActivity {
    private TextView textView6,password,email;
    private ImageView BackArrowIV;
    private ConstraintLayout startBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);


        email=findViewById(R.id.editTextTextPersonName);
        password=findViewById(R.id.passwordEd);

        textView6=findViewById(R.id.textView6);
        textView6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SignInActivity.this,SignUpActivity.class));
            }
        });


        BackArrowIV=findViewById(R.id.BackArrowIV);
        BackArrowIV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SignInActivity.this,IntroActivity.class));
            }
        });

        startBtn=findViewById(R.id.startBtn);
        startBtn.setOnClickListener(view -> {
            if(email.getText().toString().equals("admin@gmail.com")&&password.getText().toString().equals("admin")){
                Toast.makeText(SignInActivity.this,"LOGIN SUCCESSFULLY",Toast.LENGTH_SHORT).show();
                Intent i=new Intent(SignInActivity.this,AccountActivity.class);
                startActivity(i);
            }
            else{
                Toast.makeText(SignInActivity.this,"Login Failed", Toast.LENGTH_SHORT).show();
            }
        });


    }
}