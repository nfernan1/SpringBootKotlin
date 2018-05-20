package service

import model.Yelp
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class YelpService {

    @RequestMapping("/yelpIndex")
    fun index() = "Processing " + this.javaClass.simpleName + "..."


    fun getYelpRqData(rqInput: Yelp) : Yelp {
        val location = rqInput.location
        val searchTerm = rqInput.searchTerm
        val yelpRqInput = Yelp(location, searchTerm)
        return yelpRqInput
    }
}