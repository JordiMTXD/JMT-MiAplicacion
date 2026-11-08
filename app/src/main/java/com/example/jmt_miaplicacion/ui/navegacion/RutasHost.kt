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
import com.example.jmt_miaplicacion.ui.screen.PersonajeFormScreen
import com.example.jmt_miaplicacion.ui.screen.PersonajeScreen

object Rutas{
    const val HOME = "home"
    const val PERSONAJES = "personajes"
    const val DETALLES = "detalles/{personajeId}"
    const val PERFIL = "perfil"
    const val NUEVO_PERSONAJE = "nuevo_personaje"
    const val EDITAR_PERSONAJE = "editar_personaje/{personajeId}"

    fun detalleConId(personajeId: Long) = "detalles/$personajeId"
    fun personajeFormConId(personajeId: Long) = "editar_personaje/$personajeId"
}

@Composable
fun RutasHost(
    navController: NavHostController,
    modifier: Modifier
) {
    val listaPersonajes = mutableListOf(
        Personaje(id = 0, nombre = "Krieg", modelo = "Pathfinder", clase = "Barbaro", nivel = 3,lore = "Lorem ipsum dolor sit amet consectetur adipiscing elit pretium, mattis tortor cubilia dui ridiculus lacinia netus natoque, ut donec convallis non libero inceptos purus."),
        Personaje(id = 1, nombre = "Cale", modelo = "D&D", clase = "Mago", nivel = 5,lore = "Lorem ipsum dolor sit amet consectetur adipiscing elit pretium, mattis tortor cubilia dui ridiculus lacinia netus natoque, ut donec convallis non libero inceptos purus."),
        Personaje(id = 2, nombre = "Aang", modelo = "D&D", clase = "Monje", nivel = 6,lore = "Lorem ipsum dolor sit amet consectetur adipiscing elit pretium, mattis tortor cubilia dui ridiculus lacinia netus natoque, ut donec convallis non libero inceptos purus."),
        Personaje(id = 3, nombre = "Jimmy", modelo = "Pathfinder", clase = "Pistolero", nivel = 4,lore = "Lorem ipsum dolor sit amet consectetur adipiscing elit pretium, mattis tortor cubilia dui ridiculus lacinia netus natoque, ut donec convallis non libero inceptos purus."),
        Personaje(id = 4, nombre = "Itthobaal", modelo = "D&D", clase = "Paladin", nivel = 20,lore = "Lorem ipsum dolor sit amet consectetur adipiscing elit pretium, mattis tortor cubilia dui ridiculus lacinia netus natoque, ut donec convallis non libero inceptos purus."),
        Personaje(id = 5, nombre = "Therrila", modelo = "D&D", clase = "Clerigo", nivel = 20, lore = "Lorem ipsum dolor sit amet consectetur adipiscing elit pretium, mattis tortor cubilia dui ridiculus lacinia netus natoque, ut donec convallis non libero inceptos purus."),
    )

    NavHost(
        navController = navController,
        startDestination = Rutas.HOME,
        modifier = modifier
    ){
        composable(Rutas.HOME){
            HomeScreen(
                modifier = Modifier,
                onCrearPersonaje = { navController.navigate(Rutas.NUEVO_PERSONAJE)},
                onVerPersonajes = { navController.navigate(Rutas.PERSONAJES)}
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
        composable(Rutas.NUEVO_PERSONAJE){
            PersonajeFormScreen(
                modifier = Modifier,
                personajeInicial = null,
                onCancelarClick = { navController.popBackStack()},
                onSaveClick = {listaPersonajes.add(it)
                navController.popBackStack()
                }
            )
        }
        composable(
            route = Rutas.EDITAR_PERSONAJE,
            arguments = listOf(navArgument("personajeId"){type = NavType.LongType})
            ){ arg ->
            PersonajeFormScreen(
                modifier = Modifier,
                onCancelarClick = {navController.popBackStack()},
                personajeInicial = listaPersonajes.find { it.id == arg.arguments?.getLong("personajeId") }!!,
                onSaveClick = {personajeActualizado ->
                    val indice = listaPersonajes.indexOfFirst { it.id == personajeActualizado.id }

                    if(indice != -1){
                        listaPersonajes[indice] = personajeActualizado
                    }
                    navController.popBackStack()
                }
            )
        }
    }
}

fun buscarPersonaje(id: Long) : Personaje {
    val listaPersonaje = listOf(
        Personaje(id = 0, nombre = "Krieg", modelo = "Pathfinder", clase = "Barbaro", nivel = 3,lore = "Lorem ipsum dolor sit amet consectetur adipiscing elit pretium, mattis tortor cubilia dui ridiculus lacinia netus natoque, ut donec convallis non libero inceptos purus."),
        Personaje(id = 1, nombre = "Cale", modelo = "D&D", clase = "Mago", nivel = 5,lore = "Lorem ipsum dolor sit amet consectetur adipiscing elit pretium, mattis tortor cubilia dui ridiculus lacinia netus natoque, ut donec convallis non libero inceptos purus."),
        Personaje(id = 2, nombre = "Aang", modelo = "D&D", clase = "Monje", nivel = 6,lore = "Lorem ipsum dolor sit amet consectetur adipiscing elit pretium, mattis tortor cubilia dui ridiculus lacinia netus natoque, ut donec convallis non libero inceptos purus."),
        Personaje(id = 3, nombre = "Jimmy", modelo = "Pathfinder", clase = "Pistolero", nivel = 4,lore = "Lorem ipsum dolor sit amet consectetur adipiscing elit pretium, mattis tortor cubilia dui ridiculus lacinia netus natoque, ut donec convallis non libero inceptos purus."),
        Personaje(id = 4, nombre = "Itthobaal", modelo = "D&D", clase = "Paladin", nivel = 20,lore = "Lorem ipsum dolor sit amet consectetur adipiscing elit pretium, mattis tortor cubilia dui ridiculus lacinia netus natoque, ut donec convallis non libero inceptos purus."),
        Personaje(id = 5, nombre = "Therrila", modelo = "D&D", clase = "Clerigo", nivel = 20, lore = "Lorem ipsum dolor sit amet consectetur adipiscing elit pretium, mattis tortor cubilia dui ridiculus lacinia netus natoque, ut donec convallis non libero inceptos purus."),
    )
    return listaPersonaje.find { it.id == id }!!
}
