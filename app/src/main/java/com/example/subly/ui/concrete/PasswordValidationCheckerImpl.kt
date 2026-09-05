package com.example.subly.ui.concrete

import com.example.subly.ui.base.PasswordValidationChecker

class PasswordValidationCheckerImpl : PasswordValidationChecker() {
    override fun regexValidation(
        password: String,
        regexCondition: Regex
    ): Boolean {
        val score : Boolean = when(password.matches(regexCondition)) {
            true -> true
            else -> false
        }

        return score
    }
}