package com.example.subly.domain;

import com.example.subly.data.model.RegistrationRequestModel;
import com.example.subly.data.model.RegistrationResponseModel;
import com.example.subly.data.repository.UserRepository;

/**
 * Use case for registering a new user.
 * Follows the Single Responsibility Principle by encapsulating a single business action.
 */
public class RegisterUserUseCase {
    private final UserRepository userRepository;

    public RegisterUserUseCase(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public RegistrationResponseModel execute(RegistrationRequestModel request) {
        // Business logic can be added here (e.g., validation, logging)
        if (request == null) {
            return new RegistrationResponseModel(null, null, "Invalid request", false);
        }
        return userRepository.registerUser(request);
    }
}
