package com.example.jmt_miaplicacion.ui.navegacion

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.jmt_miaplicacion.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar (
    navController: NavController
) {

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    TopAppBar(
        title = {
            Text( text =
                when (currentRoute) {
                    Rutas.HOME -> "Personajes App"
                    Rutas.DETALLES -> "Receta"
                    Rutas.PERFIL -> "Mi perfil"
                    Rutas.PERSONAJES -> "Todos mis Personajes"
                    else -> ""
                },
                style = MaterialTheme.typography.headlineLarge
            )
        },
        navigationIcon = {
            if(currentRoute != Rutas.HOME) {
                IconButton(onClick = {navController.popBackStack() }) {
                    Icon(painter = painterResource(R.drawable.arrow_back), contentDescription = "Volver" )
                }
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer,
            titleContentColor = MaterialTheme.colorScheme.onPrimaryContainer
        )
    )

}