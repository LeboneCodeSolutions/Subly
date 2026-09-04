package com.example.subly.data.repository;

import com.example.subly.data.model.RegistrationRequestModel;
import com.example.subly.data.model.RegistrationResponseModel;

/**
 * Interface for the User Repository.
 * This abstraction allows the domain layer to be independent of data source implementations
 * (Dependency Inversion Principle).
 */
public interface UserRepository {
    /**
     * Handles the user registration process by coordinating remote and local data sources.
     * @param request The user registration request.
     * @return The result of the registration.
     */
    RegistrationResponseModel registerUser(RegistrationRequestModel request);
}
