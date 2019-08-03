package com.duckcorporation.colorswitcher.base

import android.content.Context
import android.util.TypedValue
import androidx.annotation.AttrRes
import androidx.annotation.ColorInt
import androidx.annotation.ColorRes
import androidx.core.content.ContextCompat

@ColorInt
fun Context.getAppColor(@AttrRes colorAttr: Int): Int {
    val resolvedAttr = resolveThemeAttr(this, colorAttr)
    return if (resolvedAttr.resourceId != 0) {
        return ContextCompat.getColor(this, resolvedAttr.resourceId)
    } else {
        resolvedAttr.data
    }
}

@ColorRes
fun Context.getAppColorRes(@AttrRes colorAttr: Int): Int {
    val resolvedAttr = resolveThemeAttr(this, colorAttr)
    // resourceId is used if it's a ColorStateList, and data if it's a color reference or a hex color
    return if (resolvedAttr.resourceId != 0) resolvedAttr.resourceId else 0
}

private fun resolveThemeAttr(context: Context, @AttrRes attrRes: Int): TypedValue {
    val typedValue = TypedValue()
    context.theme.resolveAttribute(attrRes, typedValue, true)
    return typedValue
}