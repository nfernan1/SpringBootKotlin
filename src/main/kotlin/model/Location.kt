package model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
class Location {
    val city: String = ""
    val country: String = ""
    val state: String = ""
    val address: String = ""
    val zipCode: String = ""

    override fun toString(): String = "Location { city='$city', country=$country, " +
            "state=$state, address=$address, zipCode=$zipCode}"
}