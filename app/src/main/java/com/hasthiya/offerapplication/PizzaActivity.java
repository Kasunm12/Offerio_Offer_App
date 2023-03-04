package com.hasthiya.offerapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class PizzaActivity extends AppCompatActivity {

    String offerId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pizza);

        offerId = getIntent().getStringExtra("offerId");

        System.out.println("==============================================="+ offerId);
    }
}