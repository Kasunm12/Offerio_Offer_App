package com.hasthiya.offerapplication.dto.User;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class GetUsersDTO {

    @SerializedName("code")
    @Expose
    private int code;

    @SerializedName("success")
    @Expose
    private boolean success;

    @SerializedName("users")
    @Expose
    ArrayList<users> users;

    @SerializedName("message")
    @Expose
    private String message;

    public GetUsersDTO(int code, boolean success, ArrayList<GetUsersDTO.users> users, String message) {
        this.code = code;
        this.success = success;
        this.users = users;
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

    public ArrayList<GetUsersDTO.users> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<GetUsersDTO.users> users) {
        this.users = users;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public class users {

        @SerializedName("_id")
        @Expose
        private String _id;

        @SerializedName("name")
        @Expose
        private String name;

        @SerializedName("email")
        @Expose
        private String email;

        @SerializedName("password")
        @Expose
        private String password;

        @SerializedName("phone")
        @Expose
        private int phone;

        @SerializedName("__v")
        @Expose
        private int __v;

        @SerializedName("image")
        @Expose
        private String image;

        public users(String _id, String name, String email, String password, int phone, int __v, String image) {
            this._id = _id;
            this.name = name;
            this.email = email;
            this.password = password;
            this.phone = phone;
            this.__v = __v;
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

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public int getPhone() {
            return phone;
        }

        public void setPhone(int phone) {
            this.phone = phone;
        }

        public int get__v() {
            return __v;
        }

        public void set__v(int __v) {
            this.__v = __v;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }
    }

}


