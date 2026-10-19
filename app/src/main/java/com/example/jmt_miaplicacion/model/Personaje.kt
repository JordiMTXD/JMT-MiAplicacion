package com.example.jmt_miaplicacion.model

data class Personaje (
    val id: Long,
    val nombre: String,
    val modelo: String, /// Tipo de juego de rol y version
    val clase: String,
    val nivel: String,
    val lore: String
)
