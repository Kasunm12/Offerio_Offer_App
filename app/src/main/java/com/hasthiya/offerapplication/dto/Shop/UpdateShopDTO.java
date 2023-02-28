package com.hasthiya.offerapplication.dto.Shop;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class UpdateShopDTO {

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

    public UpdateShopDTO(int code, boolean success, ArrayList<UpdateShopDTO.data> data, String message) {
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

    public ArrayList<UpdateShopDTO.data> getData() {
        return data;
    }

    public void setData(ArrayList<UpdateShopDTO.data> data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public class data {

        @SerializedName("_id")
        @Expose
        private String _id;

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

        @SerializedName("__v")
        @Expose
        private String __v;

        public data(String _id, String name, String category, ArrayList<UpdateShopDTO.data.promotion> promotion, String description, String location, String lat, String lng, String email, String phone, String image, String __v) {
            this._id = _id;
            this.name = name;
            this.category = category;
            this.promotion = promotion;
            this.description = description;
            this.location = location;
            this.lat = lat;
            this.lng = lng;
            this.email = email;
            this.phone = phone;
            this.image = image;
            this.__v = __v;
        }

        public String get_id() {
            return _id;
        }

        public void set_id(String _id) {
            this._id = _id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getCategory() {
            return category;
        }

        public void setCategory(String category) {
            this.category = category;
        }

        public ArrayList<UpdateShopDTO.data.promotion> getPromotion() {
            return promotion;
        }

        public void setPromotion(ArrayList<UpdateShopDTO.data.promotion> promotion) {
            this.promotion = promotion;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getLocation() {
            return location;
        }

        public void setLocation(String location) {
            this.location = location;
        }

        public String getLat() {
            return lat;
        }

        public void setLat(String lat) {
            this.lat = lat;
        }

        public String getLng() {
            return lng;
        }

        public void setLng(String lng) {
            this.lng = lng;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public String get__v() {
            return __v;
        }

        public void set__v(String __v) {
            this.__v = __v;
        }

        public class promotion {

        }



    }
}
