package fr.isen.gambini.androiderestaurant.model
import java.io.Serializable

data class Price(
    val id: String,
    val id_pizza: String,
    val id_size: String,
    val price: String,
    val create_date: String,
    val update_date: String,
    val size: String): Serializable

enum class Size {
    Grande,
    Moyenne,
    Petite
}