package service

import com.example.SpringBootKotlin.SpringBootKotlinApplication
import model.Yelp
import org.slf4j.LoggerFactory
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.util.UriComponentsBuilder

class YelpService {
    private val log = LoggerFactory.getLogger(SpringBootKotlinApplication::class.java)

    val API_HOST = "https://api.yelp.com"
    val SEARCH_PATH = "/v3/businesses/search"
    val BUSINESS_PATH = "/v3/businesses"

    val authToken = "APWTH51GSB0HBqKyK26QxxQdNYATj_b9n075LwlI8tH953KdWHF6p2IZ1VMojmKDKyj0cxFKepj7I1rXEmVUYFzeMHGxYFQBVOGqmjgvvAG7xV3KE0nEN41r6oHbWnYx"

    @RequestMapping("/yelpIndex")
    fun index() = "Processing " + this.javaClass.simpleName + "..."


    fun getYelpRqData(rqInput: Yelp) : Yelp {

        val location = rqInput.location
        val searchTerm = rqInput.searchTerm
        val price = rqInput.price
        val yelpRqInput = Yelp(location, searchTerm, price)
        return yelpRqInput
    }

    fun addHeaderElement(headerName: String, headerVal: String): ResponseEntity<String> {

        val headers = HttpHeaders()
        headers.add(headerName, headerVal)
        log.info(headers.toString())
        return ResponseEntity<String>(headers, HttpStatus.OK)
    }

    fun request(host: String, path: String, auth: String) {

        val bearerToken = "Bearer " + auth
        addHeaderElement("Authorization", bearerToken)
}

    fun search(rqInput: Yelp): String? {
        addHeaderElement("Authorization", "Bearer ${authToken}")
        val uri = API_HOST + SEARCH_PATH
        val builder = UriComponentsBuilder.fromUriString(uri)
                .queryParam("location", rqInput.location)
                .queryParam("term", rqInput.searchTerm)
                .queryParam("price", rqInput.price)
        return builder.toUriString()
    }

}