package com.example.subly.ui.base

abstract class PasswordValidationChecker {
    abstract fun regexValidation(password: String, regexCondition: Regex): Boolean
}