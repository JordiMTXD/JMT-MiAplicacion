package com.example.jmt_miaplicacion.ui.navegacion

import androidx.compose.material3.Icon
import androidx.compose.material3.*
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavHostController
import com.example.jmt_miaplicacion.R

@Composable
fun BottomBar(
    navController: NavHostController
){
    NavigationBar() {

        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route

        NavigationBarItem(
            selected = currentRoute == Rutas.HOME,
            onClick = { navController.navigate(Rutas.HOME)},
            icon = { Icon(painter = painterResource(R.drawable.home), contentDescription = "Home")},
            label = { Text("Home")}
        )
        NavigationBarItem(
            selected = currentRoute == Rutas.PERSONAJES,
            onClick = { navController.navigate(Rutas.PERSONAJES)},
            icon = { Icon(painter = painterResource(R.drawable.lists_icon), contentDescription = "Recetas")},
            label = { Text("Recetas")}
        )

        NavigationBarItem(
            selected = currentRoute == Rutas.PERFIL,
            onClick = { navController.navigate(Rutas.PERFIL)},
            icon = { Icon(painter = painterResource(R.drawable.account_icon), contentDescription = "Perfil")},
            label = { Text("Perfil")}
        )
    }
}