package com.example.subly.ui.service.inputHandler

import android.content.Context
import android.text.Editable
import android.text.TextWatcher
import android.widget.TextView
import com.example.subly.ui.concrete.PasswordValidationCheckerImpl
import com.example.subly.ui.interfaces.PasswordStrengthModifier
import com.google.android.material.textfield.TextInputEditText
import utils.RegexPatterns

class PasswordValidationHandler: PasswordStrengthModifier {
    override fun setValidationType(pendentItem: String): Boolean {
        val itemStatus : Boolean = when(RegexPatterns.PASSWORD_REGEX.matches(pendentItem)){
            true -> true
            else -> false
        }
        return itemStatus
    }
    override fun setPasswordStrength(password: String, textView: TextView): Int {
        var score = 0
        when (password.isEmpty()) {
            true -> return 0
            else -> {
                RegexPatterns.regexCheckList().forEach { regex ->
                    if (PasswordValidationCheckerImpl().regexValidation(password,regex)) {
                        score++
                    }
                }
            }
        }
        return score
    }


    override fun updatePasswordUI(textInputEditText: TextInputEditText, textView: TextView) {
        textInputEditText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun afterTextChanged(s: Editable?) {}
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                setPasswordStrength(s.toString(), textView)
            }
        })
    }
}
