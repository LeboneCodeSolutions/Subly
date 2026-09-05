package com.example.subly.ui.interfaces

import android.content.Context
import android.widget.TextView
import com.example.subly.ui.service.colorHandler.TextColorModifier

interface UIAlert {
    fun tvAlert(context: Context, input: TextView, input2: TextView, input3: TextView, colorTool:  TextColorModifier)
}