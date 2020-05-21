package com.gmail.simon.backend;

import java.time.LocalDate;

public class Person {

	public enum Role {
		DESIGNER, DEVELOPER, MANAGER, TRADER, PAYMENT_HANDLER, ACCOUNTANT
	}

	private Long id;
	private String firstName;
	private String lastName;
	private Role role;
	private String role2;
	private String email;
	private boolean randomBoolean;
	private int randomInteger;
	private LocalDate lastModified;

	public Person(Long id, String firstName, String lastName, Role role,
	              String email, boolean randomBoolean, int randomInteger,
	              LocalDate lastModified) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.role = role;
		this.email = email;
		this.randomBoolean = randomBoolean;
		this.randomInteger = randomInteger;
		this.lastModified = lastModified;
	}
	public Person(String firstName, String lastName, String role2){
		this.firstName = firstName;
		this.lastName = lastName;
		this.role2 = role2;
	}
	public Person() {}

	public Long getId() {
		return id;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getName() {
		return firstName + " " + lastName;
	}


	public String getInitials() {
		return (firstName.substring(0, 1) + lastName.substring(0, 1))
				.toUpperCase();
	}

	public Role getRole() {
		return role;
	}

	public String getEmail() {
		return email;
	}

	public boolean getRandomBoolean() {
		return randomBoolean;
	}

	public int getRandomInteger() {
		return randomInteger;
	}

	public LocalDate getLastModified() {
		return lastModified;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRole2() {
		return role2;
	}

	public void setRole2(String role2) {
		this.role2 = role2;
	}
}
