package com.hasthiya.offerapplication.api;

import com.hasthiya.offerapplication.dto.User.RegisterRequestDTO;
import com.hasthiya.offerapplication.dto.User.RegisterResponseDTO;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ApiServices {

    @POST("user/register")
    Call<RegisterResponseDTO> registerUser(@Body RegisterRequestDTO registerRequestDTO);
}
