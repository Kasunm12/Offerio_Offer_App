package com.hasthiya.offerapplication.dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class RegisterDTO {

    @SerializedName("code")
    @Expose
    private int code;

    @SerializedName("success")
    @Expose
    private boolean success;

    @SerializedName("token")
    @Expose
    ArrayList<Token> token;

    @SerializedName("message")
    @Expose
    private String message;

    public RegisterDTO(int code, boolean success, ArrayList<Token> token, String message) {
        this.code = code;
        this.success = success;
        this.token = token;
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

    public ArrayList<Token> getToken() {
        return token;
    }

    public void setToken(ArrayList<Token> token) {
        this.token = token;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public class Token {

        @SerializedName("token")
        @Expose
        private String token;

        @SerializedName("expires")
        @Expose
        private String expires;

        @SerializedName("sub")
        @Expose
        ArrayList<Sub> sub;

        public Token(String token, String expires, ArrayList<Sub> sub) {
            this.token = token;
            this.expires = expires;
            this.sub = sub;
        }

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }

        public String getExpires() {
            return expires;
        }

        public void setExpires(String expires) {
            this.expires = expires;
        }

        public ArrayList<Sub> getSub() {
            return sub;
        }

        public void setSub(ArrayList<Sub> sub) {
            this.sub = sub;
        }
    }

    public class Sub {

        @SerializedName("id")
        @Expose
        private String id;

        @SerializedName("name")
        @Expose
        private String name;

        @SerializedName("email")
        @Expose
        private String email;

        @SerializedName("phone")
        @Expose
        private String phone;

        @SerializedName("image")
        @Expose
        private String image;

        public Sub(String id, String name, String email, String phone, String image) {
            this.id = id;
            this.name = name;
            this.email = email;
            this.phone = phone;
            this.image = image;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
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
