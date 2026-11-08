package com.example.jmt_miaplicacion.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jmt_miaplicacion.model.Personaje
import com.example.jmt_miaplicacion.validacion.PersonajeFormValidator

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PersonajeFormScreen(
    modifier: Modifier,
    personajeInicial: Personaje?,
    onSaveClick: (Personaje) -> Unit,
    onCancelarClick: () -> Unit
) {
    var nombre by remember {
        mutableStateOf(personajeInicial?.nombre ?: "")
    }
    var modelo by remember {
        mutableStateOf(personajeInicial?.modelo ?: "")
    }
    var clase by remember {
        mutableStateOf(personajeInicial?.clase ?: "")
    }
    var lore by remember {
        mutableStateOf(personajeInicial?.lore ?: "")
    }
    var nivel by remember {
        mutableStateOf(personajeInicial?.nivel ?: 1)
    }

    var expandedModelo by remember { mutableStateOf(false) }
    var expandedClase by remember { mutableStateOf(false) }

    var errorNombre by remember { mutableStateOf<String?>(null) }
    var errorModelo by remember { mutableStateOf<String?>(null) }
    var errorClase by remember { mutableStateOf<String?>(null) }
    var errorNivel by remember { mutableStateOf<String?>(null) }



    val modelos = listOf("D&D 5e 2014", "D&D 5e 2020")
    val clases = listOf(
        "Barbaro", "Mago", "Brujo", "Druida", "Guerrero", "Bardo", "Clerigo", "Explorador",
        "Hechicero", "Mago", "Monje", "Picaro", "Paladin", "Artificiero", "Cazador de Sangre"
    )


    Column(
        modifier = modifier.padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        ///Nombre
        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth(),
            value = nombre,
            onValueChange = { nombre = it },
            label = { Text("Nombre") },
            isError = errorNombre != null,
            supportingText = {
                errorNombre?.let {
                    Text(
                        text = it,
                        color = MaterialTheme.colorScheme.error
                    )
                }
            }
        )
        //Modelo
        ExposedDropdownMenuBox(
            expanded = expandedModelo,
            onExpandedChange = { expandedModelo = !expandedModelo },
            modifier = Modifier.fillMaxWidth()
        ) {
            OutlinedTextField(
                value = modelo,
                onValueChange = {},
                readOnly = true,
                label = { Text("Modelo") },
                placeholder = { Text("Seleciona un modelo") },
                trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expandedModelo) },
                modifier = Modifier
                    .menuAnchor(androidx.compose.material3.MenuAnchorType.PrimaryNotEditable)
                    .fillMaxWidth(),
                isError = errorModelo != null,
                supportingText = {
                    errorModelo?.let {
                        Text(text = it,)
                    }
                }
            )
            ExposedDropdownMenu(
                expanded = expandedModelo,
                onDismissRequest = {
                    expandedModelo = false
                }
            ) {
                modelos.forEach { opcion ->
                    DropdownMenuItem(
                        text = { Text(opcion) },
                        onClick = {
                            modelo = opcion
                            expandedModelo = false
                            errorModelo = null
                        }
                    )
                }
            }
        }
        ///Clase
        ExposedDropdownMenuBox(
            expanded = expandedClase,
            onExpandedChange = { expandedClase = !expandedClase },
            modifier = Modifier.fillMaxWidth()
        ) {
            OutlinedTextField(
                value = clase,
                onValueChange = {},
                readOnly = true,
                label = { Text("Clase") },
                placeholder = { Text("Seleciona una clase") },
                trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expandedClase) },
                modifier = Modifier
                    .menuAnchor(androidx.compose.material3.MenuAnchorType.PrimaryNotEditable)
                    .fillMaxWidth(),
                isError = errorClase != null,
                supportingText = {
                    errorClase?.let {
                        Text(text = it,)
                    }
                }
            )
            ExposedDropdownMenu(
                expanded = expandedClase,
                onDismissRequest = {
                    expandedClase = false
                }
            ) {
                clases.forEach { opcion ->
                    DropdownMenuItem(
                        text = { Text(opcion) },
                        onClick = {
                            clase = opcion
                            expandedClase = false
                            errorClase = null
                        }
                    )
                }
            }
        }
        ///Nivel
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = nivel.toString(),
            onValueChange = { valor ->
                if (valor.all { it.isDigit() } && valor.length <= 2) {
                    nivel = valor.toIntOrNull() ?: 0
                }
            },
            label = { Text("Nivel") },
            placeholder = { Text("Introduce el nivel") },
            isError = errorNivel != null,
            supportingText = {
                errorNivel?.let {
                    Text(
                        text = it,
                        color = MaterialTheme.colorScheme.error
                    )
                }
            }
        )

        ///Lore
        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            value = lore,
            onValueChange = { lore = it },
            label = { Text("Lore") }

        )

        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp, Alignment.End)
        ) {

            Button (
                onClick = {
                    onCancelarClick()
                }
            ) {
                Text("Cancelar")
            }

            Button(
                onClick = {
                    errorNivel = PersonajeFormValidator.validarNivel(nivel)
                    errorNombre = PersonajeFormValidator.validarNombre(nombre)
                    errorModelo = PersonajeFormValidator.validarModelo(modelo)
                    errorClase = PersonajeFormValidator.validarClase(clase)

                    if (errorNombre == null && errorModelo == null &&
                        errorClase == null && errorNivel == null){
                        onSaveClick(
                            Personaje(
                                id = personajeInicial?.id ?: 0,
                                nombre = nombre,
                                modelo = modelo,
                                clase = clase,
                                nivel = nivel,
                                lore = lore
                            )
                        )
                    }
                }

            ) {
                Text("Guardar")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PersonajeFormScreenPreview(){

    PersonajeFormScreen(
        modifier = Modifier.fillMaxSize(),
        onSaveClick = { },
        onCancelarClick = { },
        personajeInicial = null
    )
}
