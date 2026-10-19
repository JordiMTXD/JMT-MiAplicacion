package com.example.jmt_miaplicacion.ui.navegacion

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.jmt_miaplicacion.model.Personaje
import com.example.jmt_miaplicacion.ui.screen.DetalleScreen
import com.example.jmt_miaplicacion.ui.screen.HomeScreen
import com.example.jmt_miaplicacion.ui.screen.PerfilScreen
import com.example.jmt_miaplicacion.ui.screen.PersonajeScreen

object Rutas{
    const val HOME = "home"
    const val PERSONAJES = "personajes"
    const val DETALLES = "detalles/{personajeId}"
    const val PERFIL = "perfil"

    fun detalleConId(personajeId: Long) = "detalle/$personajeId"
}

@Composable
fun RutasHost(
    navController: NavHostController,
    modifier: Modifier
) {
    val listaPersonajes = listOf(
        Personaje(id = 0, nombre = "Krieg", modelo = "Pathfinder", clase = "Barbaro", nivel = "3",lore = "" ),
        Personaje(id = 1, nombre = "Cale", modelo = "D&D", clase = "Mago", nivel = "5",lore = "" ),
        Personaje(id = 2, nombre = "Aang", modelo = "D&D", clase = "Monje", nivel = "6",lore = "" ),
        Personaje(id = 3, nombre = "Jimmy", modelo = "Pathfinder", clase = "Pistolero", nivel = "4",lore = "" ),
        Personaje(id = 4, nombre = "Itthobaal", modelo = "D&D", clase = "Paladin", nivel = "20",lore = "" ),
        Personaje(id = 5, nombre = "Therrila", modelo = "D&D", clase = "Clerigo", nivel = "20",lore = "" ),
    )

    NavHost(
        navController = navController,
        startDestination = Rutas.HOME,
        modifier = modifier
    ){
        composable(Rutas.HOME){
            HomeScreen(
                modifier = modifier,
                personaje = listaPersonajes,
                onFavPersonajeClick = {navController.navigate(Rutas.detalleConId(it))}
            )
        }
        composable(Rutas.PERSONAJES){
            PersonajeScreen(
                modifier = modifier,
                personajes = listaPersonajes,
                onPersonajeClick = {navController.navigate(Rutas.detalleConId(it))}
            )
        }
        composable(Rutas.PERFIL){
            PerfilScreen(
                modifier = modifier,
            )
        }
        composable(Rutas.DETALLES, arguments = listOf(navArgument("personajeid")
        {type = NavType.LongType})){
            DetalleScreen(
                modifier = modifier,
                personaje = buscarPersonaje(it.arguments?.getLong("personajeId")!!)
            )
        }
    }
}

fun buscarPersonaje(id: Long) : Personaje {
    val listaPersonaje = listOf(

        Personaje(id = 0, nombre = "Krieg", modelo = "Pathfinder", clase = "Barbaro", nivel = "3",lore = ""),
        Personaje(id = 1, nombre = "Cale", modelo = "D&D", clase = "Mago", nivel = "5",lore = ""),
        Personaje(id = 2, nombre = "Aang", modelo = "D&D", clase = "Monje", nivel = "6",lore = "")
    )
    return listaPersonaje.find { it.id == id }!!
}
