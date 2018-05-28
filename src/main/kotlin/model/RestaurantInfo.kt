package model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
class RestaurantInfo {
    val name: String = ""
    val url: String = ""
    val rating: String = ""
    val price: String = ""

    override fun toString(): String = "RestaurantInfo { name='${this.name}', url='${this.url}' }"
}