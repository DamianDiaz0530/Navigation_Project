package com.example.navigation_project.data

import kotlinx.serialization.Serializable

@Serializable
data class Product(
    val id: Int,
    val name: String,
    val price: Double,
    val description: String,
    val imageUrl: String = ""
)

val products = listOf(
    Product(1, "Xbox", 12999.99, "Consola de Ultima generacion"),
    Product(2, "Laptop Pro", 25999.99, "Alto rendimiento para profesionales"),
    Product(3, "Auriculares Inalámbricos", 699.99, "Cancelación de ruido activa"),
    Product(4, "Smartwatch 4", 299.99, "Seguimiento de salud avanzado"),
    Product(5, "Tablet S7", 499.99, "Pantalla AMOLED de 120Hz")
)