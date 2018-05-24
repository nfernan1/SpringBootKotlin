package model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties
data class Yelp(
        val location: String,
        val searchTerm: String,
        val price: String = ""
) {
    override fun toString(): String = "Yelp { location='${this.location}', searchTerm=${this.searchTerm}, price=${this.price}}"
}
