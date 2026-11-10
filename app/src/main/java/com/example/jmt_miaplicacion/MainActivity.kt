package com.example.jmt_miaplicacion

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.example.jmt_miaplicacion.ui.navegacion.BottomBar
import com.example.jmt_miaplicacion.ui.navegacion.RutasHost
import com.example.jmt_miaplicacion.ui.navegacion.TopBar
import com.example.jmt_miaplicacion.ui.theme.JMTMiAplicacionTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()

            JMTMiAplicacionTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    topBar = { TopBar(navController = navController) },
                    bottomBar = { BottomBar(navController = navController) }
                ) { innerPadding ->
                    RutasHost(
                        navController = navController,
                        modifier = Modifier.fillMaxSize().padding(innerPadding)
                    )
                }
            }
        }
    }
}
