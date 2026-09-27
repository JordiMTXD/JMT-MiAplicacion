package com.example.jmt_miaplicacion.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jmt_miaplicacion.R
import com.example.jmt_miaplicacion.model.Personaje

@Composable
fun PersonajeCard (
    modifier: Modifier,
    personaje: Personaje
){
    Card(
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(
            modifier = Modifier.fillMaxWidth().padding(8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                modifier = Modifier.size(64.dp).clip(RoundedCornerShape(10.dp)),
                painter = painterResource(R.drawable.image_mockup),
                contentDescription = "Imagen Personaje"
            )

            Spacer(modifier = Modifier.width(16.dp))

            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = personaje.nombre, style = MaterialTheme.typography.titleLarge,
                    textAlign = TextAlign.Center, modifier = Modifier.fillMaxWidth()                    )

                Spacer(modifier = Modifier.height(8.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    Text(
                        text = personaje.clase,
                        style = MaterialTheme.typography.bodyMedium,
                        textAlign = TextAlign.Center
                    )

                    Spacer(modifier = Modifier.width(16.dp))

                    Text(
                        text = personaje.nivel,
                        style = MaterialTheme.typography.bodyMedium,
                        textAlign = TextAlign.Center
                    )

                    Spacer(modifier = Modifier.width(16.dp))

                    Text(
                        text = personaje.modelo,
                        style = MaterialTheme.typography.bodyMedium,
                        textAlign = TextAlign.Center
                    )

                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun PersonajeCardPreview  (){
    PersonajeCard(
        modifier = Modifier,
        personaje = Personaje(
            nombre = "nombre",
            clase = "default",
            modelo = "D&D",
            nivel = "0"
        )
    )
}