package com.hasthiya.offerapplication.dto.Shop;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class GetAllCategory {

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

    public GetAllCategory(int code, boolean success, ArrayList<Data> data, String message) {
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
        private String _id;

        @SerializedName("catName")
        @Expose
        private String catName;

        @SerializedName("image")
        @Expose
        private String image;

        public Data(String _id, String catName, String image) {
            this._id = _id;
            this.catName = catName;
            this.image = image;
        }

        public String get_id() {
            return _id;
        }

        public void set_id(String _id) {
            this._id = _id;
        }

        public String getCatName() {
            return catName;
        }

        public void setCatName(String catName) {
            this.catName = catName;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }
    }
}
