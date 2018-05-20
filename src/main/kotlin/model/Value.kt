package model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties
data class Value (
        val id : Long,
        val quote : String
) {
    override fun toString(): String = "Value { isd='${this.id}\', quote=${this.quote}}"
}