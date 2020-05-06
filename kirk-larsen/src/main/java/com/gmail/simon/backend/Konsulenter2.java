package com.gmail.simon.backend;

public class Konsulenter2 {
    public String getRolle() {
        return rolle;
    }

    public void setRolle(String rolle) {
        this.rolle = rolle;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Konsulenter2(String rolle, String password, String username) {
        this.rolle = rolle;
        this.password = password;
        this.username = username;
    }
    public Konsulenter2(){}

    private String rolle;
    private String password;
    private String username;
}
