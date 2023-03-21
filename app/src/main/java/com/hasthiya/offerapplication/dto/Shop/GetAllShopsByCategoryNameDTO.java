package com.hasthiya.offerapplication.dto.Shop;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class GetAllShopsByCategoryNameDTO {

    @SerializedName("code")
    @Expose
    private String code;

    @SerializedName("success")
    @Expose
    private boolean success;

    @SerializedName("data")
    @Expose
    private ArrayList<Data> data;

    @SerializedName("message")
    @Expose
    private String message;

    public GetAllShopsByCategoryNameDTO(String code, boolean success, ArrayList<Data> data, String message) {
        this.code = code;
        this.success = success;
        this.data = data;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public ArrayList<Data> getData() {
        return data;
    }

    public void setData(ArrayList<Data> data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public class Data{

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
        private List<String> promotion;

        @SerializedName("description")
        @Expose
        private String description;

        @SerializedName("location")
        @Expose
        private String location;

        @SerializedName("lat")
        @Expose
        private double lat;

        @SerializedName("lng")
        @Expose
        private double lng;

        @SerializedName("email")
        @Expose
        private String email;

        @SerializedName("phone")
        @Expose
        private String phone;

        @SerializedName("image")
        @Expose
        private String image;

        public Data(String _id, String name, String category, List<String> promotion, String description, String location, double lat, double lng, String email, String phone, String image) {
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

        public List<String> getPromotion() {
            return promotion;
        }

        public void setPromotion(List<String> promotion) {
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

        public double getLat() {
            return lat;
        }

        public void setLat(double lat) {
            this.lat = lat;
        }

        public double getLng() {
            return lng;
        }

        public void setLng(double lng) {
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
    }
}
