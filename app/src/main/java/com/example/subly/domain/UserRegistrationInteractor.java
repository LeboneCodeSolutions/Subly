package com.example.subly.domain;

import com.example.subly.data.model.RegistrationRequestModel;
import com.example.subly.data.model.RegistrationResponseModel;

/**
 * Interactor that manages user registration operations.
 * It coordinates multiple use cases if necessary.
 */
public class UserRegistrationInteractor {
    private final RegisterUserUseCase registerUserUseCase;

    public UserRegistrationInteractor(RegisterUserUseCase registerUserUseCase) {
        this.registerUserUseCase = registerUserUseCase;
    }

    public RegistrationResponseModel register(RegistrationRequestModel request) {
        return registerUserUseCase.execute(request);
    }
}
