package com.example.superheroes

import SuperheroesTheme
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
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
            .background(MaterialTheme.colorScheme.primaryContainer)
            .clip(
                RoundedCornerShape(16.dp)
            )
    ) {
        Row(modifier = modifier
            .padding(16.dp)
            .height(72.dp)) {
            HeroDetails(nameResId = hero.nameResId, descriptionResId = hero.descriptionResId)
            Spacer(modifier = Modifier.width(16.dp))
            HeroAvatar(imageResId = hero.imageResId)
        }
    }
}

@Composable
fun HeroAvatar(
    modifier: Modifier = Modifier,
    @DrawableRes imageResId: Int,
) {
    Box(modifier = modifier.size(72.dp)) {
        Image(
            painter = painterResource(id = imageResId),
            contentDescription = null,
            modifier = Modifier.clip(RoundedCornerShape(8.dp))
        )
    }
}

@Composable
fun HeroDetails(
    modifier: Modifier = Modifier,
    @StringRes nameResId: Int,
    @StringRes descriptionResId: Int,
) {
    Column {
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

@Preview
@Composable
fun HeroCardPreview() {
    SuperheroesTheme {
        HeroCard(hero = HeroesRepository.heroes[0])
    }
}