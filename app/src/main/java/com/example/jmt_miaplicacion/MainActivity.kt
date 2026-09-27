package com.example.jmt_miaplicacion

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jmt_miaplicacion.model.Personaje
import com.example.jmt_miaplicacion.ui.screen.PersonajesScreen
import com.example.jmt_miaplicacion.ui.theme.JMTMiAplicacionTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JMTMiAplicacionTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    PersonajesScreen(
                        modifier = Modifier.fillMaxSize().padding(innerPadding).padding(8.dp),
                        personajes = listOf(
                            Personaje(
                                nombre = "nombre",
                                clase = "default",
                                modelo = "D&D",
                                nivel = "0"
                                )
                        ),
                    )
                }
            }
        }
    }
}
