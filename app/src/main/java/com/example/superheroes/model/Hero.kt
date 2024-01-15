package com.example.superheroes.model

import android.media.Image
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Hero(
    @StringRes val nameResId: Int,
    @StringRes val descriptionResId: Int,
    @DrawableRes val imageResId: Int,
)
