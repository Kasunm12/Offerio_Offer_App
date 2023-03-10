package com.hasthiya.offerapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.hasthiya.offerapplication.api.ApiClient;
import com.hasthiya.offerapplication.dto.User.GetUserDTO;
import com.hasthiya.offerapplication.dto.User.GetUsersDTO;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AccountActivity extends AppCompatActivity {

    private ConstraintLayout logoutBtn,editBtn,cn_2;
    String user_id;

    TextView nameTV, accountEmailTV;
    ImageView imageView;

    SharedPreferences pref;
    SharedPreferences.Editor edt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);

        pref = getApplicationContext().getSharedPreferences("USER_DETAILS", Activity.MODE_PRIVATE);
        edt = pref.edit();

        user_id = pref.getString("user_id","");
        System.out.println("========================================================"+ user_id);

        logoutBtn=findViewById(R.id.logoutBtn);
        nameTV = findViewById(R.id.nameTV);
        accountEmailTV = findViewById(R.id.accountEmailTV);
        imageView = findViewById(R.id.imageView);

        getUserDetails(user_id);
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

    public void getUserDetails(String user_id){

        Call<GetUserDTO> getUserDTOCall = ApiClient.getInstance().getApiService().getUserDetails(user_id);
        getUserDTOCall.enqueue(new Callback<GetUserDTO>() {
            @Override
            public void onResponse(Call<GetUserDTO> call, Response<GetUserDTO> response) {
                if (response.isSuccessful()){

                    String name = response.body().getData().getName();
                    String email = response.body().getData().getEmail();
                    String  profile_pic = response.body().getData().getImage();
                    nameTV.setText(name);
                    accountEmailTV.setText(email);

                    if (profile_pic != null) {
                        Glide.with(getApplicationContext())
                                .load(profile_pic)
                                .into(imageView);
                    }
                    System.out.println("=================success getUserDetails=================="+name);
                    System.out.println("=================success getUserDetails=================="+response);
                }else {
                    System.out.println("=================unsuccess getUserDetails=================="+response);
                }
            }

            @Override
            public void onFailure(Call<GetUserDTO> call, Throwable t) {
                System.out.println("=================onFailure=================="+t);
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