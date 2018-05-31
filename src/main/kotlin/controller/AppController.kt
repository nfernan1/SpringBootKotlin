package controller

import com.example.SpringBootKotlin.SpringBootKotlinApplication
import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.ObjectMapper
import model.Comment
import model.DTOYelp
import model.Yelp
import org.slf4j.LoggerFactory
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*
import org.springframework.web.client.RestTemplate
import service.YelpService
import java.time.Instant
import org.springframework.http.HttpMethod


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

    @RequestMapping("/yelp/jsonRs", consumes = [(MediaType.APPLICATION_JSON_VALUE)], method = [(RequestMethod.POST)])
    fun postYelpJsonRs(@RequestBody input: Yelp): JsonNode? {
        val yelpController = YelpService()
        log.info(yelpController.index())
        val requestData = yelpController.getYelpRqData(input)

        val restTemplate = RestTemplate()
        val responseEntity = yelpController.addHeaderElement( "Authorization", "Bearer ${yelpController.authToken}")
        val json = restTemplate.exchange(yelpController.searchURI(requestData), HttpMethod.GET, responseEntity, String::class.java)
        val mapper = ObjectMapper()
        return  mapper.readTree(json.body)
    }

    @RequestMapping("/yelp", consumes = [(MediaType.APPLICATION_JSON_VALUE)], method = [(RequestMethod.POST)])
    fun postYelpRs(@RequestBody input: Yelp): DTOYelp? {
        val yelpController = YelpService()
        log.info(yelpController.index())
        val requestData = yelpController.getYelpRqData(input)

        val restTemplate = RestTemplate()
        val responseEntity = yelpController.addHeaderElement( "Authorization", "Bearer ${yelpController.authToken}")
        val response = restTemplate.exchange(yelpController.searchURI(requestData), HttpMethod.GET, responseEntity, DTOYelp()::class.java)
        return response.body
    }
}