package com.example.subly.ui.service.inputHandler

import com.example.subly.ui.interfaces.ValidationHandler
import utils.RegexPatterns
class NameValidationHandler : ValidationHandler {

    override fun setValidationType(pendentItem: String): Boolean {
        val itemStatus : Boolean = when(RegexPatterns.NAME_REGEX.matches(pendentItem)){
            true -> true
            else -> false
        }
        return itemStatus
    }
}