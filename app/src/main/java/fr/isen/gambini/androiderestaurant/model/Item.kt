package fr.isen.gambini.androiderestaurant.model

import java.io.Serializable

data class Item(
    val id: String,
    val name_fr: String,
    val name_en: String,
    val id_category: String,
    val categ_name_fr: NameCat,
    val categ_name_en: NameCat,
    val images: List<String>,
    val ingredients: List<Ingredient>,
    val prices: List<Price>): Serializable

enum class NameCat {
    Desserts,
    Entrées,
    Plats
}
