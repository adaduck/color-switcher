package com.duckcorporation.colorswitcher.model

data class SettingsData(
    val appName: String,
    val userEmail: String,
    //...some other mysterious data
    var isLightTheme: Boolean,
    var customColor: String? = null
)