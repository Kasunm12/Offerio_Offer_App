package com.hasthiya.offerapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.hasthiya.offerapplication.adaptors.CategoryAdaptor;
import com.hasthiya.offerapplication.adaptors.OfferAdaptor;
import com.hasthiya.offerapplication.api.ApiClient;
import com.hasthiya.offerapplication.dto.Shop.GetAllCategory;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CategoryActivity extends AppCompatActivity {

    private ArrayList<GetAllCategory.Data> AllCategory;
    RecyclerView rv_contest_by_category;
    CategoryAdaptor categoryAdaptor;

    ImageView backArrow;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        rv_contest_by_category = findViewById(R.id.rv_contest_by_category);
        backArrow = findViewById(R.id.back_arrow);

        backArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CategoryActivity.this, HomeActivity.class);
                startActivity(intent);
            }
        });

        getAllCategory();
    }

    public void getAllCategory(){
        try {
            Call<GetAllCategory> getAllCategoryCall = ApiClient.getInstance().getApiService().getAllCategory();
            getAllCategoryCall.enqueue(new Callback<GetAllCategory>() {
                @Override
                public void onResponse(Call<GetAllCategory> call, Response<GetAllCategory> response) {
                    if (response.isSuccessful()){
                        System.out.println("=================success getAllCategory=================="+response);
                        AllCategory = response.body().getData();
                        LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL,false);
                        rv_contest_by_category.setLayoutManager(layoutManager);
                        categoryAdaptor = new CategoryAdaptor(getApplicationContext(),AllCategory, CategoryActivity.this::onItemClickCategory);
                        rv_contest_by_category.setAdapter(categoryAdaptor);
                    }else {
                        System.out.println("=================unsuccess getAllCategory=================="+response);
                    }
                }

                @Override
                public void onFailure(Call<GetAllCategory> call, Throwable t) {
                    System.out.println("=================onFailure getAllCategory=================="+t);
                }
            });
        }catch (Exception e){
            System.out.println("=================Exception=================="+e);
        }

    }

    private void onItemClickCategory(int position) {

        Intent intent = new Intent(CategoryActivity.this, AccountActivity.class);
        startActivity(intent);
    }

    public void gotoHome(MenuItem item) {
        Intent intent = new Intent(CategoryActivity.this, HomeActivity.class);
        startActivity(intent);
    }

    public void gotoCategory(MenuItem item) {
        Intent intent = new Intent(CategoryActivity.this, CategoryActivity.class);
        startActivity(intent);
    }

    public void gotoLocation(MenuItem item) {
        Intent intent = new Intent(CategoryActivity.this, MapActivity.class);
        startActivity(intent);
    }

    public void gotoAccount(MenuItem item) {
        Intent intent = new Intent(CategoryActivity.this, AccountActivity.class);
        startActivity(intent);
    }
}