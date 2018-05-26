package model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
class DTOYelp {
    val total: Int = 0
    var businesses = ArrayList<String>()
    override fun toString(): String = "Yelp { businesses='${this.businesses}'}"
}
