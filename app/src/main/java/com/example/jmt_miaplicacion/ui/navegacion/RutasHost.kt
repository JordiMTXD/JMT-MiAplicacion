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

    fun detalleConId(personajeId: Long) = "detalles/$personajeId"
}

@Composable
fun RutasHost(
    navController: NavHostController,
    modifier: Modifier
) {
    val listaPersonajes = listOf(
        Personaje(id = 0, nombre = "Krieg", modelo = "Pathfinder", clase = "Barbaro", nivel = "3",lore = "Lorem ipsum dolor sit amet consectetur adipiscing elit pretium, mattis tortor cubilia dui ridiculus lacinia netus natoque, ut donec convallis non libero inceptos purus."),
        Personaje(id = 1, nombre = "Cale", modelo = "D&D", clase = "Mago", nivel = "5",lore = "Lorem ipsum dolor sit amet consectetur adipiscing elit pretium, mattis tortor cubilia dui ridiculus lacinia netus natoque, ut donec convallis non libero inceptos purus."),
        Personaje(id = 2, nombre = "Aang", modelo = "D&D", clase = "Monje", nivel = "6",lore = "Lorem ipsum dolor sit amet consectetur adipiscing elit pretium, mattis tortor cubilia dui ridiculus lacinia netus natoque, ut donec convallis non libero inceptos purus."),
        Personaje(id = 3, nombre = "Jimmy", modelo = "Pathfinder", clase = "Pistolero", nivel = "4",lore = "Lorem ipsum dolor sit amet consectetur adipiscing elit pretium, mattis tortor cubilia dui ridiculus lacinia netus natoque, ut donec convallis non libero inceptos purus."),
        Personaje(id = 4, nombre = "Itthobaal", modelo = "D&D", clase = "Paladin", nivel = "20",lore = "Lorem ipsum dolor sit amet consectetur adipiscing elit pretium, mattis tortor cubilia dui ridiculus lacinia netus natoque, ut donec convallis non libero inceptos purus."),
        Personaje(id = 5, nombre = "Therrila", modelo = "D&D", clase = "Clerigo", nivel = "20", lore = "Lorem ipsum dolor sit amet consectetur adipiscing elit pretium, mattis tortor cubilia dui ridiculus lacinia netus natoque, ut donec convallis non libero inceptos purus."),
    )

    NavHost(
        navController = navController,
        startDestination = Rutas.HOME,
        modifier = modifier
    ){
        composable(Rutas.HOME){
            HomeScreen(
                modifier = Modifier,
                personaje = listaPersonajes,
                onFavPersonajeClick = {navController.navigate(Rutas.detalleConId(it))}
            )
        }
        composable(Rutas.PERSONAJES){
            PersonajeScreen(
                modifier = Modifier,
                personajes = listaPersonajes,
                onPersonajeClick = {navController.navigate(Rutas.detalleConId(it))}
            )
        }
        composable(Rutas.PERFIL){
            PerfilScreen(
                modifier = Modifier,
            )
        }
        composable(Rutas.DETALLES, arguments = listOf(navArgument("personajeId")
        {type = NavType.LongType})){
            DetalleScreen(
                modifier = Modifier,
                personaje = buscarPersonaje(it.arguments?.getLong("personajeId")!!)
            )
        }
    }
}

fun buscarPersonaje(id: Long) : Personaje {
    val listaPersonaje = listOf(
        Personaje(id = 0, nombre = "Krieg", modelo = "Pathfinder", clase = "Barbaro", nivel = "3",lore = "Lorem ipsum dolor sit amet consectetur adipiscing elit pretium, mattis tortor cubilia dui ridiculus lacinia netus natoque, ut donec convallis non libero inceptos purus."),
        Personaje(id = 1, nombre = "Cale", modelo = "D&D", clase = "Mago", nivel = "5",lore = "Lorem ipsum dolor sit amet consectetur adipiscing elit pretium, mattis tortor cubilia dui ridiculus lacinia netus natoque, ut donec convallis non libero inceptos purus."),
        Personaje(id = 2, nombre = "Aang", modelo = "D&D", clase = "Monje", nivel = "6",lore = "Lorem ipsum dolor sit amet consectetur adipiscing elit pretium, mattis tortor cubilia dui ridiculus lacinia netus natoque, ut donec convallis non libero inceptos purus."),
        Personaje(id = 3, nombre = "Jimmy", modelo = "Pathfinder", clase = "Pistolero", nivel = "4",lore = "Lorem ipsum dolor sit amet consectetur adipiscing elit pretium, mattis tortor cubilia dui ridiculus lacinia netus natoque, ut donec convallis non libero inceptos purus."),
        Personaje(id = 4, nombre = "Itthobaal", modelo = "D&D", clase = "Paladin", nivel = "20",lore = "Lorem ipsum dolor sit amet consectetur adipiscing elit pretium, mattis tortor cubilia dui ridiculus lacinia netus natoque, ut donec convallis non libero inceptos purus."),
        Personaje(id = 5, nombre = "Therrila", modelo = "D&D", clase = "Clerigo", nivel = "20", lore = "Lorem ipsum dolor sit amet consectetur adipiscing elit pretium, mattis tortor cubilia dui ridiculus lacinia netus natoque, ut donec convallis non libero inceptos purus."),
    )
    return listaPersonaje.find { it.id == id }!!
}
