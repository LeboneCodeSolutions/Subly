package com.example.subly.data.remote;

import com.example.subly.data.model.RegistrationRequestModel;
import com.example.subly.data.model.RegistrationResponseModel;

/**
 * Concrete implementation of UserRemoteDataSource using a network client.
 */
public class RegistrationRemoteDataSource implements UserRemoteDataSource {

    @Override
    public RegistrationResponseModel registerUser(RegistrationRequestModel request) {
        // In a real app, this would use Retrofit/OkHttp to call an API.
        // For now, we simulate a successful network response.
        return new RegistrationResponseModel(
                "user_" + System.currentTimeMillis(),
                "dummy_token_" + Math.random(),
                "Registration successful",
                true
        );
    }
}
