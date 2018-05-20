package controller

import model.Comment
import model.Yelp
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController
import service.YelpController
import service.YelpService
import java.time.Instant

@RestController
class AppController {

    @RequestMapping("/")
    fun index() = "This is home!"

    @RequestMapping("/comment")
    fun getComment() : Comment {
        val comment = Comment(
                "codebeast",
                "love Kotlin",
                Instant.now()
        )
        return comment
    }

    @RequestMapping("/yelp", method = [(RequestMethod.PUT)])
    fun getYelpRq(@RequestBody input: Yelp) : Yelp {
        val yelpController = YelpService()
        return yelpController.getYelpRqData(input)
    }
}