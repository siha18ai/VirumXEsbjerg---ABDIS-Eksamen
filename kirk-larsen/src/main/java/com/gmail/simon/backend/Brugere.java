package com.gmail.simon.backend;

public class Brugere {
    private enum Type {
        EMPLOYEE, PRIVATE_PERSON
    }
    private long id;
    private String firstName;
    private String lastName;
    private Type type;
    private String email;

    public Brugere (long id, String firstName, String lastName, Type type, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.type = type;
        this.email = email;
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
}
