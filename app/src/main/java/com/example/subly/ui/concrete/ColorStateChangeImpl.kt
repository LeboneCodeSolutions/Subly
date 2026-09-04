package com.example.subly.ui.concrete

import android.content.Context
import android.content.res.ColorStateList
import com.example.subly.ui.base.ColorStateChange
import com.example.subly.ui.service.colorHandler.InvalidHandler
import com.example.subly.ui.service.colorHandler.ValidHandler
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class ColorStateChangeImpl : ColorStateChange() {

    override fun generateColorStateChange(
        textInputLayout: TextInputLayout,
        textInputEditText: TextInputEditText,
        colorStateList: ColorStateList
    ) {
        textInputLayout.setBoxStrokeColorStateList(colorStateList)
        textInputEditText.setTextColor(
            colorStateList.defaultColor
        )
    }
}