package com.hasthiya.offerapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.TextView;

import com.hasthiya.offerapplication.adaptors.OfferAdaptor;
import com.hasthiya.offerapplication.api.ApiClient;
import com.hasthiya.offerapplication.api.ApiServices;
import com.hasthiya.offerapplication.dto.Promotions.GetAllPromotions;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeActivity extends AppCompatActivity {

    TextView editAccountTV;
    RecyclerView rv_contest_by_category;
    OfferAdaptor offerAdaptor;
    private ArrayList<GetAllPromotions.Data> getAllPromotionsList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        editAccountTV=findViewById(R.id.editAccountTV);
        rv_contest_by_category = findViewById(R.id.rv_contest_by_category);

        getAllPromotions();
        editAccountTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this,CategoryActivity.class));
            }
        });
    }


    public void getAllPromotions(){
        try {

            Call<GetAllPromotions> getAllPromotionsCall = ApiClient.getInstance().getApiService().getAllPromotions();
            getAllPromotionsCall.enqueue(new Callback<GetAllPromotions>() {
                @Override
                public void onResponse(Call<GetAllPromotions> call, Response<GetAllPromotions> response) {

                    if (response.isSuccessful()){

                        getAllPromotionsList = response.body().getData();
                        LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL,false);
                        rv_contest_by_category.setLayoutManager(layoutManager);
                        offerAdaptor = new OfferAdaptor(getApplicationContext(),getAllPromotionsList, HomeActivity.this::onItemClickOffer);
                        rv_contest_by_category.setAdapter(offerAdaptor);
                        System.out.println("=================success=================="+response);
                    }else {
                        System.out.println("=================unsuccess=================="+response);
                    }
                }

                @Override
                public void onFailure(Call<GetAllPromotions> call, Throwable t) {
                    System.out.println("=================onFailure=================="+t);
                }
            });

        }catch (Exception e){

        }
    }

    private void onItemClickOffer(int position) {

        Intent intent = new Intent(HomeActivity.this, PizzaActivity.class);
        startActivity(intent);
    }

    public void gotoHome(MenuItem item) {
        Intent intent = new Intent(HomeActivity.this, HomeActivity.class);
        startActivity(intent);
    }

    public void gotoCategory(MenuItem item) {
        Intent intent = new Intent(HomeActivity.this, CategoryActivity.class);
        startActivity(intent);
    }

    public void gotoLocation(MenuItem item) {
        Intent intent = new Intent(HomeActivity.this, MapActivity.class);
        startActivity(intent);
    }

    public void gotoAccount(MenuItem item) {
        Intent intent = new Intent(HomeActivity.this, AccountActivity.class);
        startActivity(intent);
    }
}