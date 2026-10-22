package com.example.jmt_miaplicacion.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jmt_miaplicacion.R
import com.example.jmt_miaplicacion.model.Personaje

@Composable
fun HomeScreen(
    modifier: Modifier,
    personaje: List<Personaje>,
    onFavPersonajeClick: (Long) -> Unit
) {
    Surface{
        Column(modifier = modifier.padding(12.dp), verticalArrangement = Arrangement.spacedBy(8.dp)
        ){
            FavScroll(
                modifier = Modifier.fillMaxWidth(),
                personaje = personaje,
                onPersonajeClick = { onFavPersonajeClick(it) }
            )
        }
    }
}

@Composable
fun FavScroll (
    modifier: Modifier,
    personaje: List<Personaje>,
    onPersonajeClick: (Long) -> Unit
) {
    Column(modifier = modifier) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(text = "Mis Personajes Favoritos", style = MaterialTheme.typography.titleLarge)
        }
        HorizontalDivider()

        LazyRow(
            modifier = Modifier.padding(all = 4.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(personaje){
                PersonajeHomeCard(
                    modifier = Modifier,
                    personaje = it,
                    onClick = {onPersonajeClick(it)}
                )
            }
        }
    }
}
@Composable
fun PersonajeHomeCard(
    modifier: Modifier,
    personaje: Personaje,
    onClick: (Long) -> Unit
) {
    Card(
        modifier = modifier.width(140.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.secondaryContainer),
        onClick = { onClick(personaje.id) }
    ) {
        Column(
            modifier = Modifier.padding(8.dp).fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                modifier = Modifier.size(120.dp),
                painter = painterResource(R.drawable.image_mockup),
                contentDescription = "Personaje"
            )

            Spacer(Modifier.height(4.dp))

            Text(
                modifier = Modifier.height(48.dp),
                text = personaje.nombre,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
                textAlign = TextAlign.Center
            )
        }
    }
}

@Preview
@Composable
fun HomeScreenPreview() {
    val personaje = listOf(
        Personaje(id = 0, nombre = "Krieg", modelo = "Pathfinder", clase = "Barbaro", nivel = "3",lore = "" ),
        Personaje(id = 1, nombre = "Cale", modelo = "D&D", clase = "Mago", nivel = "5",lore = "" ),
        Personaje(id = 2, nombre = "Aang", modelo = "D&D", clase = "Monje", nivel = "6",lore = "" ),
        Personaje(id = 3, nombre = "Jimmy", modelo = "Pathfinder", clase = "Pistolero", nivel = "4",lore = "" ),
        Personaje(id = 4, nombre = "Itthobaal", modelo = "D&D", clase = "Paladin", nivel = "20",lore = "" ),
        Personaje(id = 5, nombre = "Therrila", modelo = "D&D", clase = "Clerigo", nivel = "20", lore = "" ),
    )

    HomeScreen(
        modifier = Modifier,
        personaje = personaje,
        onFavPersonajeClick = {}
    )
}
