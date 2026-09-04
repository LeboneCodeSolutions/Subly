package com.example.subly.data.remote;

import com.example.subly.data.model.RegistrationRequestModel;
import com.example.subly.data.model.RegistrationResponseModel;

/**
 * Interface for remote data operations related to users.
 * Follows the Interface Segregation Principle by keeping user-related operations together.
 */
public interface UserRemoteDataSource {
    /**
     * Registers a new user on the remote server.
     * @param request The user registration details.
     * @return A response from the server.
     */
    RegistrationResponseModel registerUser(RegistrationRequestModel request);
}
