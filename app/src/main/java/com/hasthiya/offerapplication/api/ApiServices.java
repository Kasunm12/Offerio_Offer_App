package com.hasthiya.offerapplication.api;

import com.hasthiya.offerapplication.dto.Promotions.GetAllPromotions;
import com.hasthiya.offerapplication.dto.Promotions.GetOnePromotion;
import com.hasthiya.offerapplication.dto.User.GetUserDTO;
import com.hasthiya.offerapplication.dto.User.GetUsersDTO;
import com.hasthiya.offerapplication.dto.User.LoginRequestDTO;
import com.hasthiya.offerapplication.dto.User.LoginResponseDTO;
import com.hasthiya.offerapplication.dto.User.RegisterRequestDTO;
import com.hasthiya.offerapplication.dto.User.RegisterResponseDTO;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface ApiServices {

    @POST("user/register")
    Call<RegisterResponseDTO> registerUser(@Body RegisterRequestDTO registerRequestDTO);

    @POST("user/login")
    Call<LoginResponseDTO> LoginUser(@Body LoginRequestDTO loginRequestDTO);

    @GET("promotions/getAll")
    Call<GetAllPromotions> getAllPromotions();

    @GET("promotions/getOne/{promo_id}")
    Call<GetOnePromotion> getOnePromotion(@Path("promo_id") String promo_id);

    @GET("user/getUser/{user_id}")
    Call<GetUserDTO> getUserDetails(@Path("user_id") String user_id);
}
