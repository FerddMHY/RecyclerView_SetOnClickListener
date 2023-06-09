package com.example.recyclerviewsetonclicklistener;

public class User {
    private String username;
    private String email;
    private int image;

    public User(String username, String email, int image) {
        this.username = username;
        this.email = email;
        this.image = image;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}