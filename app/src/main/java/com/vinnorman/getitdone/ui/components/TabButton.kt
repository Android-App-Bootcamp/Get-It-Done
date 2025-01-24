package com.vinnorman.getitdone.ui.components

import android.content.Context
import android.util.AttributeSet
import androidx.core.content.ContextCompat
import com.google.android.material.button.MaterialButton

class TabButton @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = com.google.android.material.R.attr.materialButtonOutlinedStyle
) : MaterialButton(context, attrs, defStyleAttr) {

    init {
        iconGravity = ICON_GRAVITY_START
        iconPadding = 8
        setPadding(16, 8, 16, 8)
        strokeWidth = 0
        setBackgroundColor(android.graphics.Color.TRANSPARENT)
    }

    fun setup(text: String, iconResId: Int, textColorResId: Int) {
        this.text = text
        setIconResource(iconResId)
        setTextColor(ContextCompat.getColor(context, textColorResId))
    }
}
