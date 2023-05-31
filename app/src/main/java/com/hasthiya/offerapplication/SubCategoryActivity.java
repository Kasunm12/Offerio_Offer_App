package com.hasthiya.offerapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.GridLayout;
import android.widget.Toast;

import com.hasthiya.offerapplication.adaptors.ShopAdaptor;
import com.hasthiya.offerapplication.api.ApiClient;
import com.hasthiya.offerapplication.dto.Shop.GetAllShopsByCategoryNameDTO;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SubCategoryActivity extends AppCompatActivity {

    String categoryName;
    String capitalizeCategoryName;
    ArrayList<GetAllShopsByCategoryNameDTO.Data> shopsList;
    RecyclerView rv_shops;
    ShopAdaptor shopAdaptor;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_included_offers);

        rv_shops =  findViewById(R.id.rv_shop_details);

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
                        shopsList = response.body().getData();
                        if (!response.body().getData().isEmpty()){
                            GridLayoutManager layoutManager = new GridLayoutManager(getApplicationContext(),2);
                            rv_shops.setLayoutManager(layoutManager);
                            shopAdaptor = new ShopAdaptor(getApplicationContext(), shopsList, SubCategoryActivity.this::onItemClickShop);
                            rv_shops.setAdapter(shopAdaptor);

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

    private void onItemClickShop(int position) {

        Intent intent = new Intent(SubCategoryActivity.this, IncludedOffersActivity.class);
        startActivity(intent);
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