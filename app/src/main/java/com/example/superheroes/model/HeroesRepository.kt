package com.example.superheroes.model

import com.example.superheroes.R
import com.example.superheroes.model.Hero

object HeroesRepository {
    val heroes = listOf(
        Hero(
            nameResId = R.string.hero1,
            descriptionResId = R.string.description1,
            imageResId = R.drawable.android_superhero1
        ),
        Hero(
            nameResId = R.string.hero2,
            descriptionResId = R.string.description2,
            imageResId = R.drawable.android_superhero2
        ),
        Hero(
            nameResId = R.string.hero3,
            descriptionResId = R.string.description3,
            imageResId = R.drawable.android_superhero3
        ),
        Hero(
            nameResId = R.string.hero4,
            descriptionResId = R.string.description4,
            imageResId = R.drawable.android_superhero4
        ),
        Hero(
            nameResId = R.string.hero5,
            descriptionResId = R.string.description5,
            imageResId = R.drawable.android_superhero5
        ),
        Hero(
            nameResId = R.string.hero6,
            descriptionResId = R.string.description6,
            imageResId = R.drawable.android_superhero6
        )
    )

}