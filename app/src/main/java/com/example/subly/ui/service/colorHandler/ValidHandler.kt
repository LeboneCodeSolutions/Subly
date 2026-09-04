package com.example.subly.ui.service.colorHandler
import android.content.Context
import com.example.subly.R
import android.content.res.ColorStateList
import android.content.res.ColorStateList.valueOf
import com.example.subly.ui.interfaces.ValidationColorHandler
import androidx.core.content.ContextCompat.getColor


class ValidHandler: ValidationColorHandler {
    override fun updateValidationColor(context: Context): ColorStateList {
        return  valueOf(getColor(context, R.color.black))
    }
}