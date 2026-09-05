package com.example.subly.ui.interfaces

import android.content.Context
import android.widget.TextView
import com.google.android.material.textfield.TextInputEditText

interface PasswordStrengthModifier : ValidationHandler {
    fun setPasswordStrength(password: String, textView: TextView): Int
    fun updatePasswordUI( textInputEditText: TextInputEditText, textView: TextView)
}