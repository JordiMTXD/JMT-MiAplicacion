package com.example.jmt_miaplicacion.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
fun HomeScreen(
    modifier: Modifier,
    onCrearPersonaje: () -> Unit,
    onVerPersonajes: () -> Unit
) {
    Column(
        modifier = modifier.fillMaxHeight(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Button(
            onClick = {onCrearPersonaje()}
        ) { Text("Crear Personaje") }

        Spacer(modifier = modifier.height(100.dp))

        Button(onClick = {onVerPersonajes()}
        ) { Text("Ver Personajes") }
    }
}

@Preview
@Composable
private fun HomeScreenPreview(){
    HomeScreen(
        modifier = Modifier,
        onVerPersonajes = {},
        onCrearPersonaje = {}
    )
}