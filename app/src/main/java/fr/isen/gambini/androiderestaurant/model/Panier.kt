package fr.isen.gambini.androiderestaurant.model

import java.io.Serializable

data class Panier (
    var content:MutableList<PanierItem>
)

data class PanierItem (
    var name_fr: String,
    var quantity: Int,
    val unit_price: Float,
    val image : String
): Serializable