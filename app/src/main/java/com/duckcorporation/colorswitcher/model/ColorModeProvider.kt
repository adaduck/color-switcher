package com.duckcorporation.colorswitcher.model

import androidx.annotation.StyleRes
import com.duckcorporation.colorswitcher.R

interface ColorModeProvider {

    @StyleRes
    fun getColoredTheme(): Int

    fun switchColor()
}

object ColorModeProviderImpl : ColorModeProvider {

    private val settingsData: SettingsData = SettingsData(
        appName = "color swagger",
        userEmail = "goodboi@example.com",
        isLightTheme = true
    )

    override fun getColoredTheme(): Int {
        return if (settingsData.isLightTheme) {
            R.style.AppTheme_Light
        } else {
            R.style.AppTheme_Dark
        }
    }

    override fun switchColor() {
        settingsData.isLightTheme = !settingsData.isLightTheme
    }
}