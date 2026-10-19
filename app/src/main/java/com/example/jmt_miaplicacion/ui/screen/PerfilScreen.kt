package com.example.jmt_miaplicacion.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jmt_miaplicacion.R

@Composable
fun PerfilScreen(
    modifier: Modifier
){
    Column(
        modifier = modifier
    )  {
        Surface(
            modifier = modifier.fillMaxWidth().weight(0.3f,true)
        ) {
            Column(
                modifier = modifier.padding(10.dp).fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    modifier = Modifier
                        .weight(0.7f).aspectRatio(1f).clip(CircleShape),
                    painter = painterResource(R.drawable.perfil_icon),
                    contentDescription = "Foto perfil",
                    contentScale = ContentScale.Crop
                )
                Spacer( modifier = Modifier.weight(0.1f) )
                Text(
                    modifier = Modifier
                        .weight(0.2f),
                    text = "Nombre Perfil",
                    style = MaterialTheme.typography.headlineLarge,
                )
            }
        }
        Surface(
            modifier = Modifier
                .weight(0.7f)
        ){
            Column(
                modifier = Modifier.fillMaxWidth().padding(12.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Text("3 personajes ", style = MaterialTheme.typography.bodyLarge)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PerfilScreenPreview(){
    PerfilScreen(
        modifier = Modifier.fillMaxSize()
    )
}
