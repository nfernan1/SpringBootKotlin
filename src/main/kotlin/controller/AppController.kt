package controller

import com.example.SpringBootKotlin.SpringBootKotlinApplication
import model.Comment
import model.Yelp
import org.slf4j.LoggerFactory
import org.springframework.http.MediaType
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.client.RestTemplate
import service.YelpService
import java.time.Instant

@RestController
class AppController {
    private val log = LoggerFactory.getLogger(SpringBootKotlinApplication::class.java)

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

    @RequestMapping("/yelp", consumes = [(MediaType.APPLICATION_JSON_VALUE)], method = [(RequestMethod.PUT)])
    fun getYelpRq(@RequestBody input: Yelp) : Yelp {
        val yelpController = YelpService()
        log.info(yelpController.index())
        return yelpController.getYelpRqData(input)
    }

    @RequestMapping("/yelp", consumes = [(MediaType.APPLICATION_JSON_VALUE)], method = [(RequestMethod.POST)])
    fun postYelpRs(@RequestBody input: Yelp) : Yelp? {
        val yelpController = YelpService()
        log.info(yelpController.index())
        val requestData = yelpController.getYelpRqData(input)

        val restTemplate = RestTemplate()
        val response = restTemplate.getForObject(yelpController.search(requestData), Yelp::class.java)
        log.info(response.toString())
        return response
    }
}