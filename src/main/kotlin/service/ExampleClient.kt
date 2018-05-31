package service

import com.example.SpringBootKotlin.SpringBootKotlinApplication
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component
import org.springframework.web.client.RestTemplate

@Component
class ExampleClient(val restTemplate: RestTemplate, val quote: Quote) {

    val log = LoggerFactory.getLogger(SpringBootKotlinApplication::class.java)

    fun getForObject() {
        restTemplate.getForObject("http://gturnquist-quoters.cfapps.io/api/random", Quote::class.java)
        log.info(quote.toString())
    }

}