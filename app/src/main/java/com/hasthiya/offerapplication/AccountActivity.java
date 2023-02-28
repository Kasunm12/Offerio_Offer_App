package com.hasthiya.offerapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

public class AccountActivity extends AppCompatActivity {

    private ConstraintLayout logoutBtn,editBtn,cn_2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);

        logoutBtn=findViewById(R.id.logoutBtn);
        logoutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(AccountActivity.this,IntroActivity.class));
            }
        });

        editBtn=findViewById(R.id.editBtn);
        editBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(AccountActivity.this,EditAccountActivity.class));
            }
        });

        cn_2=findViewById(R.id.cn_2);
        cn_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(AccountActivity.this,HomeActivity.class));
            }
        });
    }

    public void gotoHome(MenuItem item) {
        Intent intent = new Intent(AccountActivity.this, HomeActivity.class);
        startActivity(intent);
    }

    public void gotoCategory(MenuItem item) {
        Intent intent = new Intent(AccountActivity.this, CategoryActivity.class);
        startActivity(intent);
    }

    public void gotoLocation(MenuItem item) {
        Intent intent = new Intent(AccountActivity.this, MapActivity.class);
        startActivity(intent);
    }

    public void gotoAccount(MenuItem item) {
        Intent intent = new Intent(AccountActivity.this, AccountActivity.class);
        startActivity(intent);
    }

}