package controller

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class AppController {

    @RequestMapping("/")
    fun index() = "This is home!"

}