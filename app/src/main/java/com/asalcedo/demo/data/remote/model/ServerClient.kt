package com.asalcedo.demo.data.remote.model

import com.asalcedo.demo.domain.model.ClientModel
import com.google.gson.annotations.SerializedName

data class ServerClient(
    @SerializedName("ciudad")
    val ciudad: String,
    @SerializedName("contactos")
    val contactos: String,
    @SerializedName("cuit_rfc")
    val cuitRrfc: String,
    @SerializedName("domicilio")
    val domicilio: String,
    @SerializedName("email")
    val email: String,
    @SerializedName("es_activo")
    val esActivo: String,
    @SerializedName("es_suspendido")
    val esSuspendido: String,
    @SerializedName("fecha_suspendido")
    val fechaSuspendido: String,
    @SerializedName("id")
    val id: String,
    @SerializedName("last_update")
    val lastUpdate: String,
    @SerializedName("nombre")
    val nombre: String,
    @SerializedName("razon_social")
    val razonSocial: String,
    @SerializedName("telefonos")
    val telefonos: String
)

fun ServerClient.toDomain() =
    ClientModel(
        ciudad = ciudad,
        contactos = contactos,
        cuitRrfc = cuitRrfc,
        domicilio = domicilio,
        email = email,
        esActivo = esActivo,
        esSuspendido = esSuspendido,
        fechaSuspendido = fechaSuspendido,
        id = id,
        lastUpdate = lastUpdate,
        nombre = nombre,
        razonSocial = razonSocial,
        telefonos = telefonos
    )
