package com.duckcorporation.colorswitcher

import android.content.res.ColorStateList
import android.graphics.PorterDuff
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.ImageViewCompat
import com.duckcorporation.colorswitcher.base.getAppColor
import com.duckcorporation.colorswitcher.base.recreateSmoothly
import com.duckcorporation.colorswitcher.model.ColorModeProvider
import com.duckcorporation.colorswitcher.model.ColorModeProviderImpl
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val colorModeProvider: ColorModeProvider = ColorModeProviderImpl

    override fun onCreate(savedInstanceState: Bundle?) {
        //Do it before super.onCreate as theme is used there for example in day&night mode
        setTheme(colorModeProvider.getColoredTheme())
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        addDogsImageTint()
        setViewListeners()
    }

    private fun addDogsImageTint() {
        with(dogsImageView) {
            ImageViewCompat.setImageTintMode(this, PorterDuff.Mode.OVERLAY)
            ImageViewCompat.setImageTintList(
                this,
                ColorStateList.valueOf(getAppColor(R.attr.colorAccent))
            )
        }
    }

    private fun setViewListeners() {
        colorSwitcherButton.setOnClickListener {
            colorModeProvider.switchColor()
            if (animationCheckBox.isChecked) {
                recreateSmoothly()
            } else {
                recreate()
            }
        }
    }

}
