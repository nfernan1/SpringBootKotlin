package controller

import model.Comment
import model.Yelp
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
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

    @RequestMapping("/yelp", method = RequestMapping.Post)
    fun getYelpRq() : Yelp {
        val yelpController = YelpController()
        return yelpController.getYelpRqData()
    }
}