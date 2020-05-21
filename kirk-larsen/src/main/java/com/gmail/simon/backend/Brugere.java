package com.gmail.simon.backend;

public class Brugere {

    public enum Type {
        EMPLOYEE, PRIVATE_PERSON
    }
    private long id;
    private String firstName;
    private String lastName;
    private String password;
    private Type type;
    private String email;

    public Brugere (long id, String firstName, String lastName, Type type, String email, String password) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.type = type;
        this.email = email;
        this.password = password;

    }

    public long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Type getType() {
        return type;
    }

    public String getEmail() {
        return email;
    }
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
