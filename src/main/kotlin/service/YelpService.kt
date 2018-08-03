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
        val sortBy = rqInput.sortBy
        val openNow = rqInput.openNow
        val openAt = rqInput.openAt
        return Yelp(location, searchTerm, price, sortBy, openNow, openAt)
    }

    fun addHeaderElement(headers: HttpHeaders, headerName: String, headerVal: String) {
        headers.add(headerName, headerVal)
        log.info(headers.toString())
    }

    fun searchURI(rqInput: Yelp): String? {
        val uri = API_HOST + SEARCH_PATH
        val builder = UriComponentsBuilder.fromUriString(uri)
                .queryParam("location", rqInput.location)
                .queryParam("term", rqInput.searchTerm)
                .queryParam("price", rqInput.price)
                .queryParam("sortBy", rqInput.sortBy)
                .queryParam("openNow", rqInput.openNow)
                .queryParam("openAt", rqInput.openAt)
        return builder.toUriString()
    }

}