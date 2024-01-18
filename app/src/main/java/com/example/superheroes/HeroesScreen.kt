package com.example.superheroes

import SuperheroesTheme
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.FloatingActionButtonDefaults.elevation
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.PointerIcon.Companion.Text
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.superheroes.model.Hero
import com.example.superheroes.model.HeroesRepository

@Composable
fun HeroCard(
    modifier: Modifier = Modifier,
    hero: Hero,
) {
    ElevatedCard(
        elevation = CardDefaults.cardElevation(
            defaultElevation = 2.dp
        ),
        modifier = modifier
            .fillMaxWidth(),
        shape = RoundedCornerShape(16.dp)
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .height(72.dp),
        ) {
            HeroDetails(
                modifier = Modifier.weight(1f),
                nameResId = hero.nameResId, descriptionResId = hero.descriptionResId)
            Spacer(modifier = Modifier.width(16.dp))
            HeroAvatar(
                imageResId = hero.imageResId,
                modifier = Modifier.requiredSize(72.dp),
            )
        }
    }
}

@Composable
fun HeroAvatar(
    modifier: Modifier = Modifier,
    @DrawableRes imageResId: Int,
) {
    Box(modifier = modifier.clip(RoundedCornerShape(8.dp)).aspectRatio(1f)) {
        Image(
            painter = painterResource(id = imageResId),
            contentDescription = null,
        )
    }
}

@Composable
fun HeroDetails(
    @StringRes nameResId: Int,
    @StringRes descriptionResId: Int,
    modifier: Modifier = Modifier,
) {
    Column(modifier = modifier) {
        Text(
            text = stringResource(id = nameResId),
            style = MaterialTheme.typography.displaySmall,
        )

        Text(
            text = stringResource(id = descriptionResId),
            style = MaterialTheme.typography.bodyLarge,
        )
    }
}

@Composable
fun HeroesList(
    modifier: Modifier = Modifier,
    heroes: List<Hero>,
) {
    LazyColumn(
        modifier = modifier.padding(8.dp)) {
        items(heroes) {
            HeroCard(hero = it, modifier = Modifier.padding(8.dp))
        }
    }
}

@Preview
@Composable
fun HeroCardPreview() {
    SuperheroesTheme {
        HeroCard(hero = HeroesRepository.heroes[0])
    }
}


@Preview(showBackground = true)
@Composable
fun SuperheroesPreview() {
    SuperheroesTheme {
        HeroesList(heroes = HeroesRepository.heroes, modifier = Modifier.fillMaxWidth())
    }
}