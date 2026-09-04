package com.example.subly.ui.service.inputHandler

import com.example.subly.ui.interfaces.ValidationHandler
import utils.RegexPatterns

class PasswordValidationHandler: ValidationHandler {
    override fun setValidationType(pendentItem: String): Boolean {
        val itemStatus : Boolean = when(RegexPatterns.PASSWORD_REGEX.matches(pendentItem)){
            true -> true
            else -> false
        }
        return itemStatus
    }
}