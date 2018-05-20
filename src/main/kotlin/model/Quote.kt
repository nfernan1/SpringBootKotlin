package model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties
data class Quote (
        val type : String,
        val value : Value
) {
    override fun toString(): String = "Quote { type='${this.type}\', value=${this.value}}"
}