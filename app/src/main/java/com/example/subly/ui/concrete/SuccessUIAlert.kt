package com.example.subly.ui.concrete

import android.content.Context
import android.widget.TextView
import com.example.subly.R
import com.example.subly.ui.interfaces.UIAlert
import com.example.subly.ui.service.colorHandler.TextColorModifier

class SuccessUIAlert  : UIAlert {
    override fun tvAlert(
        context: Context,
        input: TextView,
        input2: TextView,
        input3: TextView,
        colorTool: TextColorModifier
    ) {
        val textViews = listOf(input, input2, input3)
        val colorID = R.color.color_success
        textViews.forEach { textView ->
            textView.setTextColor(colorTool.stateTextColor(context, colorID))
        }
    }
}