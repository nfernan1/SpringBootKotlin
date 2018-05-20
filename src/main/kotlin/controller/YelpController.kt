package controller

import model.Yelp
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class YelpController {

    @RequestMapping("/yelpIndex")
    fun index() = "Processing " + this.javaClass.simpleName


    fun getYelpRqData(location: String, searchTerm: String) : Yelp {
        val yelpRqInput = Yelp(location, searchTerm)
        return yelpRqInput
    }
}