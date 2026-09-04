package com.example.subly.ui.interfaces

import android.content.Context
import android.content.res.ColorStateList

interface ValidationColorHandler {
    fun updateValidationColor(context: Context): ColorStateList
}