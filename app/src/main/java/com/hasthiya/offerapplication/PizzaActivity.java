package com.hasthiya.offerapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.hasthiya.offerapplication.api.ApiClient;
import com.hasthiya.offerapplication.dto.Promotions.GetOnePromotion;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PizzaActivity extends AppCompatActivity {

    String offerId;
    ImageView offerImage, backArrow;
    TextView offerType, AvailableTV, price, description, availabletypestopicTV;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pizza);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        offerImage = findViewById(R.id.imageView2);
        offerType = findViewById(R.id.subTopicTV);
        AvailableTV = findViewById(R.id.AvailableTV);
        price = findViewById(R.id.priceTV);
        description = findViewById(R.id.textView);
        availabletypestopicTV = findViewById(R.id.availabletypestopicTV);
        backArrow = findViewById(R.id.back_arrow);

        backArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PizzaActivity.this, HomeActivity.class);
                startActivity(intent);
            }
        });


        offerId = getIntent().getStringExtra("offerId");
        getOnePromotion(offerId);

        System.out.println("==============================================="+ offerId);
    }

    private void getOnePromotion(String promo_id){

        Call<GetOnePromotion> getOnePromotionCall = ApiClient.getInstance().getApiService().getOnePromotion(promo_id);
        getOnePromotionCall.enqueue(new Callback<GetOnePromotion>() {
            @Override
            public void onResponse(Call<GetOnePromotion> call, Response<GetOnePromotion> response) {
                if (response.isSuccessful()){
                    System.out.println("=================success getOnePromotion=================="+response);
                    String offer_image = response.body().getData().get(0).getImage();
                    String offer_type = response.body().getData().get(0).getOffer();
                    String availability = response.body().getData().get(0).getAvailability();
                    String offer_price = response.body().getData().get(0).getPrice();
                    String offer_description = response.body().getData().get(0).getDescription();
                    String foods = response.body().getData().get(0).getType();

                    if (offer_image != null) {
                        Glide.with(getApplicationContext())
                                .load(offer_image)
                                .into(offerImage);
                    }
                    if(offer_type != null){
                        offerType.setText(offer_type);
                    }
                    if(availability != null){
                        AvailableTV.setText(availability);
                    }
                    if(offer_price != null){
                        price.setText(offer_price);
                    }
                    if(offer_description != null){
                        description.setText(offer_description);
                    }
                    if(foods != null){
                        availabletypestopicTV.setText(foods);
                        System.out.println(foods);
                    }
                }else {
                    System.out.println("=================unsuccess getOnePromotion=================="+response);
                }
            }

            @Override
            public void onFailure(Call<GetOnePromotion> call, Throwable t) {
                System.out.println("===============onFailure=============="+ t);
            }
        });
    }
}