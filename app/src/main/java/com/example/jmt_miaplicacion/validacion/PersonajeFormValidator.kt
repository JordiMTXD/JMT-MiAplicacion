package com.example.jmt_miaplicacion.validacion

object PersonajeFormValidator {

    fun validarNombre(nombre: String): String? {
        return if (nombre.isBlank()) {
            "El nombre es obligatorio"
        } else { null }
    }

    fun validarClase(clase: String): String? {
        return if (clase.isBlank()) {
            "La clase es obligatoria"
        } else { null }
    }

    fun validarModelo(modelo: String): String? {
        return if (modelo.isBlank()) {
            "El sistema es obligatorio"
        } else { null }
    }

    fun validarNivel(nivel: Int): String?{
        return if (nivel <= 0 || nivel > 20) {
            "El nivel tiene que ser entre 1 y 20"
        } else {
            null
        }
    }
}
