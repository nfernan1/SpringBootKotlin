package model

import com.fasterxml.jackson.annotation.*

@JsonIgnoreProperties(ignoreUnknown = true)
class DTOYelp {

    @JsonProperty("businesses")
    var businesses = ArrayList<RestaurantInfo>()

    override fun toString(): String = "Yelp { businesses='${this.businesses}'}"
}
