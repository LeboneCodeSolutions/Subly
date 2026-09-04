package com.example.subly.data.model;

import java.util.Objects;

/**
 * Data model representing the server's response after a registration attempt.
 * What do i want it to send back to me >>
 *      1. firebaseUid
 *      2. success message // I will create the respponse
 *      3. success
 */
public class RegistrationResponseModel {
    private String userId;
    private String token;
    private String message;
    private boolean success;

    public RegistrationResponseModel() {super();
    }

    public RegistrationResponseModel(String userId, String message, boolean success) {
        this.userId = userId;
        this.message = message;
        this.success = success;
    }

    public RegistrationResponseModel(String s, String s1, String registrationSuccessful, boolean b) {
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }


    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RegistrationResponseModel that = (RegistrationResponseModel) o;
        return success == that.success &&
                Objects.equals(userId, that.userId) &&
                Objects.equals(message, that.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, token, message, success);
    }

    @Override
    public String toString() {
        return "UserResponse{" +
                "userId='" + userId + '\'' +
             ", message='" + message + '\'' +
                ", success=" + success +
                '}';
    }
}
