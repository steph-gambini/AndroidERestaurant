package fr.isen.gambini.androiderestaurant.model

import java.io.Serializable

data class Menu(val name_fr: String,
                val name_en: String,
                val items: List<Item>) : Serializable