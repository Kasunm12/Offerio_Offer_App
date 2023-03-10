package com.hasthiya.offerapplication;

import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.hasthiya.offerapplication.api.ApiClient;
import com.hasthiya.offerapplication.dto.User.LoginRequestDTO;
import com.hasthiya.offerapplication.dto.User.LoginResponseDTO;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class SignInActivity extends AppCompatActivity {
    private TextView textView6;
    private ImageView BackArrowIV;
    private ConstraintLayout startBtn;
    EditText editTextTextPersonName;
    EditText passwordEd;
    SharedPreferences pref;
    SharedPreferences.Editor edt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        editTextTextPersonName = findViewById(R.id.editTextTextPersonName);
        passwordEd = findViewById(R.id.passwordEd);
        textView6=findViewById(R.id.textView6);

        pref = getApplicationContext().getSharedPreferences("USER_DETAILS", Activity.MODE_PRIVATE);
        edt = pref.edit();

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
        startBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               String ed_email = editTextTextPersonName.getText().toString();
               String ed_password = passwordEd.getText().toString().trim();

                if (!(ed_email.isEmpty())){
                    if (!(ed_password.isEmpty())){
                        login(ed_email,ed_password);
                    }else {
                        passwordEd.setError("Please enter password!");
                    }
                }else {
                    editTextTextPersonName.setError("Enter valid Email!");
                }
            }
        });
    }

    private void login(String email, String password){

        LoginRequestDTO loginRequestDTO = new LoginRequestDTO();
        loginRequestDTO.setEmail(email);
        loginRequestDTO.setPassword(password);

        Call<LoginResponseDTO> loginResponseDTOCall = ApiClient.getInstance().getApiService().LoginUser(loginRequestDTO);
        loginResponseDTOCall.enqueue(new Callback<LoginResponseDTO>() {
            @Override
            public void onResponse(Call<LoginResponseDTO> call, Response<LoginResponseDTO> response) {
                if (response.isSuccessful() && !(response.body().getToken() == null)){
                    String name = response.body().getMessage();
                    System.out.println("=========name========" + name);
                    System.out.println("=================== response is successful ================"+response);
                    edt.putString("user_id", response.body().getToken().getSub().getId());
                    edt.commit();
                    Toast.makeText(getApplicationContext(), "Login is Success", Toast.LENGTH_SHORT).show();
                    Intent intent=new Intent(SignInActivity.this,AccountActivity.class);
                    startActivity(intent);
                }else {
                    Toast.makeText(getApplicationContext(), "Login is Not Success", Toast.LENGTH_SHORT).show();
                    System.out.println("=================== response is unsuccessful ================"+response);
                }
            }
            @Override
            public void onFailure(Call<LoginResponseDTO> call, Throwable t) {
                System.out.println("===================response failed ====================="+ t);
            }
        });

    }
}