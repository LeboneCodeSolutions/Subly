package com.example.subly.ui.concrete

import android.content.Context
import android.content.res.ColorStateList
import android.text.Editable
import android.text.TextWatcher
import com.example.subly.ui.base.ColorChangeUIText
import com.example.subly.ui.service.colorHandler.InvalidHandler
import com.example.subly.ui.service.colorHandler.ValidHandler
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class ColorChangeUITextImpl: ColorChangeUIText() {
    val colorStateChange = ColorStateChangeImpl()
    override fun colorChangeUIText(
        context: Context,
        textInputEditText: TextInputEditText,
        textInputLayout: TextInputLayout,
        regexPattern: Regex
    ) {
        textInputEditText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
            override fun afterTextChanged(s: Editable?) {
                when {
                    s.toString().matches(regexPattern) -> {

                        colorStateChange.generateColorStateChange(
                            textInputLayout,
                            textInputEditText,
                            ValidHandler().updateValidationColor(context)
                        )
                    }

                    else -> {

                        colorStateChange.generateColorStateChange(
                            textInputLayout,
                            textInputEditText,
                            InvalidHandler().updateValidationColor(context)
                        )
                    }
                }
            }
        })
    }

}