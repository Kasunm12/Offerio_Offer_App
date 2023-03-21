package com.hasthiya.offerapplication.dto.Promotions;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class GetOnePromotion {

    @SerializedName("code")
    @Expose
    private int code;

    @SerializedName("success")
    @Expose
    private boolean success;

    @SerializedName("data")
    @Expose
    private ArrayList<Data> data;

    @SerializedName("message")
    @Expose
    private String message;

    public GetOnePromotion(int code, boolean success, ArrayList<Data> data, String message) {
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
        private String id;

        @SerializedName("offer")
        @Expose
        private String offer;

        @SerializedName("availability")
        @Expose
        private String availability;

        @SerializedName("price")
        @Expose
        private String price;

        @SerializedName("description")
        @Expose
        private String description;

        @SerializedName("types")
        @Expose
        private String types;

        @SerializedName("image")
        @Expose
        private String image;

        public Data(String id, String offer, String availability, String price, String description, String types, String image) {
            this.id = id;
            this.offer = offer;
            this.availability = availability;
            this.price = price;
            this.description = description;
            this.types = types;
            this.image = image;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getOffer() {
            return offer;
        }

        public void setOffer(String offer) {
            this.offer = offer;
        }

        public String getAvailability() {
            return availability;
        }

        public void setAvailability(String availability) {
            this.availability = availability;
        }

        public String getPrice() {
            return price;
        }

        public void setPrice(String price) {
            this.price = price;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getType() {
            return types;
        }

        public void setType(String type) {
            this.types = types;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }
    }
}
