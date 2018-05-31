package model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties
data class Yelp(
        val location: String,
        val searchTerm: String,
        val price: String = "",
        val sortBy: String = "rating",
        val openNow: String = "",
        val openAt: String = ""
) {
    override fun toString(): String = "Yelp { location='$location', searchTerm=$searchTerm, " +
            "price=$price, sort_By=$sortBy, open_now=$openNow, open_at=$openAt}"
}
