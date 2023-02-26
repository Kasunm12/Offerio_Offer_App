package com.hasthiya.offerapplication.dto.Shop;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.hasthiya.offerapplication.dto.User.UpdateUserDTO;

import java.util.ArrayList;

public class CreateShop {

    @SerializedName("code")
    @Expose
    private int code;

    @SerializedName("success")
    @Expose
    private boolean success;

    @SerializedName("data")
    @Expose
    ArrayList<data> data;

    @SerializedName("message")
    @Expose
    private String message;

    public CreateShop(int code, boolean success, ArrayList<CreateShop.data> data, String message) {
        this.code = code;
        this.success = success;
        this.data = data;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public ArrayList<CreateShop.data> getData() {
        return data;
    }

    public void setData(ArrayList<data> data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public class data {

        @SerializedName("name")
        @Expose
        private String name;

        @SerializedName("category")
        @Expose
        private String category;

        @SerializedName("promotion")
        @Expose
        ArrayList<promotion> promotion;

        @SerializedName("description")
        @Expose
        private String description;

        @SerializedName("location")
        @Expose
        private String location;

        @SerializedName("lat")
        @Expose
        private String lat;

        @SerializedName("lng")
        @Expose
        private String lng;

        @SerializedName("email")
        @Expose
        private String email;

        @SerializedName("phone")
        @Expose
        private String phone;

        @SerializedName("image")
        @Expose
        private String image;

        @SerializedName("_id")
        @Expose
        private String _id;

        @SerializedName("__v")
        @Expose
        private String __v;

        public class promotion {

        }

        }

}
