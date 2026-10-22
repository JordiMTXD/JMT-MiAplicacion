package com.example.jmt_miaplicacion.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jmt_miaplicacion.R
import com.example.jmt_miaplicacion.model.Personaje

@Composable
fun DetalleScreen(
    modifier: Modifier,
    personaje: Personaje
) {
    Column(
        modifier = modifier
    ) {
        Surface(
            modifier = Modifier.fillMaxWidth(),
            color = MaterialTheme.colorScheme.secondaryContainer
        ) {
            Column(
                modifier = Modifier.padding(12.dp).fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Image(
                    modifier = Modifier.fillMaxWidth().aspectRatio(1f),
                    painter = painterResource(R.drawable.image_mockup),
                    contentDescription = "Imagen Personaje"
                )

                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = "Nombre : " + personaje.nombre,
                    style = MaterialTheme.typography.titleLarge,
                    textAlign = TextAlign.Center,
                )

                Spacer(modifier = Modifier.height(8.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    Text(
                        text = "Clase : " + personaje.clase,
                        style = MaterialTheme.typography.bodyMedium,
                        textAlign = TextAlign.Center
                    )

                    Spacer(modifier = Modifier.width(16.dp))

                    Text(
                        text = "Nivel : " + personaje.nivel,
                        style = MaterialTheme.typography.bodyMedium,
                        textAlign = TextAlign.Center
                    )

                    Spacer(modifier = Modifier.width(16.dp))

                    Text(
                        text = "Modelo : " + personaje.modelo,
                        style = MaterialTheme.typography.bodyMedium,
                        textAlign = TextAlign.Center
                    )
                }
            }
        }
        Surface(
            modifier = Modifier
                .fillMaxSize()

        ){

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(12.dp)
                    .verticalScroll(rememberScrollState())
            ) {
                Text(
                    text = personaje.lore,
                    style = MaterialTheme.typography.bodyLarge
                )
            }


        }
    }
}

@Preview
@Composable
fun DetalleScreenPreview(){
    DetalleScreen(
        modifier = Modifier,
        personaje = Personaje(
            id = 1,
            nombre = "Krieg",
            modelo = "D&D",
            clase = "Barbaro",
            nivel = "3",
            lore = "Lorem ipsum dolor sit amet consectetur adipiscing elit pretium, mattis tortor cubilia dui ridiculus lacinia netus natoque, ut donec convallis non libero inceptos purus."
        )
    )
}
