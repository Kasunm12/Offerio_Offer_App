package com.hasthiya.offerapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.hasthiya.offerapplication.api.ApiClient;
import com.hasthiya.offerapplication.dto.User.RegisterRequestDTO;
import com.hasthiya.offerapplication.dto.User.RegisterResponseDTO;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignUpActivity extends AppCompatActivity {
    private ImageView BackArrowIV;
     EditText name, email,phoneNumber,password;
     ConstraintLayout SignUp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        name = findViewById(R.id.editTextTextPersonName);
        email = findViewById(R.id.EmailEd);
        phoneNumber = findViewById(R.id.ed_phone);
        password = findViewById(R.id.passwordEd);

        SignUp = findViewById(R.id.signBtn);
        SignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveUser();
                Intent intent = new Intent(SignUpActivity.this, SignInActivity.class);
                startActivity(intent);
            }
        });

        BackArrowIV=findViewById(R.id.BackArrowIV);
        BackArrowIV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SignUpActivity.this,SignInActivity.class));
            }
        });
    }


    private void saveUser(){
        //get the edit text input text
        String userName = name.getText().toString().trim();
        String Email =  email.getText().toString().trim();
        String Phone =  phoneNumber.getText().toString().trim();
        String Password = password.getText().toString().trim();

        //check the validation
        //username validation
        if (userName.isEmpty()){
            name.requestFocus();
            name.setError("Please Enter your Name");
        }
        //email validation
        else if (Email.isEmpty()){
            email.requestFocus();
            email.setError("Please Enter your Email");
        }
        //email validation
        else if (!Patterns.EMAIL_ADDRESS.matcher(Email).matches()){
            email.requestFocus();
            email.setError("Please Enter valid Email");
        }
        //phone validation
        else if (Phone.isEmpty() && Phone.length() == 10) {
            phoneNumber.requestFocus();
            phoneNumber.setError("Please Enter valid Phone Number");
        }
        //password validation
        else if(Password.isEmpty()){
            password.requestFocus();
            password.setError("Please Enter your password");
        }else{
            //set the register request params
            RegisterRequestDTO registerRequestDTO = new RegisterRequestDTO();
            registerRequestDTO.setName(userName);
            registerRequestDTO.setEmail(Email);
            registerRequestDTO.setPhone(Phone);
            registerRequestDTO.setPassword(Password);

            Call<RegisterResponseDTO> registerResponseDTOCall = ApiClient.getInstance().getApiService().registerUser(registerRequestDTO);
            registerResponseDTOCall.enqueue(new Callback<RegisterResponseDTO>() {
                @Override
                public void onResponse(Call<RegisterResponseDTO> call, Response<RegisterResponseDTO> response) {
                    if (response.isSuccessful()){
                        String name = response.body().getToken().getSub().getName();
                        System.out.println("=================== response is successful ================"+response);
                        Toast.makeText(getApplicationContext(), "Register Success", Toast.LENGTH_SHORT).show();
                    }
                    else {
                        Toast.makeText(getApplicationContext(), "Register Not Success", Toast.LENGTH_SHORT).show();
                        System.out.println("=================== response is unsuccessful ================"+response);
                    }
                }
                @Override
                public void onFailure(Call<RegisterResponseDTO> call, Throwable t) {
                    System.out.println("===================response failed ====================="+ t);
                }
            });
        }

    }
}