package com.example.subly.ui.base

import android.content.Context
import android.content.res.ColorStateList

import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

abstract class ColorStateChange {
    abstract fun generateColorStateChange(
        textInputLayout: TextInputLayout,
        textInputEditText: TextInputEditText,
        colorStateList: ColorStateList
    )
}