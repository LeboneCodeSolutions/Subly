package com.example.subly.ui.base

import android.content.Context
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

abstract class ColorChangeUIText {
    abstract fun colorChangeUIText(context: Context, textInputEditText: TextInputEditText, textInputLayout: TextInputLayout, regexPattern: Regex)
}