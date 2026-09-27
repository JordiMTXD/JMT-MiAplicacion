package com.example.jmt_miaplicacion.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jmt_miaplicacion.model.Personaje
import com.example.jmt_miaplicacion.ui.components.PersonajeCard


@Composable
fun PersonajeScreen(
    modifier: Modifier,
    personajes: List<Personaje>,
    onPersonajeClick: (Long) -> Unit
){
    Column(
        modifier = modifier
    ) {
        Text(text = "Personajes APP", style = MaterialTheme.typography.displaySmall)

        Spacer(modifier = Modifier.height(8.dp))

        PersonajesList(
            modifier = Modifier.fillMaxWidth(),
            personaje = personajes,
            onPersonajeClick = { onPersonajeClick(it)}
        )
    }
}

@Composable
fun PersonajesList(
    modifier: Modifier,
    personaje: List<Personaje>,
    onPersonajeClick: (Long) -> Unit

){
    LazyColumn(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(20){
            PersonajeCard(
                modifier = Modifier.fillMaxWidth(),
                personaje = personaje.random())
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PersonajeListPreview(){
    PersonajesList(
        modifier = Modifier,
        personaje = listOf(
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