package com.dev.responses;

public class UserResponse extends BasicRespons{
    private String username;

    public UserResponse(boolean success, Integer errorCode, String username) {
        super(success, errorCode);
        this.username = username;
    }

    public UserResponse(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
