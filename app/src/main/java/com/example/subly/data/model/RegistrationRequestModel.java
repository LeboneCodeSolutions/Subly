package com.example.subly.data.model;

import java.util.Objects;

/**
 * Data model representing a user registration request.
 * Data tranbsfer Object
 * Contains the necessary fields to create a new user account.
 */
public class RegistrationRequestModel {
    private String firstName;
    private String lastName;
    private String email;
    private Long phoneNumber;
    private String password;

    public RegistrationRequestModel() {super();
    }

    public RegistrationRequestModel(String firstName, String lastName, String email, Long phoneNumber, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.password = password;

    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }


    public String getPassword() {
        return password;
    }
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public void setPassword(String password) {
        this.password = password;
    }




    /// violates solid
    @Override
    public boolean equals(Object theUser) {
        // 1. Are they literally the same object?
        if (this == theUser) return true;
        // 2. Is the other object invalid/different?
        if (theUser == null || getClass() != theUser.getClass()) return false;
        // 3. Convert it to LocalUserRequest
        RegistrationRequestModel theRequest = (RegistrationRequestModel) theUser;
        // 4. Compare their values
        return Objects.equals(firstName, theRequest.firstName) &&
                Objects.equals(lastName, theRequest.lastName) &&
                Objects.equals(email, theRequest.email) &&
                Objects.equals(phoneNumber, theRequest.phoneNumber) &&
                Objects.equals(password, theRequest.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email, phoneNumber, password);
    }

    @Override
    public String toString() {
        return "UserRequest{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", password='[PROTECTED]'" +
                '}';
    }
}
