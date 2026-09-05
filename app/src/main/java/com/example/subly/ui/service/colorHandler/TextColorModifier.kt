package com.example.subly.ui.service.colorHandler

import android.content.Context
import androidx.core.content.ContextCompat.getColor

class TextColorModifier {
    fun stateTextColor(context: Context, colorID: Int):Int{
        return getColor(context, colorID)// Example return color
    }
}