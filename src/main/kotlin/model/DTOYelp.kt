package model

import com.fasterxml.jackson.annotation.*
import com.fasterxml.jackson.databind.JsonNode

@JsonIgnoreProperties(ignoreUnknown = true)
class DTOYelp {

    @JsonProperty("businesses")
    var businesses = ArrayList<JsonNode>()

    override fun toString(): String = "Yelp { businesses='${this.businesses}'}"
}
