package com.example.SpringBootKotlin

import controller.AppController
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean

@SpringBootApplication
class SpringBootKotlinApplication {
    @Bean
    fun controller() = AppController()
}
fun main(args: Array<String>) {
    runApplication<SpringBootKotlinApplication>(*args)
}

