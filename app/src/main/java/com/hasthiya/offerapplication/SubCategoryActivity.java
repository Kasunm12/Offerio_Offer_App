package com.hasthiya.offerapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.hasthiya.offerapplication.api.ApiClient;
import com.hasthiya.offerapplication.dto.Shop.GetAllShopsByCategoryNameDTO;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SubCategoryActivity extends AppCompatActivity {

    String categoryName;
    String capitalizeCategoryName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_included_offers);

        categoryName = getIntent().getStringExtra("category_name");
        System.out.println("*********************************************"+categoryName);
        capitalizeCategoryName = categoryName.toUpperCase().trim();
        System.out.println("*********************************************"+capitalizeCategoryName);


        getAllShopsByCategoryName(capitalizeCategoryName);
    }

    public void getAllShopsByCategoryName(String catName){

        try {
            Call<GetAllShopsByCategoryNameDTO> getAllShopsByCategoryNameDTOCall = ApiClient.getInstance().getApiService().getAllShopsByCategoryName(catName);
            getAllShopsByCategoryNameDTOCall.enqueue(new Callback<GetAllShopsByCategoryNameDTO>() {
                @Override
                public void onResponse(Call<GetAllShopsByCategoryNameDTO> call, Response<GetAllShopsByCategoryNameDTO> response) {
                    if (response.isSuccessful()){
                        System.out.println("=================getAllShopsByCategoryName success=================="+response);
                        if (!response.body().getData().isEmpty()){
                            System.out.println(response.body().getData().get(0).getCategory());
                        }else{
                            Toast.makeText(getApplicationContext(), "No Data", Toast.LENGTH_SHORT).show();
                        }

                    }else {
                        System.out.println("=================getAllShopsByCategoryName unsuccess=================="+response);
                    }
                }

                @Override
                public void onFailure(Call<GetAllShopsByCategoryNameDTO> call, Throwable t) {
                    System.out.println("=================getAllShopsByCategoryName failure=================="+t);
                }
            });

        }catch (Exception e){
            System.out.println(e);
        }
    }


    public void gotoHome(MenuItem item) {
        Intent intent = new Intent(SubCategoryActivity.this, HomeActivity.class);
        startActivity(intent);
    }

    public void gotoCategory(MenuItem item) {
        Intent intent = new Intent(SubCategoryActivity.this, CategoryActivity.class);
        startActivity(intent);
    }

    public void gotoLocation(MenuItem item) {
        Intent intent = new Intent(SubCategoryActivity.this, MapActivity.class);
        startActivity(intent);
    }

    public void gotoAccount(MenuItem item) {
        Intent intent = new Intent(SubCategoryActivity.this, AccountActivity.class);
        startActivity(intent);
    }
}