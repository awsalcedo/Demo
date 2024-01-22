package com.asalcedo.demo.domain.model

import com.google.gson.annotations.SerializedName

data class ClientModel(
    val ciudad: String,
    val contactos: String,
    val cuitRrfc: String,
    val domicilio: String,
    val email: String,
    val esActivo: String,
    val esSuspendido: String,
    val fechaSuspendido: String,
    val id: String,
    val lastUpdate: String,
    val nombre: String,
    val razonSocial: String,
    val telefonos: String
)
