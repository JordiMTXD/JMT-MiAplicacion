package com.example.jmt_miaplicacion.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jmt_miaplicacion.model.Personaje

@Composable
fun PersonajeScreen(
    modifier: Modifier,
    personajes: List<Personaje>,
    onPersonajeClick: (Long) -> Unit
){
    Column(
        modifier = modifier.padding(12.dp)
    ) {
        PersonajesList(
            modifier = Modifier.fillMaxWidth(),
            personajes = personajes,
            onPersonajeClick = { onPersonajeClick(it)}
        )
    }
}

@Composable
fun PersonajesList(
    modifier: Modifier,
    personajes: List<Personaje>,
    onPersonajeClick: (Long) -> Unit

){
    Column(
        modifier = modifier.padding(12.dp)
    ) {
        PersonajesList(
            modifier = modifier.fillMaxWidth(),
            personajes = personajes,
            onPersonajeClick = { onPersonajeClick(it) }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PersonajeListPreview(){
    PersonajesList(
        modifier = Modifier,
        personajes = listOf(
            Personaje(id = 0, nombre = "Krieg", modelo = "Pathfinder", clase = "Barbaro", nivel = "3",lore = "" ),
            Personaje(id = 1, nombre = "Cale", modelo = "D&D", clase = "Mago", nivel = "5",lore = "" ),
            Personaje(id = 2, nombre = "Aang", modelo = "D&D", clase = "Monje", nivel = "6",lore = "" ),
            Personaje(id = 3, nombre = "Jimmy", modelo = "Pathfinder", clase = "Pistolero", nivel = "4",lore = "" ),
            Personaje(id = 4, nombre = "Itthobaal", modelo = "D&D", clase = "Paladin", nivel = "20",lore = "" ),
            Personaje(id = 5, nombre = "Therrila", modelo = "D&D", clase = "Clerigo", nivel = "20", lore = "" ),
        ),
        onPersonajeClick = {}
    )
}
